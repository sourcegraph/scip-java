package com.airbnb.epoxy;

import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/AdapterDataObserver#

/**
 * We don't allow any data change notifications except the ones done though diffing. Forcing
 * changes to happen through diffing reduces the chance for developer error when implementing an
 * adapter.
 * <p>
 * This observer throws upon any changes done outside of diffing.
 */
class NotifyBlocker extends AdapterDataObserver {
//    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#
//                  display_name NotifyBlocker
//                  signature_documentation java class NotifyBlocker
//                  documentation  We don't allow any data change notifications except the ones done though diffing. Forcing\n changes to happen through diffing reduces the chance for developer error when implementing an\n adapter.\n <p>\n This observer throws upon any changes done outside of diffing.\n
//                  relationship is_implementation semanticdb maven . . AdapterDataObserver#
//    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#`<init>`().
//                  display_name <init>
//                  signature_documentation java NotifyBlocker()
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . AdapterDataObserver#

  private boolean changesAllowed;
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
//                               display_name changesAllowed
//                               signature_documentation java private boolean changesAllowed

  void allowChanges() {
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
//                  display_name allowChanges
//                  signature_documentation java void allowChanges()
    changesAllowed = true;
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  void blockChanges() {
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().
//                  display_name blockChanges
//                  signature_documentation java void blockChanges()
    changesAllowed = false;
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onChanged() {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
//                      display_name onChanged
//                      signature_documentation java @Override\npublic void onChanged()
    if (!changesAllowed) {
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
      throw new IllegalStateException(
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
          "You cannot notify item changes directly. Call `requestModelBuild` instead.");
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeChanged().
//                               display_name onItemRangeChanged
//                               signature_documentation java @Override\npublic void onItemRangeChanged(int positionStart, int itemCount)
//                                   ^^^^^^^^^^^^^ definition local 0
//                                                 display_name positionStart
//                                                 signature_documentation java int positionStart
//                                                      ^^^^^^^^^ definition local 1
//                                                                display_name itemCount
//                                                                signature_documentation java int itemCount
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeChanged(+1).
//                               display_name onItemRangeChanged
//                               signature_documentation java @Override\npublic void onItemRangeChanged(int positionStart, int itemCount, Object payload)
//                                   ^^^^^^^^^^^^^ definition local 2
//                                                 display_name positionStart
//                                                 signature_documentation java int positionStart
//                                                      ^^^^^^^^^ definition local 3
//                                                                display_name itemCount
//                                                                signature_documentation java int itemCount
//                                                                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                        ^^^^^^^ definition local 4
//                                                                                display_name payload
//                                                                                signature_documentation java Object payload
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeInserted(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeInserted().
//                                display_name onItemRangeInserted
//                                signature_documentation java @Override\npublic void onItemRangeInserted(int positionStart, int itemCount)
//                                    ^^^^^^^^^^^^^ definition local 5
//                                                  display_name positionStart
//                                                  signature_documentation java int positionStart
//                                                       ^^^^^^^^^ definition local 6
//                                                                 display_name itemCount
//                                                                 signature_documentation java int itemCount
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeRemoved(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeRemoved().
//                               display_name onItemRangeRemoved
//                               signature_documentation java @Override\npublic void onItemRangeRemoved(int positionStart, int itemCount)
//                                   ^^^^^^^^^^^^^ definition local 7
//                                                 display_name positionStart
//                                                 signature_documentation java int positionStart
//                                                      ^^^^^^^^^ definition local 8
//                                                                display_name itemCount
//                                                                signature_documentation java int itemCount
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeMoved().
//                             display_name onItemRangeMoved
//                             signature_documentation java @Override\npublic void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)
//                                 ^^^^^^^^^^^^ definition local 9
//                                              display_name fromPosition
//                                              signature_documentation java int fromPosition
//                                                   ^^^^^^^^^^ definition local 10
//                                                              display_name toPosition
//                                                              signature_documentation java int toPosition
//                                                                   ^^^^^^^^^ definition local 11
//                                                                             display_name itemCount
//                                                                             signature_documentation java int itemCount
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }
}
