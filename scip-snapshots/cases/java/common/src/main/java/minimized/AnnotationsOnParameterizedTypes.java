package minimized;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public interface AnnotationsOnParameterizedTypes {

  public static AnnotationsOnParameterizedTypes getInstance() {
    return new AnnotationsOnParameterizedTypesImpl();
  }

  <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass);
}


class AnnotationsOnParameterizedTypesImpl implements AnnotationsOnParameterizedTypes {
  private ConcurrentMap<Class<?>, Constructor<?>> proxyConstructors = new ConcurrentHashMap<>();

  @Override
  public <C, W> Function<W, C> adapter(Class<C> contract, Class<W> wrappedClass) {

    Function<InvocationHandler, C> constructor = getConstructor(contract);

    System.out.println(constructor);

    return null;
  }

  private <T> Function<InvocationHandler, T> getConstructor(Class<T> contract) {
    @SuppressWarnings("unchecked")
    Constructor<T> constructor = (Constructor<T>) proxyConstructors.computeIfAbsent(contract, c -> {
      return null;
    });

    System.out.println(constructor);

    return null;
  }
}