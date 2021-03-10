package com.airbnb.epoxy;

import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^^^ reference androidx/recyclerview/
//                           ^^^^^^ reference androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^^^^^^^^^^ reference androidx/recyclerview/widget/RecyclerView/AdapterDataObserver#

/**
 * We don't allow any data change notifications except the ones done though diffing. Forcing
 * changes to happen through diffing reduces the chance for developer error when implementing an
 * adapter.
 * <p>
 * This observer throws upon any changes done outside of diffing.
 */
class NotifyBlocker extends AdapterDataObserver {
//    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#
//    ^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#`<init>`().
//                          ^^^^^^^^^^^^^^^^^^^ reference _root_/

  private boolean changesAllowed;
//                ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#changesAllowed.

  void allowChanges() {
//     ^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#allowChanges().
    changesAllowed = true;
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  void blockChanges() {
//     ^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#blockChanges().
    changesAllowed = false;
//  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onChanged() {
//            ^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#onChanged().
    if (!changesAllowed) {
//       ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#changesAllowed.
      throw new IllegalStateException(
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1). 1:87
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
          "You cannot notify item changes directly. Call `requestModelBuild` instead.");
    }
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#onItemRangeChanged().
//                                   ^^^^^^^^^^^^^ definition local0
//                                                      ^^^^^^^^^ definition local1
    onChanged();
//  ^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
//            ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#onItemRangeChanged(+1).
//                                   ^^^^^^^^^^^^^ definition local2
//                                                      ^^^^^^^^^ definition local3
//                                                                 ^^^^^^ reference java/lang/Object#
//                                                                        ^^^^^^^ definition local4
    onChanged();
//  ^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onItemRangeInserted(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#onItemRangeInserted().
//                                    ^^^^^^^^^^^^^ definition local5
//                                                       ^^^^^^^^^ definition local6
    onChanged();
//  ^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onItemRangeRemoved(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#onItemRangeRemoved().
//                                   ^^^^^^^^^^^^^ definition local7
//                                                      ^^^^^^^^^ definition local8
    onChanged();
//  ^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
//            ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/NotifyBlocker#onItemRangeMoved().
//                                 ^^^^^^^^^^^^ definition local9
//                                                   ^^^^^^^^^^ definition local10
//                                                                   ^^^^^^^^^ definition local11
    onChanged();
//  ^^^^^^^^^ reference com/airbnb/epoxy/NotifyBlocker#onChanged().
  }
}
