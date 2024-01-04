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
//                                            display_name OnModelBuildFinishedListener
//                                            signature_documentation java public interface OnModelBuildFinishedListener
//                                            documentation  Used with {@link EpoxyController#addModelBuildListener(OnModelBuildFinishedListener)} to be\n alerted to new model changes.\n
  /**
   * Called after {@link EpoxyController#buildModels()} has run and changes have been notified to
   * the adapter. This will be called even if no changes existed.
   */
  void onModelBuildFinished(@NonNull DiffResult result);
//     ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#onModelBuildFinished().
//                          display_name onModelBuildFinished
//                          signature_documentation java public abstract void onModelBuildFinished(DiffResult result)
//                          documentation  Called after {@link EpoxyController#buildModels()} has run and changes have been notified to\n the adapter. This will be called even if no changes existed.\n
//                           ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/DiffResult#
//                                              ^^^^^^ definition local 0
//                                                     display_name result
//                                                     signature_documentation java @NonNull\nDiffResult result
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/OnModelBuildFinishedListener#onModelBuildFinished().
}
