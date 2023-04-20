package com.airbnb.epoxy;

import android.util.Log;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^ reference semanticdb maven . . android/util/
//                  ^^^ reference semanticdb maven . . android/util/Log#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/
//                           ^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/
//                                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . androidx/recyclerview/widget/RecyclerView/AdapterDataObserver#

/**
 * This data observer can be registered with an Epoxy adapter or controller to log all item change
 * events. This may be useful to use in debug builds in order to observe model updates and monitor
 * for issues.
 * <p>
 * You may want to look for unexpected item updates to catch improper hashCode/equals
 * implementations in your models.
 * <p>
 * Additionally, you may want to look for frequent or unnecessary updates as an opportunity for
 * optimization.
 */
public class EpoxyDiffLogger extends AdapterDataObserver {
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#
//                           documentation ```java\npublic class EpoxyDiffLogger\n```
//                           documentation  This data observer can be registered with an Epoxy adapter or controller to log all item change\n events. This may be useful to use in debug builds in order to observe model updates and monitor\n for issues.\n <p>\n You may want to look for unexpected item updates to catch improper hashCode/equals\n implementations in your models.\n <p>\n Additionally, you may want to look for frequent or unnecessary updates as an opportunity for\n optimization.\n
//                           relationship is_implementation semanticdb maven . . ``/AdapterDataObserver#
//                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . _root_/
  private final String tag;
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                         documentation ```java\nprivate final String tag\n```

  public EpoxyDiffLogger(String tag) {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#`<init>`().
//                       documentation ```java\npublic EpoxyDiffLogger(String tag)\n```
//                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                              ^^^ definition local 0
//                                  documentation ```java\nString tag\n```
    this.tag = tag;
//       ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//             ^^^ reference local 0
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged().
//                               documentation ```java\n@Override\npublic void onItemRangeChanged(int positionStart, int itemCount)\n```
//                                   ^^^^^^^^^^^^^ definition local 1
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 2
//                                                                documentation ```java\nint itemCount\n```
    Log.d(tag, "Item range changed. Start: " + positionStart + " Count: " + itemCount);
//  ^^^ reference semanticdb maven . . _root_/
//      ^ reference semanticdb maven . . d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                             ^^^^^^^^^^^^^ reference local 1
//                                                                          ^^^^^^^^^ reference local 2
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged(+1).
//                               documentation ```java\n@Override\npublic void onItemRangeChanged(int positionStart, int itemCount, Object payload)\n```
//                                   ^^^^^^^^^^^^^ definition local 3
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 4
//                                                                documentation ```java\nint itemCount\n```
//                                                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                                  ^^^^^^^ definition local 5
//                                                                                          documentation ```java\n@Nullable\nObject payload\n```
    if (payload == null) {
//      ^^^^^^^ reference local 5
      onItemRangeChanged(positionStart, itemCount);
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged().
//                       ^^^^^^^^^^^^^ reference local 3
//                                      ^^^^^^^^^ reference local 4
    } else {
      Log.d(tag,
//    ^^^ reference semanticdb maven . . _root_/
//        ^ reference semanticdb maven . . d#
//          ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
          "Item range changed with payloads. Start: " + positionStart + " Count: " + itemCount);
//                                                      ^^^^^^^^^^^^^ reference local 3
//                                                                                   ^^^^^^^^^ reference local 4
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeInserted(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeInserted().
//                                documentation ```java\n@Override\npublic void onItemRangeInserted(int positionStart, int itemCount)\n```
//                                    ^^^^^^^^^^^^^ definition local 6
//                                                  documentation ```java\nint positionStart\n```
//                                                       ^^^^^^^^^ definition local 7
//                                                                 documentation ```java\nint itemCount\n```
    Log.d(tag, "Item range inserted. Start: " + positionStart + " Count: " + itemCount);
//  ^^^ reference semanticdb maven . . _root_/
//      ^ reference semanticdb maven . . d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                              ^^^^^^^^^^^^^ reference local 6
//                                                                           ^^^^^^^^^ reference local 7
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeRemoved(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeRemoved().
//                               documentation ```java\n@Override\npublic void onItemRangeRemoved(int positionStart, int itemCount)\n```
//                                   ^^^^^^^^^^^^^ definition local 8
//                                                 documentation ```java\nint positionStart\n```
//                                                      ^^^^^^^^^ definition local 9
//                                                                documentation ```java\nint itemCount\n```
    Log.d(tag, "Item range removed. Start: " + positionStart + " Count: " + itemCount);
//  ^^^ reference semanticdb maven . . _root_/
//      ^ reference semanticdb maven . . d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                             ^^^^^^^^^^^^^ reference local 8
//                                                                          ^^^^^^^^^ reference local 9
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeMoved().
//                             documentation ```java\n@Override\npublic void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)\n```
//                                 ^^^^^^^^^^^^ definition local 10
//                                              documentation ```java\nint fromPosition\n```
//                                                   ^^^^^^^^^^ definition local 11
//                                                              documentation ```java\nint toPosition\n```
//                                                                   ^^^^^^^^^ definition local 12
//                                                                             documentation ```java\nint itemCount\n```
    Log.d(tag, "Item moved. From: " + fromPosition + " To: " + toPosition);
//  ^^^ reference semanticdb maven . . _root_/
//      ^ reference semanticdb maven . . d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                    ^^^^^^^^^^^^ reference local 10
//                                                             ^^^^^^^^^^ reference local 11
  }
}
