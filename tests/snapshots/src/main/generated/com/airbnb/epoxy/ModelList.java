package com.airbnb.epoxy;

import java.util.AbstractList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#
import java.util.ArrayList;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
import java.util.Collection;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
import java.util.ConcurrentModificationException;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#
import java.util.Iterator;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
import java.util.List;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^ reference semanticdb maven jdk 11 java/util/List#
import java.util.ListIterator;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
import java.util.NoSuchElementException;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/NoSuchElementException#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#

/**
 * Used by our {@link EpoxyAdapter} to track models. It simply wraps ArrayList and notifies an
 * observer when remove or insertion operations are done on the list. This allows us to optimize
 * diffing since we have a knowledge of what changed in the list.
 */
class ModelList extends ArrayList<EpoxyModel<?>> {
//    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#
//              display_name ModelList
//              signature_documentation java class ModelList
//              kind Class
//              documentation  Used by our {@link EpoxyAdapter} to track models. It simply wraps ArrayList and notifies an\n observer when remove or insertion operations are done on the list. This allows us to optimize\n diffing since we have a knowledge of what changed in the list.\n
//              relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//              relationship is_implementation semanticdb maven jdk 11 java/lang/Cloneable#
//              relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//              relationship is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#
//              relationship is_implementation semanticdb maven jdk 11 java/util/AbstractList#
//              relationship is_implementation semanticdb maven jdk 11 java/util/ArrayList#
//              relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//              relationship is_implementation semanticdb maven jdk 11 java/util/List#
//              relationship is_implementation semanticdb maven jdk 11 java/util/RandomAccess#
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#

  ModelList(int expectedModelCount) {
//^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`().
//          display_name <init>
//          signature_documentation java ModelList(int expectedModelCount)
//          kind Constructor
//              ^^^^^^^^^^^^^^^^^^ definition local 0
//                                 display_name expectedModelCount
//                                 signature_documentation java int expectedModelCount
//                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`().
    super(expectedModelCount);
//  ^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//        ^^^^^^^^^^^^^^^^^^ reference local 0
  }

  ModelList() {
//^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`(+1).
//          display_name <init>
//          signature_documentation java ModelList()
//          kind Constructor

  }

  interface ModelListObserver {
//          ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                            display_name ModelListObserver
//                            signature_documentation java interface ModelListObserver
//                            kind Interface
    void onItemRangeInserted(int positionStart, int itemCount);
//       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                           display_name onItemRangeInserted
//                           signature_documentation java public abstract void onItemRangeInserted(int positionStart, int itemCount)
//                           kind AbstractMethod
//                               ^^^^^^^^^^^^^ definition local 1
//                                             display_name positionStart
//                                             signature_documentation java int positionStart
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                                                  ^^^^^^^^^ definition local 2
//                                                            display_name itemCount
//                                                            signature_documentation java int itemCount
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
    void onItemRangeRemoved(int positionStart, int itemCount);
//       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                          display_name onItemRangeRemoved
//                          signature_documentation java public abstract void onItemRangeRemoved(int positionStart, int itemCount)
//                          kind AbstractMethod
//                              ^^^^^^^^^^^^^ definition local 3
//                                            display_name positionStart
//                                            signature_documentation java int positionStart
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                                                 ^^^^^^^^^ definition local 4
//                                                           display_name itemCount
//                                                           signature_documentation java int itemCount
//                                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
  }

  private boolean notificationsPaused;
//                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
//                                    display_name notificationsPaused
//                                    signature_documentation java private boolean notificationsPaused
//                                    kind Field
  private ModelListObserver observer;
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
//                                   display_name observer
//                                   signature_documentation java private ModelListObserver observer
//                                   kind Field

  void pauseNotifications() {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#pauseNotifications().
//                        display_name pauseNotifications
//                        signature_documentation java void pauseNotifications()
//                        kind Method
    if (notificationsPaused) {
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
      throw new IllegalStateException("Notifications already paused");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }
    notificationsPaused = true;
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
  }

  void resumeNotifications() {
//     ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#resumeNotifications().
//                         display_name resumeNotifications
//                         signature_documentation java void resumeNotifications()
//                         kind Method
    if (!notificationsPaused) {
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
      throw new IllegalStateException("Notifications already resumed");
//              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`(+1).
    }
    notificationsPaused = false;
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
  }

  void setObserver(ModelListObserver observer) {
//     ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#setObserver().
//                 display_name setObserver
//                 signature_documentation java void setObserver(ModelListObserver observer)
//                 kind Method
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                                   ^^^^^^^^ definition local 5
//                                            display_name observer
//                                            signature_documentation java ModelListObserver observer
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#setObserver().
    this.observer = observer;
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
//                  ^^^^^^^^ reference local 5
  }

  private void notifyInsertion(int positionStart, int itemCount) {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                             display_name notifyInsertion
//                             signature_documentation java private void notifyInsertion(int positionStart, int itemCount)
//                             kind Method
//                                 ^^^^^^^^^^^^^ definition local 6
//                                               display_name positionStart
//                                               signature_documentation java int positionStart
//                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                                                    ^^^^^^^^^ definition local 7
//                                                              display_name itemCount
//                                                              signature_documentation java int itemCount
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
    if (!notificationsPaused && observer != null) {
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
//                              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
      observer.onItemRangeInserted(positionStart, itemCount);
//    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
//             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                                 ^^^^^^^^^^^^^ reference local 6
//                                                ^^^^^^^^^ reference local 7
    }
  }

