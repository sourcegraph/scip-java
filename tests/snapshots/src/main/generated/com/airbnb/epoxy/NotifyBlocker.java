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
//                  documentation ```java\nclass NotifyBlocker\n```
//                  documentation  We don't allow any data change notifications except the ones done though diffing. Forcing\n changes to happen through diffing reduces the chance for developer error when implementing an\n adapter.\n <p>\n This observer throws upon any changes done outside of diffing.\n
//                  relationship is_implementation semanticdb maven . . ``/AdapterDataObserver#
//    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#`<init>`().
//                  documentation ```java\nNotifyBlocker()\n```
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/

  private boolean changesAllowed;
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
//                               documentation ```java\nprivate boolean changesAllowed\n```

  void allowChanges() {
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
//                  documentation ```java\nvoid allowChanges()\n```
    changesAllowed = true;
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  void blockChanges() {
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().
//                  documentation ```java\nvoid blockChanges()\n```
    changesAllowed = false;
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onChanged() {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
//                      documentation ```java\n@Override\npublic void onChanged()\n```
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
//                               documentation ```java\n@Override\npublic void onItemRangeChanged(int positionStart, int itemCount)\n```
//                                   ^^^^^^^^^^^^^ definition local 0
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 1
//                                                                documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeChanged(+1).
//                               documentation ```java\n@Override\npublic void onItemRangeChanged(int positionStart, int itemCount, Object payload)\n```
//                                   ^^^^^^^^^^^^^ definition local 2
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 3
//                                                                documentation ```java\nint itemCount\n```
//                                                                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                        ^^^^^^^ definition local 4
//                                                                                documentation ```java\nObject payload\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeInserted(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeInserted().
//                                documentation ```java\n@Override\npublic void onItemRangeInserted(int positionStart, int itemCount)\n```
//                                    ^^^^^^^^^^^^^ definition local 5
//                                                  documentation ```java\nint positionStart\n```
//                                                       ^^^^^^^^^ definition local 6
//                                                                 documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeRemoved(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeRemoved().
//                               documentation ```java\n@Override\npublic void onItemRangeRemoved(int positionStart, int itemCount)\n```
//                                   ^^^^^^^^^^^^^ definition local 7
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 8
//                                                                documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeMoved().
//                             documentation ```java\n@Override\npublic void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)\n```
//                                 ^^^^^^^^^^^^ definition local 9
//                                              documentation ```java\nint fromPosition\n```
//                                                   ^^^^^^^^^^ definition local 10
//                                                              documentation ```java\nint toPosition\n```
//                                                                   ^^^^^^^^^ definition local 11
//                                                                             documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }
}
