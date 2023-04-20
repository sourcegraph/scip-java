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
//              documentation ```java\nclass ModelList\n```
//              documentation  Used by our {@link EpoxyAdapter} to track models. It simply wraps ArrayList and notifies an\n observer when remove or insertion operations are done on the list. This allows us to optimize\n diffing since we have a knowledge of what changed in the list.\n
//              relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//              relationship is_implementation semanticdb maven jdk 11 java/lang/Cloneable#
//              relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//              relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//              relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//              relationship is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#
//              relationship is_implementation semanticdb maven jdk 11 java/util/AbstractList#
//              relationship is_implementation semanticdb maven jdk 11 java/util/ArrayList#
//              relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//              relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//              relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//              relationship is_implementation semanticdb maven jdk 11 java/util/List#
//              relationship is_implementation semanticdb maven jdk 11 java/util/List#
//              relationship is_implementation semanticdb maven jdk 11 java/util/RandomAccess#
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#

  ModelList(int expectedModelCount) {
//^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`().
//          documentation ```java\nModelList(int expectedModelCount)\n```
//              ^^^^^^^^^^^^^^^^^^ definition local 0
//                                 documentation ```java\nint expectedModelCount\n```
    super(expectedModelCount);
//  ^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`().
//        ^^^^^^^^^^^^^^^^^^ reference local 0
  }

  ModelList() {
//^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#`<init>`(+1).
//          documentation ```java\nModelList()\n```

  }

  interface ModelListObserver {
//          ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                            documentation ```java\ninterface ModelListObserver\n```
    void onItemRangeInserted(int positionStart, int itemCount);
//       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                           documentation ```java\npublic abstract void onItemRangeInserted(int positionStart, int itemCount)\n```
//                               ^^^^^^^^^^^^^ definition local 1
//                                             documentation ```java\nint positionStart\n```
//                                                  ^^^^^^^^^ definition local 2
//                                                            documentation ```java\nint itemCount\n```
    void onItemRangeRemoved(int positionStart, int itemCount);
//       ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                          documentation ```java\npublic abstract void onItemRangeRemoved(int positionStart, int itemCount)\n```
//                              ^^^^^^^^^^^^^ definition local 3
//                                            documentation ```java\nint positionStart\n```
//                                                 ^^^^^^^^^ definition local 4
//                                                           documentation ```java\nint itemCount\n```
  }

  private boolean notificationsPaused;
//                ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#notificationsPaused.
//                                    documentation ```java\nprivate boolean notificationsPaused\n```
  private ModelListObserver observer;
