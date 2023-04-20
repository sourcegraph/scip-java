package com.airbnb.epoxy;

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#

/**
 * Used with {@link EpoxyController#addModelBuildListener(OnModelBuildFinishedListener)} to be
 * alerted to new model changes.
 */
public interface OnModelBuildFinishedListener {
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#
//                                            documentation ```java\npublic interface OnModelBuildFinishedListener\n```
//                                            documentation  Used with {@link EpoxyController#addModelBuildListener(OnModelBuildFinishedListener)} to be\n alerted to new model changes.\n
  /**
   * Called after {@link EpoxyController#buildModels()} has run and changes have been notified to
   * the adapter. This will be called even if no changes existed.
   */
  void onModelBuildFinished(@NonNull DiffResult result);
//     ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#onModelBuildFinished().
//                          documentation ```java\npublic abstract void onModelBuildFinished(DiffResult result)\n```
//                          documentation  Called after {@link EpoxyController#buildModels()} has run and changes have been notified to\n the adapter. This will be called even if no changes existed.\n
//                           ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                              ^^^^^^ definition local 0
//                                                     documentation ```java\n@NonNull\nDiffResult result\n```
}
