package com.airbnb.epoxy;

/**
 * This ArrayList subclass enforces that no changes are made to the list after {@link #freeze()} is
 * called. This prevents model interceptors from storing the list and trying to change it later. We
 * could copy the list before diffing, but that would waste memory to make the copy for every
 * buildModels cycle, plus the interceptors could still try to modify the list and be confused about
 * why it doesn't do anything.
 */
class ControllerModelList extends ModelList {
^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ControllerModelList#
//                                ^^^^^^^^^ reference _root_/

  private static final ModelListObserver OBSERVER = new ModelListObserver() {
//                     ^^^^^^^^^^^^^^^^^ reference _root_/
//                                       ^^^^^^^^ definition com/airbnb/epoxy/ControllerModelList#OBSERVER.
//                                                      ^^^^^^^^^^^^^^^^^ reference _root_/
    @Override
    public void onItemRangeInserted(int positionStart, int itemCount) {
      throw new IllegalStateException(
          "Models cannot be changed once they are added to the controller");
    }

    @Override
    public void onItemRangeRemoved(int positionStart, int itemCount) {
      throw new IllegalStateException(
          "Models cannot be changed once they are added to the controller");
    }
  };

  ControllerModelList(int expectedModelCount) {
  ^^^^^^ definition com/airbnb/epoxy/ControllerModelList#`<init>`().
//                        ^^^^^^^^^^^^^^^^^^ definition local0
    super(expectedModelCount);
//        ^^^^^^^^^^^^^^^^^^ reference local0
    pauseNotifications();
//  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#pauseNotifications#
  }

  void freeze() {
//     ^^^^^^ definition com/airbnb/epoxy/ControllerModelList#freeze().
    setObserver(OBSERVER);
//  ^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#setObserver#
//              ^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#OBSERVER.
    resumeNotifications();
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ControllerModelList#resumeNotifications#
  }
}