//        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
//                                   documentation ```java\nprivate ModelListObserver observer\n```

  void pauseNotifications() {
//     ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#pauseNotifications().
//                        documentation ```java\nvoid pauseNotifications()\n```
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
//                         documentation ```java\nvoid resumeNotifications()\n```
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
//                 documentation ```java\nvoid setObserver(ModelListObserver observer)\n```
//                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#ModelListObserver#
//                                   ^^^^^^^^ definition local 5
//                                            documentation ```java\nModelListObserver observer\n```
    this.observer = observer;
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#observer.
//                  ^^^^^^^^ reference local 5
  }

  private void notifyInsertion(int positionStart, int itemCount) {
//             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#notifyInsertion().
//                             documentation ```java\nprivate void notifyInsertion(int positionStart, int itemCount)\n```
//                                 ^^^^^^^^^^^^^ definition local 6
//                                               documentation ```java\nint positionStart\n```
//                                                    ^^^^^^^^^ definition local 7
//                                                              documentation ```java\nint itemCount\n```
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
//                           documentation ```java\nprivate void notifyRemoval(int positionStart, int itemCount)\n```
//                               ^^^^^^^^^^^^^ definition local 8
//                                             documentation ```java\nint positionStart\n```
//                                                  ^^^^^^^^^ definition local 9
//                                                            documentation ```java\nint itemCount\n```
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
//                         documentation ```java\n@Override\npublic EpoxyModel<?> set(int index, EpoxyModel<?> element)\n```
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#set().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#set().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#set().
//                             ^^^^^ definition local 10
//                                   documentation ```java\nint index\n```
//                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^ definition local 11
//                                                          documentation ```java\nEpoxyModel<?> element\n```
    EpoxyModel<?> previousModel = super.set(index, element);
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^^^^^^^^ definition local 12
//                              documentation ```java\nEpoxyModel<?> previousModel\n```
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
//                   documentation ```java\n@Override\npublic boolean add(EpoxyModel<?> epoxyModel)\n```
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#add().
//                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#add().
//                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^^^^^^ definition local 13
//                                            documentation ```java\nEpoxyModel<?> epoxyModel\n```
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
//                documentation ```java\n@Override\npublic void add(int index, EpoxyModel<?> element)\n```
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#add(+1).
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#add(+1).
//                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#add(+1).
//                    ^^^^^ definition local 14
//                          documentation ```java\nint index\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^^^ definition local 15
//                                                 documentation ```java\nEpoxyModel<?> element\n```
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
//                      documentation ```java\n@Override\npublic boolean addAll(Collection<? extends EpoxyModel<?>> c)\n```
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll().
//                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                          ^ definition local 16
//                                                            documentation ```java\nCollection<? extends EpoxyModel<?>> c\n```
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
//                      documentation ```java\n@Override\npublic boolean addAll(int index, Collection<? extends EpoxyModel<?>> c)\n```
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#addAll().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#addAll(+1).
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll(+1).
//                          ^^^^^ definition local 17
//                                documentation ```java\nint index\n```
//                                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ definition local 18
//                                                                       documentation ```java\nCollection<? extends EpoxyModel<?>> c\n```
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
//                            documentation ```java\n@Override\npublic EpoxyModel<?> remove(int index)\n```
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#remove().
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#remove().
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#remove(+1).
//                                ^^^^^ definition local 19
//                                      documentation ```java\nint index\n```
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
//                      documentation ```java\n@Override\npublic boolean remove(Object o)\n```
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#remove().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#remove(+1).
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#remove().
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#remove().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 20
//                               documentation ```java\nObject o\n```
    int index = indexOf(o);
//      ^^^^^ definition local 21
//            documentation ```java\nint index\n```
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
//                  documentation ```java\n@Override\npublic void clear()\n```
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
//                           documentation ```java\n@Override\nprotected void removeRange(int fromIndex, int toIndex)\n```
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#removeRange().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#removeRange().
//                               ^^^^^^^^^ definition local 22
//                                         documentation ```java\nint fromIndex\n```
//                                              ^^^^^^^ definition local 23
//                                                      documentation ```java\nint toIndex\n```
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
//                         documentation ```java\n@Override\npublic boolean removeAll(Collection<?> collection)\n```
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#removeAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#removeAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#removeAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#removeAll().
//                         ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                       ^^^^^^^^^^ definition local 24
//                                                  documentation ```java\nCollection<?> collection\n```
    // Using this implementation from the Android ArrayList since the Java 1.8 ArrayList
    // doesn't call through to remove. Calling through to remove lets us leverage the notification
    // done there
    boolean result = false;
//          ^^^^^^ definition local 25
//                 documentation ```java\nboolean result\n```
    Iterator<?> it = iterator();
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//              ^^ definition local 26
//                 documentation ```java\nIterator<?> it\n```
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
//                         documentation ```java\n@Override\npublic boolean retainAll(Collection<?> collection)\n```
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#retainAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#retainAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#retainAll().
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#retainAll().
//                         ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                       ^^^^^^^^^^ definition local 27
//                                                  documentation ```java\nCollection<?> collection\n```
    // Using this implementation from the Android ArrayList since the Java 1.8 ArrayList
    // doesn't call through to remove. Calling through to remove lets us leverage the notification
    // done there
    boolean result = false;
//          ^^^^^^ definition local 28
//                 documentation ```java\nboolean result\n```
    Iterator<?> it = iterator();
//  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//              ^^ definition local 29
//                 documentation ```java\nIterator<?> it\n```
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
//                                        documentation ```java\n@NonNull\n@Override\npublic Iterator<EpoxyModel<?>> iterator()\n```
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
//                  documentation ```java\nprivate class Itr\n```
//                  documentation  An Iterator implementation that calls through to the parent list's methods for modification.\n Some implementations, like the Android ArrayList.ArrayListIterator class, modify the list data\n directly instead of calling into the parent list's methods. We need the implementation to call\n the parent methods so that the proper notifications are done.\n
//                  relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#`<init>`().
//                  documentation ```java\nprivate Itr()\n```
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Iterator#
//                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    int cursor;       // index of next element to return
//      ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//             documentation ```java\nint cursor\n```
    int lastRet = -1; // index of last element returned; -1 if no such
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#lastRet.
//              documentation ```java\nint lastRet\n```
    int expectedModCount = modCount;
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#expectedModCount.
//                       documentation ```java\nint expectedModCount\n```
//                         ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.

    public boolean hasNext() {
//                 ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#hasNext().
//                         documentation ```java\npublic boolean hasNext()\n```
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
//                            documentation ```java\n@SuppressWarnings("unchecked")\npublic EpoxyModel<?> next()\n```
//                            relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#next().
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().
      int i = cursor;
//        ^ definition local 30
//          documentation ```java\nint i\n```
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
//                     documentation ```java\npublic void remove()\n```
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
//                                          documentation ```java\nIndexOutOfBoundsException ex\n```
        throw new ConcurrentModificationException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
      }
    }

    final void checkForComodification() {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().
//                                    documentation ```java\nfinal void checkForComodification()\n```
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
//                                                documentation ```java\n@NonNull\n@Override\npublic ListIterator<EpoxyModel<?>> listIterator()\n```
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
//                                                documentation ```java\n@NonNull\n@Override\npublic ListIterator<EpoxyModel<?>> listIterator(int index)\n```
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#listIterator(+1).
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#listIterator().
//                                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#listIterator(+1).
//                                                    ^^^^^ definition local 32
//                                                          documentation ```java\nint index\n```
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
//                      documentation ```java\nprivate class ListItr\n```
//                      documentation  A ListIterator implementation that calls through to the parent list's methods for modification.\n Some implementations may modify the list data directly instead of calling into the parent\n list's methods. We need the implementation to call the parent methods so that the proper\n notifications are done.\n
//                      relationship is_implementation semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#
//                      relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//                      relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//                      relationship is_implementation semanticdb maven jdk 11 java/util/ListIterator#
//                              ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#
//                                             ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    ListItr(int index) {
//  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#`<init>`().
//          documentation ```java\nListItr(int index)\n```
//              ^^^^^ definition local 33
//                    documentation ```java\nint index\n```
      cursor = index;
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
//             ^^^^^ reference local 33
    }

    public boolean hasPrevious() {
//                 ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#hasPrevious().
//                             documentation ```java\npublic boolean hasPrevious()\n```
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#hasPrevious().
      return cursor != 0;
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    public int nextIndex() {
//             ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#nextIndex().
//                       documentation ```java\npublic int nextIndex()\n```
//                       relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
      return cursor;
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    public int previousIndex() {
//             ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#previousIndex().
//                           documentation ```java\npublic int previousIndex()\n```
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
      return cursor - 1;
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/SuppressWarnings#
    public EpoxyModel<?> previous() {
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#previous().
//                                documentation ```java\n@SuppressWarnings("unchecked")\npublic EpoxyModel<?> previous()\n```
//                                relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#previous().
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().
      int i = cursor - 1;
//        ^ definition local 34
//          documentation ```java\nint i\n```
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
//                  documentation ```java\npublic void set(EpoxyModel<?> e)\n```
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#set().
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^ definition local 35
//                                  documentation ```java\nEpoxyModel<?> e\n```
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
//                                          documentation ```java\nIndexOutOfBoundsException ex\n```
        throw new ConcurrentModificationException();
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ConcurrentModificationException#`<init>`().
      }
    }

    public void add(EpoxyModel<?> e) {
//              ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#ListItr#add().
//                  documentation ```java\npublic void add(EpoxyModel<?> e)\n```
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#add().
//                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                ^ definition local 37
//                                  documentation ```java\nEpoxyModel<?> e\n```
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#Itr#checkForComodification().

      try {
        int i = cursor;
//          ^ definition local 38
//            documentation ```java\nint i\n```
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
//                                          documentation ```java\nIndexOutOfBoundsException ex\n```
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
//                                   documentation ```java\n@NonNull\n@Override\npublic List<EpoxyModel<?>> subList(int start, int end)\n```
//                                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#subList().
//                                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ArrayList#subList().
//                                   relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#subList().
//                                       ^^^^^ definition local 40
//                                             documentation ```java\nint start\n```
//                                                  ^^^ definition local 41
//                                                      documentation ```java\nint end\n```
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
//                             documentation ```java\nprivate static class SubList\n```
//                             documentation  A SubList implementation from Android's AbstractList class. It's copied here to make sure the\n implementation doesn't change, since some implementations, like the Java 1.8 ArrayList.SubList\n class, modify the list data directly instead of calling into the parent list's methods. We need\n the implementation to call the parent methods so that the proper notifications are done.\n
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/Iterable#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/AbstractList#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/Collection#
//                             relationship is_implementation semanticdb maven jdk 11 java/util/List#
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#
//                                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
    private final ModelList fullList;
//                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                                   documentation ```java\nprivate final ModelList fullList\n```
    private int offset;
//              ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#offset.
//                     documentation ```java\nprivate int offset\n```
    private int size;
//              ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#size.
//                   documentation ```java\nprivate int size\n```

    private static final class SubListIterator implements ListIterator<EpoxyModel<?>> {
//                             ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#
//                                             documentation ```java\nprivate static final class SubListIterator\n```
//                                             relationship is_implementation semanticdb maven jdk 11 java/util/Iterator#
//                                             relationship is_implementation semanticdb maven jdk 11 java/util/ListIterator#
//                                                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
      private final SubList subList;
//                  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#
//                          ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//                                  documentation ```java\nprivate final SubList subList\n```
      private final ListIterator<EpoxyModel<?>> iterator;
//                  ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                                                       documentation ```java\nprivate final ListIterator<EpoxyModel<?>> iterator\n```
      private int start;
//                ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
//                      documentation ```java\nprivate int start\n```
      private int end;
//                ^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
//                    documentation ```java\nprivate int end\n```

      SubListIterator(ListIterator<EpoxyModel<?>> it, SubList list, int offset, int length) {
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                    documentation ```java\nSubListIterator(ListIterator<EpoxyModel<?>> it, SubList list, int offset, int length)\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                ^^ definition local 42
//                                                   documentation ```java\nListIterator<EpoxyModel<?>> it\n```
//                                                    ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#
//                                                            ^^^^ definition local 43
//                                                                 documentation ```java\nSubList list\n```
//                                                                      ^^^^^^ definition local 44
//                                                                             documentation ```java\nint offset\n```
//                                                                                  ^^^^^^ definition local 45
//                                                                                         documentation ```java\nint length\n```
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
//                    documentation ```java\npublic void add(EpoxyModel<?> object)\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#add().
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^ definition local 46
//                                         documentation ```java\nEpoxyModel<?> object\n```
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
//                           documentation ```java\npublic boolean hasNext()\n```
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Iterator#hasNext().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#hasNext().
        return iterator.nextIndex() < end;
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
//                                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
      }

      public boolean hasPrevious() {
//                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#hasPrevious().
//                               documentation ```java\npublic boolean hasPrevious()\n```
//                               relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#hasPrevious().
        return iterator.previousIndex() >= start;
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
//                                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
      }

      public EpoxyModel<?> next() {
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                         ^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#next().
//                              documentation ```java\npublic EpoxyModel<?> next()\n```
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
//                         documentation ```java\npublic int nextIndex()\n```
//                         relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
        return iterator.nextIndex() - start;
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ListIterator#nextIndex().
//                                    ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
      }

      public EpoxyModel<?> previous() {
//           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#previous().
//                                  documentation ```java\npublic EpoxyModel<?> previous()\n```
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
//                             documentation ```java\npublic int previousIndex()\n```
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#previousIndex().
        int previous = iterator.previousIndex();
//          ^^^^^^^^ definition local 47
//                   documentation ```java\nint previous\n```
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
//                       documentation ```java\npublic void remove()\n```
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
//                    documentation ```java\npublic void set(EpoxyModel<?> object)\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/util/ListIterator#set().
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^ definition local 48
//                                         documentation ```java\nEpoxyModel<?> object\n```
        iterator.set(object);
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//               ^^^ reference semanticdb maven jdk 11 java/util/ListIterator#set().
//                   ^^^^^^ reference local 48
      }
    }

    SubList(ModelList list, int start, int end) {
//  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#`<init>`().
//          documentation ```java\nSubList(ModelList list, int start, int end)\n```
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#
//                    ^^^^ definition local 49
//                         documentation ```java\nModelList list\n```
//                              ^^^^^ definition local 50
//                                    documentation ```java\nint start\n```
//                                         ^^^ definition local 51
//                                             documentation ```java\nint end\n```
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
//                  documentation ```java\n@Override\npublic void add(int location, EpoxyModel<?> object)\n```
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#add(+1).
//                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#add(+1).
//                      ^^^^^^^^ definition local 52
//                               documentation ```java\nint location\n```
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^ definition local 53
//                                                     documentation ```java\nEpoxyModel<?> object\n```
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
//                        documentation ```java\n@Override\npublic boolean addAll(int location, Collection<? extends EpoxyModel<?>> collection)\n```
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#addAll().
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll(+1).
//                            ^^^^^^^^ definition local 54
//                                     documentation ```java\nint location\n```
//                                      ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^^^^ definition local 55
//                                                                                     documentation ```java\nCollection<? extends EpoxyModel<?>> collection\n```
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
//                       documentation ```java\nboolean result\n```
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
//                        documentation ```java\n@Override\npublic boolean addAll(Collection<? extends EpoxyModel<?>> collection)\n```
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractCollection#addAll().
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/Collection#addAll().
//                        relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#addAll().
//                         ^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/NonNull#
//                                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/Collection#
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                                     ^^^^^^^^^^ definition local 57
//                                                                                documentation ```java\n@NonNull\nCollection<? extends EpoxyModel<?>> collection\n```
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference semanticdb maven jdk 11 java/util/AbstractList#modCount.
        boolean result = fullList.addAll(offset + size, collection);
//              ^^^^^^ definition local 58
//                     documentation ```java\nboolean result\n```
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
//                           documentation ```java\n@Override\npublic EpoxyModel<?> get(int location)\n```
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#get().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#get().
//                               ^^^^^^^^ definition local 59
//                                        documentation ```java\nint location\n```
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
//                                          documentation ```java\n@NonNull\n@Override\npublic Iterator<EpoxyModel<?>> iterator()\n```
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
//                                                  documentation ```java\n@NonNull\n@Override\npublic ListIterator<EpoxyModel<?>> listIterator(int location)\n```
//                                                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#listIterator(+1).
//                                                  relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#listIterator(+1).
//                                                      ^^^^^^^^ definition local 60
//                                                               documentation ```java\nint location\n```
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
//                              documentation ```java\n@Override\npublic EpoxyModel<?> remove(int location)\n```
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#remove().
//                              relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#remove(+1).
//                                  ^^^^^^^^ definition local 61
//                                           documentation ```java\nint location\n```
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
//                             documentation ```java\nEpoxyModel<?> result\n```
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
//                             documentation ```java\n@Override\nprotected void removeRange(int start, int end)\n```
//                             relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#removeRange().
//                                 ^^^^^ definition local 63
//                                       documentation ```java\nint start\n```
//                                            ^^^ definition local 64
//                                                documentation ```java\nint end\n```
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
//                           documentation ```java\n@Override\npublic EpoxyModel<?> set(int location, EpoxyModel<?> object)\n```
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/AbstractList#set().
//                           relationship is_reference is_implementation semanticdb maven jdk 11 java/util/List#set().
//                               ^^^^^^^^ definition local 65
//                                        documentation ```java\nint location\n```
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyModel#
//                                                       ^^^^^^ definition local 66
//                                                              documentation ```java\nEpoxyModel<?> object\n```
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
//                  documentation ```java\n@Override\npublic int size()\n```
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
//                   documentation ```java\nvoid sizeChanged(boolean increment)\n```
//                           ^^^^^^^^^ definition local 67
//                                     documentation ```java\nboolean increment\n```
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
