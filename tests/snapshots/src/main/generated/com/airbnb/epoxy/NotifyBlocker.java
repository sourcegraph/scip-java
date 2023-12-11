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
//                  documentation ```java\nclass NotifyBlocker\n```
//                  documentation  We don't allow any data change notifications except the ones done though diffing. Forcing\n changes to happen through diffing reduces the chance for developer error when implementing an\n adapter.\n <p>\n This observer throws upon any changes done outside of diffing.\n
//                  relationship is_implementation semanticdb maven . . AdapterDataObserver#
//    ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#`<init>`().
//                  display_name <init>
//                  documentation ```java\nNotifyBlocker()\n```
//                          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . AdapterDataObserver#

  private boolean changesAllowed;
//                ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
//                               display_name changesAllowed
//                               documentation ```java\nprivate boolean changesAllowed\n```

  void allowChanges() {
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#allowChanges().
//                  display_name allowChanges
//                  documentation ```java\nvoid allowChanges()\n```
    changesAllowed = true;
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  void blockChanges() {
//     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#blockChanges().
//                  display_name blockChanges
//                  documentation ```java\nvoid blockChanges()\n```
    changesAllowed = false;
//  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#changesAllowed.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onChanged() {
//            ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
//                      display_name onChanged
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
//                               display_name onItemRangeChanged
//                               documentation ```java\n@Override\npublic void onItemRangeChanged(int positionStart, int itemCount)\n```
//                                   ^^^^^^^^^^^^^ definition local 0
//                                                 display_name positionStart
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 1
//                                                                display_name itemCount
//                                                                documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeChanged(+1).
//                               display_name onItemRangeChanged
//                               documentation ```java\n@Override\npublic void onItemRangeChanged(int positionStart, int itemCount, Object payload)\n```
//                                   ^^^^^^^^^^^^^ definition local 2
//                                                 display_name positionStart
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 3
//                                                                display_name itemCount
//                                                                documentation ```java\nint itemCount\n```
//                                                                 ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                        ^^^^^^^ definition local 4
//                                                                                display_name payload
//                                                                                documentation ```java\nObject payload\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeInserted(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeInserted().
//                                display_name onItemRangeInserted
//                                documentation ```java\n@Override\npublic void onItemRangeInserted(int positionStart, int itemCount)\n```
//                                    ^^^^^^^^^^^^^ definition local 5
//                                                  display_name positionStart
//                                                  documentation ```java\nint positionStart\n```
//                                                       ^^^^^^^^^ definition local 6
//                                                                 display_name itemCount
//                                                                 documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeRemoved(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeRemoved().
//                               display_name onItemRangeRemoved
//                               documentation ```java\n@Override\npublic void onItemRangeRemoved(int positionStart, int itemCount)\n```
//                                   ^^^^^^^^^^^^^ definition local 7
//                                                 display_name positionStart
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 8
//                                                                display_name itemCount
//                                                                documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onItemRangeMoved().
//                             display_name onItemRangeMoved
//                             documentation ```java\n@Override\npublic void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)\n```
//                                 ^^^^^^^^^^^^ definition local 9
//                                              display_name fromPosition
//                                              documentation ```java\nint fromPosition\n```
//                                                   ^^^^^^^^^^ definition local 10
//                                                              display_name toPosition
//                                                              documentation ```java\nint toPosition\n```
//                                                                   ^^^^^^^^^ definition local 11
//                                                                             display_name itemCount
//                                                                             documentation ```java\nint itemCount\n```
    onChanged();
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/NotifyBlocker#onChanged().
  }
}
