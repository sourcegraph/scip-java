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
//                           display_name EpoxyDiffLogger
//                           signature_documentation java public class EpoxyDiffLogger
//                           kind Class
//                           documentation  This data observer can be registered with an Epoxy adapter or controller to log all item change\n events. This may be useful to use in debug builds in order to observe model updates and monitor\n for issues.\n <p>\n You may want to look for unexpected item updates to catch improper hashCode/equals\n implementations in your models.\n <p>\n Additionally, you may want to look for frequent or unnecessary updates as an opportunity for\n optimization.\n
//                           relationship is_implementation semanticdb maven . . AdapterDataObserver#
//                                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . AdapterDataObserver#
  private final String tag;
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                     ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                         display_name tag
//                         signature_documentation java private final String tag
//                         kind Field

  public EpoxyDiffLogger(String tag) {
//       ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#`<init>`().
//                       display_name <init>
//                       signature_documentation java public EpoxyDiffLogger(String tag)
//                       kind Constructor
//                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/String#
//                              ^^^ definition local 0
//                                  display_name tag
//                                  signature_documentation java String tag
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#`<init>`().
    this.tag = tag;
//       ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//             ^^^ reference local 0
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged().
//                               display_name onItemRangeChanged
//                               signature_documentation java @Override\npublic void onItemRangeChanged(int positionStart, int itemCount)
//                               kind Method
//                                   ^^^^^^^^^^^^^ definition local 1
//                                                 display_name positionStart
//                                                 signature_documentation java int positionStart
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged().
//                                                      ^^^^^^^^^ definition local 2
//                                                                display_name itemCount
//                                                                signature_documentation java int itemCount
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged().
    Log.d(tag, "Item range changed. Start: " + positionStart + " Count: " + itemCount);
//  ^^^ reference semanticdb maven . . Log#
//      ^ reference semanticdb maven . . Log#d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                             ^^^^^^^^^^^^^ reference local 1
//                                                                          ^^^^^^^^^ reference local 2
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged(+1).
//                               display_name onItemRangeChanged
//                               signature_documentation java @Override\npublic void onItemRangeChanged(int positionStart, int itemCount, Object payload)
//                               kind Method
//                                   ^^^^^^^^^^^^^ definition local 3
//                                                 display_name positionStart
//                                                 signature_documentation java int positionStart
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged(+1).
//                                                      ^^^^^^^^^ definition local 4
//                                                                display_name itemCount
//                                                                signature_documentation java int itemCount
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged(+1).
//                                                                  ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                                  ^^^^^^^ definition local 5
//                                                                                          display_name payload
//                                                                                          signature_documentation java @Nullable\nObject payload
//                                                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged(+1).
    if (payload == null) {
//      ^^^^^^^ reference local 5
      onItemRangeChanged(positionStart, itemCount);
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeChanged().
//                       ^^^^^^^^^^^^^ reference local 3
//                                      ^^^^^^^^^ reference local 4
    } else {
      Log.d(tag,
//    ^^^ reference semanticdb maven . . Log#
//        ^ reference semanticdb maven . . Log#d#
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
//                                display_name onItemRangeInserted
//                                signature_documentation java @Override\npublic void onItemRangeInserted(int positionStart, int itemCount)
//                                kind Method
//                                    ^^^^^^^^^^^^^ definition local 6
//                                                  display_name positionStart
//                                                  signature_documentation java int positionStart
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeInserted().
//                                                       ^^^^^^^^^ definition local 7
//                                                                 display_name itemCount
//                                                                 signature_documentation java int itemCount
//                                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeInserted().
    Log.d(tag, "Item range inserted. Start: " + positionStart + " Count: " + itemCount);
//  ^^^ reference semanticdb maven . . Log#
//      ^ reference semanticdb maven . . Log#d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                              ^^^^^^^^^^^^^ reference local 6
//                                                                           ^^^^^^^^^ reference local 7
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeRemoved(int positionStart, int itemCount) {
//            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeRemoved().
//                               display_name onItemRangeRemoved
//                               signature_documentation java @Override\npublic void onItemRangeRemoved(int positionStart, int itemCount)
//                               kind Method
//                                   ^^^^^^^^^^^^^ definition local 8
//                                                 display_name positionStart
//                                                 signature_documentation java int positionStart
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeRemoved().
//                                                      ^^^^^^^^^ definition local 9
//                                                                display_name itemCount
//                                                                signature_documentation java int itemCount
//                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeRemoved().
    Log.d(tag, "Item range removed. Start: " + positionStart + " Count: " + itemCount);
//  ^^^ reference semanticdb maven . . Log#
//      ^ reference semanticdb maven . . Log#d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                             ^^^^^^^^^^^^^ reference local 8
//                                                                          ^^^^^^^^^ reference local 9
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeMoved().
//                             display_name onItemRangeMoved
//                             signature_documentation java @Override\npublic void onItemRangeMoved(int fromPosition, int toPosition, int itemCount)
//                             kind Method
//                                 ^^^^^^^^^^^^ definition local 10
//                                              display_name fromPosition
//                                              signature_documentation java int fromPosition
//                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeMoved().
//                                                   ^^^^^^^^^^ definition local 11
//                                                              display_name toPosition
//                                                              signature_documentation java int toPosition
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeMoved().
//                                                                   ^^^^^^^^^ definition local 12
//                                                                             display_name itemCount
//                                                                             signature_documentation java int itemCount
//                                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#onItemRangeMoved().
    Log.d(tag, "Item moved. From: " + fromPosition + " To: " + toPosition);
//  ^^^ reference semanticdb maven . . Log#
//      ^ reference semanticdb maven . . Log#d#
//        ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyDiffLogger#tag.
//                                    ^^^^^^^^^^^^ reference local 10
//                                                             ^^^^^^^^^^ reference local 11
  }
}
