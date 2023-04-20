package com.airbnb.epoxy;

/**
 * This ArrayList subclass enforces that no changes are made to the list after {@link #freeze()} is
 * called. This prevents model interceptors from storing the list and trying to change it later. We
 * could copy the list before diffing, but that would waste memory to make the copy for every
 * buildModels cycle, plus the interceptors could still try to modify the list and be confused about
 * why it doesn't do anything.
 */
class ControllerModelList extends ModelList {
//    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerModelList#
//                        documentation ```java\nclass ControllerModelList\n```
//                        documentation  This ArrayList subclass enforces that no changes are made to the list after {@link #freeze()} is\n called. This prevents model interceptors from storing the list and trying to change it later. We\n could copy the list before diffing, but that would waste memory to make the copy for every\n buildModels cycle, plus the interceptors could still try to modify the list and be confused about\n why it doesn't do anything.\n
//                        relationship is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#
//                        relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                        relationship is_implementation semanticdb maven jdk 11 java/lang/Cloneable#
//                        relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//                        relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//                        relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/AbstractList#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/ArrayList#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/List#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/List#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/RandomAccess#
//                                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#

  private static final ModelListObserver OBSERVER = new ModelListObserver() {
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                                       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerModelList#OBSERVER.
//                                                documentation ```java\nprivate static final ModelListObserver OBSERVER\n```
//                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onItemRangeInserted(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^^ definition local 2
//                                  documentation ```java\n@Override\npublic void onItemRangeInserted(int positionStart, int itemCount)\n```
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                                      ^^^^^^^^^^^^^ definition local 4
//                                                    documentation ```java\nint positionStart\n```
//                                                         ^^^^^^^^^ definition local 5
//                                                                   documentation ```java\nint itemCount\n```
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "Models cannot be changed once they are added to the controller");
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onItemRangeRemoved(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^ definition local 3
//                                 documentation ```java\n@Override\npublic void onItemRangeRemoved(int positionStart, int itemCount)\n```
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                                     ^^^^^^^^^^^^^ definition local 6
//                                                   documentation ```java\nint positionStart\n```
//                                                        ^^^^^^^^^ definition local 7
//                                                                  documentation ```java\nint itemCount\n```
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "Models cannot be changed once they are added to the controller");
    }
  };

  ControllerModelList(int expectedModelCount) {
//^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerModelList#`<init>`().
//                    documentation ```java\nControllerModelList(int expectedModelCount)\n```
//                        ^^^^^^^^^^^^^^^^^^ definition local 8
//                                           documentation ```java\nint expectedModelCount\n```
    super(expectedModelCount);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`().
//        ^^^^^^^^^^^^^^^^^^ reference local 8
    pauseNotifications();
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#pauseNotifications().
  }

  void freeze() {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerModelList#freeze().
//            documentation ```java\nvoid freeze()\n```
    setObserver(OBSERVER);
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#setObserver().
//              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerModelList#OBSERVER.
    resumeNotifications();
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#resumeNotifications().
  }
}
