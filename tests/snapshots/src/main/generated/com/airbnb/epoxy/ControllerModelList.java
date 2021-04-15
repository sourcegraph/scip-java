package com.airbnb.epoxy;

/**
 * This ArrayList subclass enforces that no changes are made to the list after {@link #freeze()} is
 * called. This prevents model interceptors from storing the list and trying to change it later. We
 * could copy the list before diffing, but that would waste memory to make the copy for every
 * buildModels cycle, plus the interceptors could still try to modify the list and be confused about
 * why it doesn't do anything.
 */
class ControllerModelList extends ModelList {
//    ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerModelList# class ControllerModelList extends ModelList
//                                ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#

  private static final ModelListObserver OBSERVER = new ModelListObserver() {
//                     ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ModelListObserver#
//                                       ^^^^^^^^ definition com/airbnb/epoxy/ControllerModelList#OBSERVER. private static final ModelListObserver OBSERVER
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local1 12:3
//                                                      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ModelListObserver#
//                                                      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ModelListObserver#
    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onItemRangeInserted(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^^ definition local2 @Override public void onItemRangeInserted(int positionStart, int itemCount)
//                                      ^^^^^^^^^^^^^ definition local4 int positionStart
//                                                         ^^^^^^^^^ definition local5 int itemCount
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:75
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "Models cannot be changed once they are added to the controller");
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void onItemRangeRemoved(int positionStart, int itemCount) {
//              ^^^^^^^^^^^^^^^^^^ definition local3 @Override public void onItemRangeRemoved(int positionStart, int itemCount)
//                                     ^^^^^^^^^^^^^ definition local6 int positionStart
//                                                        ^^^^^^^^^ definition local7 int itemCount
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:75
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "Models cannot be changed once they are added to the controller");
    }
  };

  ControllerModelList(int expectedModelCount) {
//^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerModelList#`<init>`(). ControllerModelList(int expectedModelCount)
//                        ^^^^^^^^^^^^^^^^^^ definition local8 int expectedModelCount
    super(expectedModelCount);
//  ^^^^^ reference com/airbnb/epoxy/ModelList#`<init>`().
//        ^^^^^^^^^^^^^^^^^^ reference local8
    pauseNotifications();
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#pauseNotifications().
  }

  void freeze() {
//     ^^^^^^ definition com/airbnb/epoxy/ControllerModelList#freeze(). void freeze()
    setObserver(OBSERVER);
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#setObserver().
//              ^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#OBSERVER.
    resumeNotifications();
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#resumeNotifications().
  }
}
