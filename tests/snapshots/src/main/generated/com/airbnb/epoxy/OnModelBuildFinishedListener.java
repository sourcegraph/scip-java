package com.airbnb.epoxy;

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#

/**
 * Used with {@link EpoxyController#addModelBuildListener(OnModelBuildFinishedListener)} to be
 * alerted to new model changes.
 */
public interface OnModelBuildFinishedListener {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelBuildFinishedListener#
  /**
   * Called after {@link EpoxyController#buildModels()} has run and changes have been notified to
   * the adapter. This will be called even if no changes existed.
   */
  void onModelBuildFinished(@NonNull DiffResult result);
//     ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnModelBuildFinishedListener#onModelBuildFinished().
//                           ^^^^^^^ reference androidx/annotation/NonNull#
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/DiffResult#
//                                              ^^^^^^ definition local0
}
