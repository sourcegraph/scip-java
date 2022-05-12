package com.sourcegraph.semanticdb_javac;

import static net.bytebuddy.implementation.bytecode.assign.Assigner.Typing.DYNAMIC;
import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.instrument.Instrumentation;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;

/** Java agent that injects SemanticDB into the Java compilation process. */
public class SemanticdbAgent {

  public static void premain(String agentArgs, Instrumentation inst) {
    // NOTE(olafur): Uncoment below if you want see all the loaded classes.
    //    PrintStream logger = newLogger();
    //    inst.addTransformer(
    //        new ClassFileTransformer() {
    //          @Override
    //          public byte[] transform(
    //              ClassLoader loader,
    //              String className,
    //              Class<?> classBeingRedefined,
    //              ProtectionDomain protectionDomain,
    //              byte[] classfileBuffer) {
    //            logger.println(className);
    //            return classfileBuffer;
    //          }
    //        });
    new AgentBuilder.Default()
        .disableClassFormatChanges()
        .type(
            named("org.gradle.api.internal.tasks.compile.DefaultJvmLanguageCompileSpec")
                .or(named("tests.GradleDefaultJvmLanguageCompileSpec")))
        .transform(
            new AgentBuilder.Transformer.ForAdvice()
                .advice(
                    named("getCompileClasspath"),
                    DefaultJvmLanguageCompileSpecAdvice.class.getName()))
        .installOn(inst);
    new AgentBuilder.Default()
        .disableClassFormatChanges()
        .type(
            named("org.gradle.api.internal.tasks.compile.DefaultJavaCompileSpec")
                .or(named("tests.GradleDefaultJavaCompileSpec")))
        .transform(
            new AgentBuilder.Transformer.ForAdvice()
                .advice(
                    named("getAnnotationProcessorPath"),
                    DefaultJavaCompileSpecAdvice.class.getName()))
        .installOn(inst);
    new AgentBuilder.Default()
        .type(
            named("org.gradle.api.internal.tasks.compile.JavaCompilerArgumentsBuilder")
                .or(named("tests.GradleJavaCompilerArgumentsBuilder")))
        .transform(
            new AgentBuilder.Transformer.ForAdvice()
                .advice(named("build"), JavaCompilerArgumentsBuilderAdvice.class.getName()))
        .installOn(inst);
  }

  private static PrintStream newLogger() {
    Path path = Paths.get(System.getProperty("user.home"), ".scip-java", "logs.txt");
    try {
      Files.createDirectories(path.getParent());
      OutputStream fos =
          Files.newOutputStream(
              path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
      return new PrintStream(fos);
    } catch (IOException e) {
      return new PrintStream(
          new OutputStream() {
            @Override
            public void write(int b) {}
          });
    }
  }

  @SuppressWarnings("all")
  public static class DefaultJvmLanguageCompileSpecAdvice {
    @Advice.OnMethodExit
    public static void getClasspath(
        @Advice.Return(readOnly = false, typing = DYNAMIC) List<File> classpath) {
      String PLUGINPATH = System.getProperty("semanticdb.pluginpath");
      if (PLUGINPATH == null) throw new NoSuchElementException("-Dsemanticdb.pluginpath");
      File semanticdbJar = new File(PLUGINPATH);
      if (!classpath.contains(semanticdbJar)) {
        List<File> newClasspath = new ArrayList<>(classpath);
        newClasspath.add(semanticdbJar);
        classpath = newClasspath;
      }
    }
  }

  @SuppressWarnings("all")
  public static class DefaultJavaCompileSpecAdvice {
    @Advice.OnMethodExit
    public static void getAnnotationProcessorPath(
        @Advice.Return(readOnly = false, typing = DYNAMIC) List<File> classpath) {
      if (classpath == null) return;
      String PLUGINPATH = System.getProperty("semanticdb.pluginpath");
      if (PLUGINPATH == null) throw new NoSuchElementException("-Dsemanticdb.pluginpath");
      File semanticdbJar = new File(PLUGINPATH);
      if (!classpath.contains(semanticdbJar)) {
        List<File> newClasspath = new ArrayList<>(classpath);
        newClasspath.add(semanticdbJar);
        classpath = newClasspath;
      }
    }
  }

  @SuppressWarnings("all")
  public static class JavaCompilerArgumentsBuilderAdvice {

    /**
     * The bytecode of this method gets injected at the end of the following method in Gradle:
     *
     * <p>https://github.com/gradle/gradle/blob/2389365c6e0f29cb84b4727a793fe7a7008c9fc7/subprojects/language-java/src/main/java/org/gradle/api/internal/tasks/compile/JavaCompilerArgumentsBuilder.java#L78
     *
     * @param arguments The Java compiler that Gradle intends to use. This method updates the
     *     options to include "-Xplugin:semanticdb".
     */
    @Advice.OnMethodExit
    public static void build(
        @Advice.Return(readOnly = false, typing = DYNAMIC) List<String> arguments) {

      String PLUGINPATH = System.getProperty("semanticdb.pluginpath");
      if (PLUGINPATH == null) throw new NoSuchElementException("-Dsemanticdb.pluginpath");
      String SOURCEROOT = System.getProperty("semanticdb.sourceroot");
      if (SOURCEROOT == null) throw new NoSuchElementException("-Dsemanticdb.sourceroot");
      String TARGETROOT = System.getProperty("semanticdb.targetroot");
      if (TARGETROOT == null) throw new NoSuchElementException("-Dsemanticdb.targetroot");
      String DEBUGPATH = System.getProperty("semanticdb.debugpath");
      String JAVACOPTS = System.getProperty("semanticdb.javacopts");
      if (JAVACOPTS != null) {
        try {
          Files.write(
              Paths.get(JAVACOPTS),
              arguments,
              StandardCharsets.UTF_8,
              StandardOpenOption.APPEND,
              StandardOpenOption.CREATE);
        } catch (IOException unused) {
        }
      }

      boolean isProcessorpathUpdated = false;
      String previousOption = "";

      ArrayList<String> newOptions = new ArrayList<>();
      for (String option : arguments) {
        switch (previousOption) {
          case "-processorpath":
          case "-processor-path":
          case "-cp":
          case "-classpath":
          case "-class-path":
            isProcessorpathUpdated = true;
            newOptions.add(PLUGINPATH + File.pathSeparator + option);
            break;
          case "-Xlint":
            break;
          default:
            if (option.startsWith("-Xplugin:ErrorProne")) {
              break;
            }
            newOptions.add(option);
            break;
        }
        previousOption = option;
      }
      if (!isProcessorpathUpdated) {
        newOptions.add("-classpath");
        newOptions.add(PLUGINPATH);
      }
      newOptions.add(
          String.format(
              "-Xplugin:semanticdb -sourceroot:%s -targetroot:%s", SOURCEROOT, TARGETROOT));

      if (DEBUGPATH != null) {
        ArrayList<String> debuglines = new ArrayList<>();
        debuglines.add("============== Java Home: " + System.getProperty("java.home"));
        debuglines.add("============== Old Options");
        debuglines.addAll(arguments);
        debuglines.add("============== New Options");
        debuglines.addAll(newOptions);

        try {
          Files.write(
              Paths.get(DEBUGPATH),
              debuglines,
              StandardOpenOption.CREATE,
              StandardOpenOption.APPEND);
        } catch (IOException e) {
        }
      }

      arguments = newOptions;
    }
  }
}
