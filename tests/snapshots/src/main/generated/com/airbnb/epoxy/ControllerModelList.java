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
//                        display_name ControllerModelList
//                        signature_documentation java class ControllerModelList
//                        kind Class
//                        documentation  This ArrayList subclass enforces that no changes are made to the list after {@link #freeze()} is\n called. This prevents model interceptors from storing the list and trying to change it later. We\n could copy the list before diffing, but that would waste memory to make the copy for every\n buildModels cycle, plus the interceptors could still try to modify the list and be confused about\n why it doesn't do anything.\n
//                        relationship is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#
//                        relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//                        relationship is_implementation semanticdb maven jdk 11 java/lang/Cloneable#
//                        relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/AbstractList#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/ArrayList#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/List#
//                        relationship is_implementation semanticdb maven jdk 11 java/util/RandomAccess#
//                                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#

  private static final ModelListObserver OBSERVER = new ModelListObserver() {
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                                       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerModelList#OBSERVER.
//                                                display_name OBSERVER
//                                                signature_documentation java private static final ModelListObserver OBSERVER
//                                                kind StaticField
//                                                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onItemRangeInserted(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^^ definition local 1
//                                  display_name onItemRangeInserted
//                                  signature_documentation java @Override\npublic void onItemRangeInserted(int positionStart, int itemCount)
//                                  enclosing_symbol local 0
//                                  kind Method
//                                  relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                                      ^^^^^^^^^^^^^ definition local 2
//                                                    display_name positionStart
//                                                    signature_documentation java int positionStart
//                                                    enclosing_symbol local 1
//                                                         ^^^^^^^^^ definition local 3
//                                                                   display_name itemCount
//                                                                   signature_documentation java int itemCount
//                                                                   enclosing_symbol local 1
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "Models cannot be changed once they are added to the controller");
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void onItemRangeRemoved(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^ definition local 4
//                                 display_name onItemRangeRemoved
//                                 signature_documentation java @Override\npublic void onItemRangeRemoved(int positionStart, int itemCount)
//                                 enclosing_symbol local 0
//                                 kind Method
//                                 relationship is_reference is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                                     ^^^^^^^^^^^^^ definition local 5
//                                                   display_name positionStart
//                                                   signature_documentation java int positionStart
//                                                   enclosing_symbol local 4
//                                                        ^^^^^^^^^ definition local 6
//                                                                  display_name itemCount
//                                                                  signature_documentation java int itemCount
//                                                                  enclosing_symbol local 4
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "Models cannot be changed once they are added to the controller");
    }
  };

  ControllerModelList(int expectedModelCount) {
//^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerModelList#`<init>`().
//                    display_name <init>
//                    signature_documentation java ControllerModelList(int expectedModelCount)
//                    kind Constructor
//                        ^^^^^^^^^^^^^^^^^^ definition local 7
//                                           display_name expectedModelCount
//                                           signature_documentation java int expectedModelCount
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ControllerModelList#`<init>`().
    super(expectedModelCount);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`().
//        ^^^^^^^^^^^^^^^^^^ reference local 7
    pauseNotifications();
//  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#pauseNotifications().
  }

  void freeze() {
//     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ControllerModelList#freeze().
//            display_name freeze
//            signature_documentation java void freeze()
//            kind Method
    setObserver(OBSERVER);
//  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#setObserver().
//              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ControllerModelList#OBSERVER.
    resumeNotifications();
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#resumeNotifications().
  }
}
