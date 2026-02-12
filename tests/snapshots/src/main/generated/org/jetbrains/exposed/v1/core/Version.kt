  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  import java.util.*
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/util/
  
  class Version @InternalApi constructor(val major: Int, val minor: Int, val patch: Int) {
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#
//              display_name Version
//              documentation ```kotlin\npublic final class Version : Any\n```
//                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().
//                                       display_name Version
//                                       documentation ```kotlin\n@InternalApi() public constructor(major: Int, minor: Int, patch: Int): Version\n```
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().(major)
//                                                 display_name major
//                                                 documentation ```kotlin\nmajor: Int\n```
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().(major)
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//                                                 display_name major
//                                                 documentation ```kotlin\npublic get(): Int\n```
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
//                                                 display_name major
//                                                 documentation ```kotlin\npublic final val major: Int\n```
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().(minor)
//                                                                 display_name minor
//                                                                 documentation ```kotlin\nminor: Int\n```
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().(minor)
//                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//                                                                 display_name minor
//                                                                 documentation ```kotlin\npublic get(): Int\n```
//                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
//                                                                 display_name minor
//                                                                 documentation ```kotlin\npublic final val minor: Int\n```
//                                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().(patch)
//                                                                                 display_name patch
//                                                                                 documentation ```kotlin\npatch: Int\n```
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().(patch)
//                                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getPatch().
//                                                                                 display_name patch
//                                                                                 documentation ```kotlin\npublic get(): Int\n```
//                                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#patch.
//                                                                                 display_name patch
//                                                                                 documentation ```kotlin\npublic final val patch: Int\n```
//                                                                                  ^^^ reference semanticdb maven . . kotlin/Int#
  
      fun covers(version: Version): Boolean {
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().
//               display_name covers
//               documentation ```kotlin\npublic final fun covers(version: Version): Boolean\n```
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().(version)
//                       display_name version
//                       documentation ```kotlin\nversion: Version\n```
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (major > version.major) return true
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
//                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().(version)
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
          if (major < version.major) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
//                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().(version)
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
  
          if (minor > version.minor) return true
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
//                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().(version)
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
          if (minor < version.minor) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
//                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().(version)
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
  
          if (patch >= version.patch) return true
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getPatch().
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#patch.
//                  ^^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().(version)
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getPatch().
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#patch.
          return false
      }
  
      fun covers(version: String): Boolean = covers(from(version))
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+1).
//               display_name covers
//               documentation ```kotlin\npublic final fun covers(version: String): Boolean\n```
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+1).(version)
//                       display_name version
//                       documentation ```kotlin\nversion: String\n```
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from().
//                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+1).(version)
  
      fun covers(version: BigDecimal): Boolean = covers(from(version))
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+2).
//               display_name covers
//               documentation ```kotlin\npublic final fun covers(version: BigDecimal): Boolean\n```
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+2).(version)
//                       display_name version
//                       documentation ```kotlin\nversion: BigDecimal\n```
//                        ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from(+1).
//                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+2).(version)
  
      @OptIn(InternalApi::class)
      fun covers(major: Int, minor: Int = 0, patch: Int = 0): Boolean = covers(Version(major, minor, patch))
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).
//               display_name covers
//               documentation ```kotlin\n@OptIn(...) public final fun covers(major: Int, minor: Int = ..., patch: Int = ...): Boolean\n```
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).(major)
//                     display_name major
//                     documentation ```kotlin\nmajor: Int\n```
//                      ^^^ reference semanticdb maven . . kotlin/Int#
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).(minor)
//                                 display_name minor
//                                 documentation ```kotlin\nminor: Int = ...\n```
//                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).(patch)
//                                                 display_name patch
//                                                 documentation ```kotlin\npatch: Int = ...\n```
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers().
//                                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).(major)
//                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).(minor)
//                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#covers(+3).(patch)
  
      override fun toString() = "$major.$minor.$patch"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getPatch().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#patch.
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().(other)
          if (javaClass != other?.javaClass) return false
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().(other)
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/getJavaClass().
//                                ^^^^^^^^^ reference semanticdb maven . . kotlin/jvm/javaClass.
  
          other as Version
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().(other)
  
          return major == other.major && minor == other.minor && patch == other.patch
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().(other)
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().(other)
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getPatch().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#patch.
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#equals().(other)
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getPatch().
//                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#patch.
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          return Objects.hash(major, minor, patch)
//                       ^^^^ reference semanticdb maven jdk 11 java/util/Objects#hash().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMajor().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#major.
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getMinor().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#minor.
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#getPatch().
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#patch.
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion# 14:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#`<init>`(). 14:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): Version.Companion\n```
          private val versionRegex = Regex("""^(\d+)(?:\.(\d+))?(?:\.(\d+))?(\D)?(.*)?""")
//                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#getVersionRegex().
//                                 display_name versionRegex
//                                 documentation ```kotlin\nprivate get(): Regex\n```
//                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#versionRegex.
//                                 display_name versionRegex
//                                 documentation ```kotlin\nprivate final val versionRegex: Regex\n```
//                                   ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
  
          @OptIn(InternalApi::class)
          fun from(version: String): Version {
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from().
//                 display_name from
//                 documentation ```kotlin\n@OptIn(...) public final fun from(version: String): Version\n```
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from().(version)
//                         display_name version
//                         documentation ```kotlin\nversion: String\n```
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#
              val matchResult = versionRegex.find(version)
//                ^^^^^^^^^^^ definition local 0
//                            display_name matchResult
//                            documentation ```kotlin\nlocal val matchResult: MatchResult\n```
//                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#getVersionRegex().
//                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#versionRegex.
//                                           ^^^^ reference semanticdb maven . . kotlin/text/Regex#find().
//                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from().(version)
                  ?: throw IllegalArgumentException("Invalid version format: $version")
//                         ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`().
//                                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from().(version)
  
              val parts = (1..3).map { matchResult.groupValues[it].takeIf { it.isNotEmpty() }?.toInt() ?: 0 }
//                ^^^^^ definition local 1
//                      display_name parts
//                      documentation ```kotlin\nlocal val parts: List<Int>\n```
//                          ^^ reference semanticdb maven . . kotlin/Int#rangeTo(+2).
//                               ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                            display_name it
//                                                                                                            documentation ```kotlin\nit: String\n```
//                                     ^^^^^^^^^^^ reference local 0
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/MatchResult#getGroupValues().
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/MatchResult#groupValues.
//                                                             ^^ reference semanticdb maven . . (it)
//                                                                 ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                                        ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                            display_name it
//                                                                                            documentation ```kotlin\nit: String\n```
//                                                                          ^^ reference semanticdb maven . . (it)
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/isNotEmpty().
//                                                                                             ^^^^^ reference semanticdb maven . . kotlin/text/toInt().
  
              return Version(parts[0], parts[1], parts[2])
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#`<init>`().
//                           ^^^^^ reference local 1
//                           ^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                     ^^^^^ reference local 1
//                                     ^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                               ^^^^^ reference local 1
//                                               ^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
          }
  
          fun from(version: BigDecimal): Version = from(version.toString())
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from(+1).
//                 display_name from
//                 documentation ```kotlin\npublic final fun from(version: BigDecimal): Version\n```
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from(+1).(version)
//                         display_name version
//                         documentation ```kotlin\nversion: BigDecimal\n```
//                          ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#
//                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from().
//                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Version#Companion#from(+1).(version)
//                                                              ^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#toString().
      }
  }