  private void notifyRemoval(int positionStart, int itemCount) {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
//                           display_name notifyRemoval
//                           signature_documentation java private void notifyRemoval(int positionStart, int itemCount)
//                           kind Method
//                               ^^^^^^^^^^^^^ definition local 8
//                                             display_name positionStart
//                                             signature_documentation java int positionStart
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
//                                                  ^^^^^^^^^ definition local 9
//                                                            display_name itemCount
//                                                            signature_documentation java int itemCount
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
    if (!notificationsPaused && observer != null) {
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
//                              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
      observer.onItemRangeRemoved(positionStart, itemCount);
//    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
//             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                                ^^^^^^^^^^^^^ reference local 8
//                                               ^^^^^^^^^ reference local 9
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public EpoxyModel<?> set(int index, EpoxyModel<?> element) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#set().
//                         display_name set
//                         signature_documentation java @Override\npublic EpoxyModel<?> set(int index, EpoxyModel<?> element)
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#set().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#set().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#set().
//                             ^^^^^ definition local 10
//                                   display_name index
//                                   signature_documentation java int index
//                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#set().
//                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^ definition local 11
//                                                          display_name element
//                                                          signature_documentation java EpoxyModel<?> element
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#set().
    EpoxyModel<?> previousModel = super.set(index, element);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^^^^^^^^ definition local 12
//                              display_name previousModel
//                              signature_documentation java EpoxyModel<?> previousModel
//                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#set().
//                                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//                                      ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#set().
//                                          ^^^^^ reference local 10
//                                                 ^^^^^^^ reference local 11

    if (previousModel.id() != element.id()) {
//      ^^^^^^^^^^^^^ reference local 12
//                    ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
//                            ^^^^^^^ reference local 11
//                                    ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#id().
      notifyRemoval(index, 1);
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
//                  ^^^^^ reference local 10
      notifyInsertion(index, 1);
//    ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                    ^^^^^ reference local 10
    }

    return previousModel;
//         ^^^^^^^^^^^^^ reference local 12
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean add(EpoxyModel<?> epoxyModel) {
//               ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#add().
//                   display_name add
//                   signature_documentation java @Override\npublic boolean add(EpoxyModel<?> epoxyModel)
//                   kind Method
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#add().
//                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^^^^^^ definition local 13
//                                            display_name epoxyModel
//                                            signature_documentation java EpoxyModel<?> epoxyModel
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#add().
    notifyInsertion(size(), 1);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
    return super.add(epoxyModel);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//               ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//                   ^^^^^^^^^^ reference local 13
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void add(int index, EpoxyModel<?> element) {
//            ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#add(+1).
//                display_name add
//                signature_documentation java @Override\npublic void add(int index, EpoxyModel<?> element)
//                kind Method
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#add(+1).
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#add(+1).
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#add(+1).
//                    ^^^^^ definition local 14
//                          display_name index
//                          signature_documentation java int index
//                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#add(+1).
//                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^^^ definition local 15
//                                                 display_name element
//                                                 signature_documentation java EpoxyModel<?> element
//                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#add(+1).
    notifyInsertion(index, 1);
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^^ reference local 14
    super.add(index, element);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//        ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add(+1).
//            ^^^^^ reference local 14
//                   ^^^^^^^ reference local 15
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean addAll(Collection<? extends EpoxyModel<?>> c) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#addAll().
//                      display_name addAll
//                      signature_documentation java @Override\npublic boolean addAll(Collection<? extends EpoxyModel<?>> c)
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll().
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^ definition local 16
//                                                            display_name c
//                                                            signature_documentation java Collection<? extends EpoxyModel<?>> c
//                                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#addAll().
    notifyInsertion(size(), c.size());
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
//                          ^ reference local 16
//                            ^^^^ reference semanticdb maven jdk 11 java/util/Collection#size().
    return super.addAll(c);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                      ^ reference local 16
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean addAll(int index, Collection<? extends EpoxyModel<?>> c) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#addAll(+1).
//                      display_name addAll
//                      signature_documentation java @Override\npublic boolean addAll(int index, Collection<? extends EpoxyModel<?>> c)
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#addAll(+1).
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll(+1).
//                          ^^^^^ definition local 17
//                                display_name index
//                                signature_documentation java int index
//                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#addAll(+1).
//                                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ definition local 18
//                                                                       display_name c
//                                                                       signature_documentation java Collection<? extends EpoxyModel<?>> c
//                                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#addAll(+1).
    notifyInsertion(index, c.size());
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^^ reference local 17
//                         ^ reference local 18
//                           ^^^^ reference semanticdb maven jdk 11 java/util/Collection#size().
    return super.addAll(index, c);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#addAll(+1).
//                      ^^^^^ reference local 17
//                             ^ reference local 18
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public EpoxyModel<?> remove(int index) {
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#remove().
//                            display_name remove
//                            signature_documentation java @Override\npublic EpoxyModel<?> remove(int index)
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#remove().
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#remove().
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#remove(+1).
//                                ^^^^^ definition local 19
//                                      display_name index
//                                      signature_documentation java int index
//                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#remove().
    notifyRemoval(index, 1);
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
//                ^^^^^ reference local 19
    return super.remove(index);
//         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#remove().
//                      ^^^^^ reference local 19
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean remove(Object o) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#remove(+1).
//                      display_name remove
//                      signature_documentation java @Override\npublic boolean remove(Object o)
//                      kind Method
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#remove().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#remove(+1).
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#remove().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#remove().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 20
//                               display_name o
//                               signature_documentation java Object o
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#remove(+1).
    int index = indexOf(o);
//      ^^^^^ definition local 21
//            display_name index
//            signature_documentation java int index
//            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#remove(+1).
//              ^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#indexOf().
//                      ^ reference local 20

    if (index == -1) {
//      ^^^^^ reference local 21
      return false;
    }

    notifyRemoval(index, 1);
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
//                ^^^^^ reference local 21
    super.remove(index);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//        ^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#remove().
//               ^^^^^ reference local 21
    return true;
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public void clear() {
//            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#clear().
//                  display_name clear
//                  signature_documentation java @Override\npublic void clear()
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#clear().
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#clear().
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#clear().
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#clear().
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#clear().
    if (!isEmpty()) {
//       ^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#isEmpty().
      notifyRemoval(0, size());
//    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
//                     ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
      super.clear();
//    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//          ^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#clear().
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  protected void removeRange(int fromIndex, int toIndex) {
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#removeRange().
//                           display_name removeRange
//                           signature_documentation java @Override\nprotected void removeRange(int fromIndex, int toIndex)
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#removeRange().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#removeRange().
//                               ^^^^^^^^^ definition local 22
//                                         display_name fromIndex
//                                         signature_documentation java int fromIndex
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#removeRange().
//                                              ^^^^^^^ definition local 23
//                                                      display_name toIndex
//                                                      signature_documentation java int toIndex
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#removeRange().
    if (fromIndex == toIndex) {
//      ^^^^^^^^^ reference local 22
//                   ^^^^^^^ reference local 23
      return;
    }

    notifyRemoval(fromIndex, toIndex - fromIndex);
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#notifyRemoval().
//                ^^^^^^^^^ reference local 22
//                           ^^^^^^^ reference local 23
//                                     ^^^^^^^^^ reference local 22
    super.removeRange(fromIndex, toIndex);
//  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#super.
//        ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#removeRange().
//                    ^^^^^^^^^ reference local 22
//                               ^^^^^^^ reference local 23
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean removeAll(Collection<?> collection) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#removeAll().
//                         display_name removeAll
//                         signature_documentation java @Override\npublic boolean removeAll(Collection<?> collection)
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#removeAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#removeAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#removeAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#removeAll().
//                         ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                       ^^^^^^^^^^ definition local 24
//                                                  display_name collection
//                                                  signature_documentation java Collection<?> collection
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#removeAll().
    // Using this implementation from the Android ArrayList since the Java 1.8 ArrayList
    // doesn't call through to remove. Calling through to remove lets us leverage the notification
    // done there
    boolean result = false;
//          ^^^^^^ definition local 25
//                 display_name result
//                 signature_documentation java boolean result
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#removeAll().
    Iterator<?> it = iterator();
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//              ^^ definition local 26
//                 display_name it
//                 signature_documentation java Iterator<?> it
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#removeAll().
//                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#iterator().
    while (it.hasNext()) {
//         ^^ reference local 26
//            ^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#hasNext().
      if (collection.contains(it.next())) {
//        ^^^^^^^^^^ reference local 24
//                   ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#contains().
//                            ^^ reference local 26
//                               ^^^^ reference semanticdb maven jdk 11 java/util/Iterator#next().
        it.remove();
//      ^^ reference local 26
//         ^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#remove().
        result = true;
//      ^^^^^^ reference local 25
      }
    }
    return result;
//         ^^^^^^ reference local 25
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean retainAll(Collection<?> collection) {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#retainAll().
//                         display_name retainAll
//                         signature_documentation java @Override\npublic boolean retainAll(Collection<?> collection)
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#retainAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#retainAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#retainAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#retainAll().
//                         ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                       ^^^^^^^^^^ definition local 27
//                                                  display_name collection
//                                                  signature_documentation java Collection<?> collection
//                                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#retainAll().
    // Using this implementation from the Android ArrayList since the Java 1.8 ArrayList
    // doesn't call through to remove. Calling through to remove lets us leverage the notification
    // done there
    boolean result = false;
//          ^^^^^^ definition local 28
//                 display_name result
//                 signature_documentation java boolean result
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#retainAll().
    Iterator<?> it = iterator();
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//              ^^ definition local 29
//                 display_name it
//                 signature_documentation java Iterator<?> it
//                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#retainAll().
//                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#iterator().
    while (it.hasNext()) {
//         ^^ reference local 29
//            ^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#hasNext().
      if (!collection.contains(it.next())) {
//         ^^^^^^^^^^ reference local 27
//                    ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#contains().
//                             ^^ reference local 29
//                                ^^^^ reference semanticdb maven jdk 11 java/util/Iterator#next().
        it.remove();
//      ^^ reference local 29
//         ^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#remove().
        result = true;
//      ^^^^^^ reference local 28
      }
    }
    return result;
//         ^^^^^^ reference local 28
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public Iterator<EpoxyModel<?>> iterator() {
//       ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#iterator().
//                                        display_name iterator
//                                        signature_documentation java @NonNull\n@Override\npublic Iterator<EpoxyModel<?>> iterator()
//                                        kind Method
//                                        relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Iterable#iterator().
//                                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#iterator().
//                                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#iterator().
//                                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#iterator().
//                                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#iterator().
//                                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#iterator().
    return new Itr();
//             ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#`<init>`().
  }

  /**
   * An Iterator implementation that calls through to the parent list's methods for modification.
   * Some implementations, like the Android ArrayList.ArrayListIterator class, modify the list data
   * directly instead of calling into the parent list's methods. We need the implementation to call
   * the parent methods so that the proper notifications are done.
   */
  private class Itr implements Iterator<EpoxyModel<?>> {
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#
//                  display_name Itr
//                  signature_documentation java private class Itr
//                  kind Class
//                  documentation  An Iterator implementation that calls through to the parent list's methods for modification.\n Some implementations, like the Android ArrayList.ArrayListIterator class, modify the list data\n directly instead of calling into the parent list's methods. We need the implementation to call\n the parent methods so that the proper notifications are done.\n
//                  relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#`<init>`().
//                  display_name <init>
//                  signature_documentation java private Itr()
//                  kind Constructor
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    int cursor;       // index of next element to return
//      ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//             display_name cursor
//             signature_documentation java int cursor
//             kind Field
    int lastRet = -1; // index of last element returned; -1 if no such
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
//              display_name lastRet
//              signature_documentation java int lastRet
//              kind Field
    int expectedModCount = modCount;
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#expectedModCount.
//                       display_name expectedModCount
//                       signature_documentation java int expectedModCount
//                       kind Field
//                         ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.

    public boolean hasNext() {
//                 ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#hasNext().
//                         display_name hasNext
//                         signature_documentation java public boolean hasNext()
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#hasNext().
      return cursor != size();
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//                     ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
    }

    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
    public EpoxyModel<?> next() {
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#next().
//                            display_name next
//                            signature_documentation java @SuppressWarnings("unchecked")\npublic EpoxyModel<?> next()
//                            kind Method
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#next().
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().
      int i = cursor;
//        ^ definition local 30
//          display_name i
//          signature_documentation java int i
//          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#next().
//            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
      cursor = i + 1;
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//             ^ reference local 30
      lastRet = i;
//    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
//              ^ reference local 30
      return ModelList.this.get(i);
//           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#this.
//                          ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#get().
//                              ^ reference local 30
    }

    public void remove() {
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#remove().
//                     display_name remove
//                     signature_documentation java public void remove()
//                     kind Method
//                     relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#remove().
      if (lastRet < 0) {
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
        throw new IllegalStateException();
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`().
      }
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().

      try {
        ModelList.this.remove(lastRet);
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#this.
//                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#remove().
//                            ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
        cursor = lastRet;
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
        lastRet = -1;
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
        expectedModCount = modCount;
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#expectedModCount.
//                         ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
      } catch (IndexOutOfBoundsException ex) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#
//                                       ^^ definition local 31
//                                          display_name ex
//                                          signature_documentation java IndexOutOfBoundsException ex
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#remove().
        throw new ConcurrentModificationException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
      }
    }

    final void checkForComodification() {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().
//                                    display_name checkForComodification
//                                    signature_documentation java final void checkForComodification()
//                                    kind Method
      if (modCount != expectedModCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#expectedModCount.
        throw new ConcurrentModificationException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
      }
    }
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public ListIterator<EpoxyModel<?>> listIterator() {
//       ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#listIterator().
//                                                display_name listIterator
//                                                signature_documentation java @NonNull\n@Override\npublic ListIterator<EpoxyModel<?>> listIterator()
//                                                kind Method
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#listIterator().
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#listIterator(+1).
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#listIterator().
    return new ListItr(0);
//             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#`<init>`().
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public ListIterator<EpoxyModel<?>> listIterator(int index) {
//       ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#listIterator(+1).
//                                                display_name listIterator
//                                                signature_documentation java @NonNull\n@Override\npublic ListIterator<EpoxyModel<?>> listIterator(int index)
//                                                kind Method
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#listIterator(+1).
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#listIterator().
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#listIterator(+1).
//                                                    ^^^^^ definition local 32
//                                                          display_name index
//                                                          signature_documentation java int index
//                                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#listIterator(+1).
    return new ListItr(index);
//             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#`<init>`().
//                     ^^^^^ reference local 32
  }

  /**
   * A ListIterator implementation that calls through to the parent list's methods for modification.
   * Some implementations may modify the list data directly instead of calling into the parent
   * list's methods. We need the implementation to call the parent methods so that the proper
   * notifications are done.
   */
  private class ListItr extends Itr implements ListIterator<EpoxyModel<?>> {
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#
//                      display_name ListItr
//                      signature_documentation java private class ListItr
//                      kind Class
//                      documentation  A ListIterator implementation that calls through to the parent list's methods for modification.\n Some implementations may modify the list data directly instead of calling into the parent\n list's methods. We need the implementation to call the parent methods so that the proper\n notifications are done.\n
//                      relationship is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#
//                      relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//                      relationship is_implementation semanticdb maven jdk 11 java/util/ListIterator#
//                              ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#
//                                             ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    ListItr(int index) {
//  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#`<init>`().
//          display_name <init>
//          signature_documentation java ListItr(int index)
//          kind Constructor
//              ^^^^^ definition local 33
//                    display_name index
//                    signature_documentation java int index
//                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#`<init>`().
      cursor = index;
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//             ^^^^^ reference local 33
    }

    public boolean hasPrevious() {
//                 ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#hasPrevious().
//                             display_name hasPrevious
//                             signature_documentation java public boolean hasPrevious()
//                             kind Method
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#hasPrevious().
      return cursor != 0;
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    public int nextIndex() {
//             ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#nextIndex().
//                       display_name nextIndex
//                       signature_documentation java public int nextIndex()
//                       kind Method
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
      return cursor;
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    public int previousIndex() {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#previousIndex().
//                           display_name previousIndex
//                           signature_documentation java public int previousIndex()
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
      return cursor - 1;
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
    public EpoxyModel<?> previous() {
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#previous().
//                                display_name previous
//                                signature_documentation java @SuppressWarnings("unchecked")\npublic EpoxyModel<?> previous()
//                                kind Method
//                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#previous().
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().
      int i = cursor - 1;
//        ^ definition local 34
//          display_name i
//          signature_documentation java int i
//          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#previous().
//            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
      if (i < 0) {
//        ^ reference local 34
        throw new NoSuchElementException();
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/NoSuchElementException#`<init>`().
      }

      cursor = i;
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//             ^ reference local 34
      lastRet = i;
//    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
//              ^ reference local 34
      return ModelList.this.get(i);
//           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                     ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#this.
//                          ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#get().
//                              ^ reference local 34
    }

    public void set(EpoxyModel<?> e) {
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#set().
//                  display_name set
//                  signature_documentation java public void set(EpoxyModel<?> e)
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#set().
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^ definition local 35
//                                  display_name e
//                                  signature_documentation java EpoxyModel<?> e
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#set().
      if (lastRet < 0) {
//        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
        throw new IllegalStateException();
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalStateException#`<init>`().
      }
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().

      try {
        ModelList.this.set(lastRet, e);
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#this.
//                     ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#set().
//                         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
//                                  ^ reference local 35
      } catch (IndexOutOfBoundsException ex) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#
//                                       ^^ definition local 36
//                                          display_name ex
//                                          signature_documentation java IndexOutOfBoundsException ex
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#set().
        throw new ConcurrentModificationException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
      }
    }

    public void add(EpoxyModel<?> e) {
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#add().
//                  display_name add
//                  signature_documentation java public void add(EpoxyModel<?> e)
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#add().
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^ definition local 37
//                                  display_name e
//                                  signature_documentation java EpoxyModel<?> e
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#add().
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().

      try {
        int i = cursor;
//          ^ definition local 38
//            display_name i
//            signature_documentation java int i
//            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#add().
//              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
        ModelList.this.add(i, e);
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#this.
//                     ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#add(+1).
//                         ^ reference local 38
//                            ^ reference local 37
        cursor = i + 1;
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//               ^ reference local 38
        lastRet = -1;
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
        expectedModCount = modCount;
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#expectedModCount.
//                         ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
      } catch (IndexOutOfBoundsException ex) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#
//                                       ^^ definition local 39
//                                          display_name ex
//                                          signature_documentation java IndexOutOfBoundsException ex
//                                          enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#add().
        throw new ConcurrentModificationException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
      }
    }
  }

  @NonNull
// ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public List<EpoxyModel<?>> subList(int start, int end) {
//       ^^^^ reference semanticdb maven jdk 11 java/util/List#
//            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#subList().
//                                   display_name subList
//                                   signature_documentation java @NonNull\n@Override\npublic List<EpoxyModel<?>> subList(int start, int end)
//                                   kind Method
//                                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#subList().
//                                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#subList().
//                                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#subList().
//                                       ^^^^^ definition local 40
//                                             display_name start
//                                             signature_documentation java int start
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#subList().
//                                                  ^^^ definition local 41
//                                                      display_name end
//                                                      signature_documentation java int end
//                                                      enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#subList().
    if (start >= 0 && end <= size()) {
//      ^^^^^ reference local 40
//                    ^^^ reference local 41
//                           ^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#size().
      if (start <= end) {
//        ^^^^^ reference local 40
//                 ^^^ reference local 41
        return new SubList(this, start, end);
//                 ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#`<init>`().
//                               ^^^^^ reference local 40
//                                      ^^^ reference local 41
      }
      throw new IllegalArgumentException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`().
    }
    throw new IndexOutOfBoundsException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#`<init>`().
  }

  /**
   * A SubList implementation from Android's AbstractList class. It's copied here to make sure the
   * implementation doesn't change, since some implementations, like the Java 1.8 ArrayList.SubList
   * class, modify the list data directly instead of calling into the parent list's methods. We need
   * the implementation to call the parent methods so that the proper notifications are done.
   */
  private static class SubList extends AbstractList<EpoxyModel<?>> {
//                     ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#
//                             display_name SubList
//                             signature_documentation java private static class SubList
//                             kind Class
//                             documentation  A SubList implementation from Android's AbstractList class. It's copied here to make sure the\n implementation doesn't change, since some implementations, like the Java 1.8 ArrayList.SubList\n class, modify the list data directly instead of calling into the parent list's methods. We need\n the implementation to call the parent methods so that the proper notifications are done.\n
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/AbstractList#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/List#
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#
//                                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    private final ModelList fullList;
//                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                                   display_name fullList
//                                   signature_documentation java private final ModelList fullList
//                                   kind Field
    private int offset;
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                     display_name offset
//                     signature_documentation java private int offset
//                     kind Field
    private int size;
//              ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
//                   display_name size
//                   signature_documentation java private int size
//                   kind Field

    private static final class SubListIterator implements ListIterator<EpoxyModel<?>> {
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#
//                                             display_name SubListIterator
//                                             signature_documentation java private static final class SubListIterator
//                                             kind Class
//                                             relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//                                             relationship is_implementation semanticdb maven jdk 11 java/util/ListIterator#
//                                                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
      private final SubList subList;
//                  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#
//                          ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//                                  display_name subList
//                                  signature_documentation java private final SubList subList
//                                  kind Field
      private final ListIterator<EpoxyModel<?>> iterator;
//                  ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                                                       display_name iterator
//                                                       signature_documentation java private final ListIterator<EpoxyModel<?>> iterator
//                                                       kind Field
      private int start;
//                ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
//                      display_name start
//                      signature_documentation java private int start
//                      kind Field
      private int end;
//                ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
//                    display_name end
//                    signature_documentation java private int end
//                    kind Field

      SubListIterator(ListIterator<EpoxyModel<?>> it, SubList list, int offset, int length) {
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                    display_name <init>
//                    signature_documentation java SubListIterator(ListIterator<EpoxyModel<?>> it, SubList list, int offset, int length)
//                    kind Constructor
//                    ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                ^^ definition local 42
//                                                   display_name it
//                                                   signature_documentation java ListIterator<EpoxyModel<?>> it
//                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#
//                                                            ^^^^ definition local 43
//                                                                 display_name list
//                                                                 signature_documentation java SubList list
//                                                                 enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                                                                      ^^^^^^ definition local 44
//                                                                             display_name offset
//                                                                             signature_documentation java int offset
//                                                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                                                                                  ^^^^^^ definition local 45
//                                                                                         display_name length
//                                                                                         signature_documentation java int length
//                                                                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
        iterator = it;
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                 ^^ reference local 42
        subList = list;
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//                ^^^^ reference local 43
        start = offset;
//      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
//              ^^^^^^ reference local 44
        end = start + length;
//      ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
//            ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
//                    ^^^^^^ reference local 45
      }

      public void add(EpoxyModel<?> object) {
//                ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#add().
//                    display_name add
//                    signature_documentation java public void add(EpoxyModel<?> object)
//                    kind Method
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#add().
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^ definition local 46
//                                         display_name object
//                                         signature_documentation java EpoxyModel<?> object
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#add().
        iterator.add(object);
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//               ^^^ reference semanticdb maven jdk 11 java/util/ListIterator#add().
//                   ^^^^^^ reference local 46
        subList.sizeChanged(true);
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#sizeChanged().
        end++;
//      ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
      }

      public boolean hasNext() {
//                   ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#hasNext().
//                           display_name hasNext
//                           signature_documentation java public boolean hasNext()
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#hasNext().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#hasNext().
        return iterator.nextIndex() < end;
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
//                                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
      }

      public boolean hasPrevious() {
//                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#hasPrevious().
//                               display_name hasPrevious
//                               signature_documentation java public boolean hasPrevious()
//                               kind Method
//                               relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#hasPrevious().
        return iterator.previousIndex() >= start;
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
//                                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
      }

      public EpoxyModel<?> next() {
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                         ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#next().
//                              display_name next
//                              signature_documentation java public EpoxyModel<?> next()
//                              kind Method
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#next().
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#next().
        if (iterator.nextIndex() < end) {
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                   ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
//                                 ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
          return iterator.next();
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                        ^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#next().
        }
        throw new NoSuchElementException();
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/NoSuchElementException#`<init>`().
      }

      public int nextIndex() {
//               ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#nextIndex().
//                         display_name nextIndex
//                         signature_documentation java public int nextIndex()
//                         kind Method
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
        return iterator.nextIndex() - start;
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
//                                    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
      }

      public EpoxyModel<?> previous() {
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#previous().
//                                  display_name previous
//                                  signature_documentation java public EpoxyModel<?> previous()
//                                  kind Method
//                                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#previous().
        if (iterator.previousIndex() >= start) {
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                   ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
//                                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
          return iterator.previous();
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#previous().
        }
        throw new NoSuchElementException();
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/NoSuchElementException#`<init>`().
      }

      public int previousIndex() {
//               ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#previousIndex().
//                             display_name previousIndex
//                             signature_documentation java public int previousIndex()
//                             kind Method
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
        int previous = iterator.previousIndex();
//          ^^^^^^^^ definition local 47
//                   display_name previous
//                   signature_documentation java int previous
//                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#previousIndex().
//                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                              ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
        if (previous >= start) {
//          ^^^^^^^^ reference local 47
//                      ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
          return previous - start;
//               ^^^^^^^^ reference local 47
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
        }
        return -1;
      }

      public void remove() {
//                ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#remove().
//                       display_name remove
//                       signature_documentation java public void remove()
//                       kind Method
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#remove().
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#remove().
        iterator.remove();
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#remove().
        subList.sizeChanged(false);
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#sizeChanged().
        end--;
//      ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
      }

      public void set(EpoxyModel<?> object) {
//                ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#set().
//                    display_name set
//                    signature_documentation java public void set(EpoxyModel<?> object)
//                    kind Method
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#set().
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^ definition local 48
//                                         display_name object
//                                         signature_documentation java EpoxyModel<?> object
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#set().
        iterator.set(object);
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//               ^^^ reference semanticdb maven jdk 11 java/util/ListIterator#set().
//                   ^^^^^^ reference local 48
      }
    }

    SubList(ModelList list, int start, int end) {
//  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#`<init>`().
//          display_name <init>
//          signature_documentation java SubList(ModelList list, int start, int end)
//          kind Constructor
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                    ^^^^ definition local 49
//                         display_name list
//                         signature_documentation java ModelList list
//                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#`<init>`().
//                              ^^^^^ definition local 50
//                                    display_name start
//                                    signature_documentation java int start
//                                    enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#`<init>`().
//                                         ^^^ definition local 51
//                                             display_name end
//                                             signature_documentation java int end
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#`<init>`().
      fullList = list;
//    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//               ^^^^ reference local 49
      modCount = fullList.modCount;
//    ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
      offset = start;
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//             ^^^^^ reference local 50
      size = end - start;
//    ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
//           ^^^ reference local 51
//                 ^^^^^ reference local 50
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public void add(int location, EpoxyModel<?> object) {
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#add().
//                  display_name add
//                  signature_documentation java @Override\npublic void add(int location, EpoxyModel<?> object)
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#add(+1).
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#add(+1).
//                      ^^^^^^^^ definition local 52
//                               display_name location
//                               signature_documentation java int location
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#add().
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^ definition local 53
//                                                     display_name object
//                                                     signature_documentation java EpoxyModel<?> object
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#add().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        if (location >= 0 && location <= size) {
//          ^^^^^^^^ reference local 52
//                           ^^^^^^^^ reference local 52
//                                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          fullList.add(location + offset, object);
//        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                 ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#add(+1).
//                     ^^^^^^^^ reference local 52
//                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                                        ^^^^^^ reference local 53
          size++;
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          modCount = fullList.modCount;
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        } else {
          throw new IndexOutOfBoundsException();
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#`<init>`().
        }
      } else {
        throw new ConcurrentModificationException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
      }
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean addAll(int location, Collection<? extends EpoxyModel<?>> collection) {
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#addAll().
//                        display_name addAll
//                        signature_documentation java @Override\npublic boolean addAll(int location, Collection<? extends EpoxyModel<?>> collection)
//                        kind Method
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#addAll().
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll(+1).
//                            ^^^^^^^^ definition local 54
//                                     display_name location
//                                     signature_documentation java int location
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#addAll().
//                                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^^^^ definition local 55
//                                                                                     display_name collection
//                                                                                     signature_documentation java Collection<? extends EpoxyModel<?>> collection
//                                                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#addAll().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        if (location >= 0 && location <= size) {
//          ^^^^^^^^ reference local 54
//                           ^^^^^^^^ reference local 54
//                                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          boolean result = fullList.addAll(location + offset, collection);
//                ^^^^^^ definition local 56
//                       display_name result
//                       signature_documentation java boolean result
//                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#addAll().
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                                  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#addAll(+1).
//                                         ^^^^^^^^ reference local 54
//                                                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                                                            ^^^^^^^^^^ reference local 55
          if (result) {
//            ^^^^^^ reference local 56
            size += collection.size();
//          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
//                  ^^^^^^^^^^ reference local 55
//                             ^^^^ reference semanticdb maven jdk 11 java/util/Collection#size().
            modCount = fullList.modCount;
//          ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                              ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
          }
          return result;
//               ^^^^^^ reference local 56
        }
        throw new IndexOutOfBoundsException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#`<init>`().
      }
      throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public boolean addAll(@NonNull Collection<? extends EpoxyModel<?>> collection) {
//                 ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#addAll(+1).
//                        display_name addAll
//                        signature_documentation java @Override\npublic boolean addAll(Collection<? extends EpoxyModel<?>> collection)
//                        kind Method
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#addAll().
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#addAll().
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll().
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^^^^^^^^^^ definition local 57
//                                                                                display_name collection
//                                                                                signature_documentation java @NonNull\nCollection<? extends EpoxyModel<?>> collection
//                                                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#addAll(+1).
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        boolean result = fullList.addAll(offset + size, collection);
//              ^^^^^^ definition local 58
//                     display_name result
//                     signature_documentation java boolean result
//                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#addAll(+1).
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#addAll(+1).
//                                       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                                                ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
//                                                      ^^^^^^^^^^ reference local 57
        if (result) {
//          ^^^^^^ reference local 58
          size += collection.size();
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
//                ^^^^^^^^^^ reference local 57
//                           ^^^^ reference semanticdb maven jdk 11 java/util/Collection#size().
          modCount = fullList.modCount;
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        }
        return result;
//             ^^^^^^ reference local 58
      }
      throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public EpoxyModel<?> get(int location) {
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#get().
//                           display_name get
//                           signature_documentation java @Override\npublic EpoxyModel<?> get(int location)
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#get().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#get().
//                               ^^^^^^^^ definition local 59
//                                        display_name location
//                                        signature_documentation java int location
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#get().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        if (location >= 0 && location < size) {
//          ^^^^^^^^ reference local 59
//                           ^^^^^^^^ reference local 59
//                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          return fullList.get(location + offset);
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#get().
//                            ^^^^^^^^ reference local 59
//                                       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
        }
        throw new IndexOutOfBoundsException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#`<init>`().
      }
      throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
    }

    @NonNull
//   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public Iterator<EpoxyModel<?>> iterator() {
//         ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#iterator().
//                                          display_name iterator
//                                          signature_documentation java @NonNull\n@Override\npublic Iterator<EpoxyModel<?>> iterator()
//                                          kind Method
//                                          relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Iterable#iterator().
//                                          relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#iterator().
//                                          relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#iterator().
//                                          relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#iterator().
//                                          relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#iterator().
      return listIterator(0);
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#listIterator().
    }

    @NonNull
//   ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public ListIterator<EpoxyModel<?>> listIterator(int location) {
//         ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#listIterator().
//                                                  display_name listIterator
//                                                  signature_documentation java @NonNull\n@Override\npublic ListIterator<EpoxyModel<?>> listIterator(int location)
//                                                  kind Method
//                                                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#listIterator(+1).
//                                                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#listIterator(+1).
//                                                      ^^^^^^^^ definition local 60
//                                                               display_name location
//                                                               signature_documentation java int location
//                                                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#listIterator().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        if (location >= 0 && location <= size) {
//          ^^^^^^^^ reference local 60
//                           ^^^^^^^^ reference local 60
//                                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          return new SubListIterator(fullList.listIterator(location + offset), this, offset, size);
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#listIterator(+1).
//                                                         ^^^^^^^^ reference local 60
//                                                                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                                                                                   ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                                                                                           ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
        }
        throw new IndexOutOfBoundsException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#`<init>`().
      }
      throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public EpoxyModel<?> remove(int location) {
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#remove().
//                              display_name remove
//                              signature_documentation java @Override\npublic EpoxyModel<?> remove(int location)
//                              kind Method
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#remove().
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#remove(+1).
//                                  ^^^^^^^^ definition local 61
//                                           display_name location
//                                           signature_documentation java int location
//                                           enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#remove().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        if (location >= 0 && location < size) {
//          ^^^^^^^^ reference local 61
//                           ^^^^^^^^ reference local 61
//                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          EpoxyModel<?> result = fullList.remove(location + offset);
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^ definition local 62
//                             display_name result
//                             signature_documentation java EpoxyModel<?> result
//                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#remove().
//                               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                                        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#remove().
//                                               ^^^^^^^^ reference local 61
//                                                          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
          size--;
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          modCount = fullList.modCount;
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
          return result;
//               ^^^^^^ reference local 62
        }
        throw new IndexOutOfBoundsException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#`<init>`().
      }
      throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    protected void removeRange(int start, int end) {
//                 ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#removeRange().
//                             display_name removeRange
//                             signature_documentation java @Override\nprotected void removeRange(int start, int end)
//                             kind Method
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#removeRange().
//                                 ^^^^^ definition local 63
//                                       display_name start
//                                       signature_documentation java int start
//                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#removeRange().
//                                            ^^^ definition local 64
//                                                display_name end
//                                                signature_documentation java int end
//                                                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#removeRange().
      if (start != end) {
//        ^^^^^ reference local 63
//                 ^^^ reference local 64
        if (modCount == fullList.modCount) {
//          ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                               ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
          fullList.removeRange(start + offset, end + offset);
//        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#removeRange().
//                             ^^^^^ reference local 63
//                                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                                             ^^^ reference local 64
//                                                   ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
          size -= end - start;
//        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
//                ^^^ reference local 64
//                      ^^^^^ reference local 63
          modCount = fullList.modCount;
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        } else {
          throw new ConcurrentModificationException();
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
        }
      }
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public EpoxyModel<?> set(int location, EpoxyModel<?> object) {
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#set().
//                           display_name set
//                           signature_documentation java @Override\npublic EpoxyModel<?> set(int location, EpoxyModel<?> object)
//                           kind Method
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#set().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#set().
//                               ^^^^^^^^ definition local 65
//                                        display_name location
//                                        signature_documentation java int location
//                                        enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#set().
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                       ^^^^^^ definition local 66
//                                                              display_name object
//                                                              signature_documentation java EpoxyModel<?> object
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#set().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        if (location >= 0 && location < size) {
//          ^^^^^^^^ reference local 65
//                           ^^^^^^^^ reference local 65
//                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
          return fullList.set(location + offset, object);
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#set().
//                            ^^^^^^^^ reference local 65
//                                       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                                               ^^^^^^ reference local 66
        }
        throw new IndexOutOfBoundsException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IndexOutOfBoundsException#`<init>`().
      }
      throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
    }

    @Override
//   ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
    public int size() {
//             ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size().
//                  display_name size
//                  signature_documentation java @Override\npublic int size()
//                  kind Method
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#size().
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#size().
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#size().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        return size;
//             ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
      }
      throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
    }

    void sizeChanged(boolean increment) {
//       ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#sizeChanged().
//                   display_name sizeChanged
//                   signature_documentation java void sizeChanged(boolean increment)
//                   kind Method
//                           ^^^^^^^^^ definition local 67
//                                     display_name increment
//                                     signature_documentation java boolean increment
//                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#sizeChanged().
      if (increment) {
//        ^^^^^^^^^ reference local 67
        size++;
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
      } else {
        size--;
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
      }
      modCount = fullList.modCount;
//    ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
    }
  }
}
