package com.airbnb.epoxy;

import java.util.AbstractList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^^ reference java/util/AbstractList#
import java.util.ArrayList;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.Collection;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^ reference java/util/Collection#
import java.util.ConcurrentModificationException;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
import java.util.Iterator;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^ reference java/util/Iterator#
import java.util.List;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^ reference java/util/List#
import java.util.ListIterator;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^^ reference java/util/ListIterator#
import java.util.NoSuchElementException;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#

import androidx.annotation.NonNull;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^ reference androidx/annotation/NonNull#

/**
 * Used by our {@link EpoxyAdapter} to track models. It simply wraps ArrayList and notifies an
 * observer when remove or insertion operations are done on the list. This allows us to optimize
 * diffing since we have a knowledge of what changed in the list.
 */
class ModelList extends ArrayList<EpoxyModel<?>> {
^^^^^^^^^ definition com/airbnb/epoxy/ModelList#
//                      ^^^^^^^^^ reference java/util/ArrayList#
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#

  ModelList(int expectedModelCount) {
  ^^^^^^ definition com/airbnb/epoxy/ModelList#`<init>`().
//              ^^^^^^^^^^^^^^^^^^ definition local0
    super(expectedModelCount);
//  ^^^^^ reference java/util/ArrayList#`<init>`().
//        ^^^^^^^^^^^^^^^^^^ reference local0
  }

  ModelList() {
  ^^^^^^ definition com/airbnb/epoxy/ModelList#`<init>`(+1).

  }

  interface ModelListObserver {
  ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#ModelListObserver#
    void onItemRangeInserted(int positionStart, int itemCount);
//       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                               ^^^^^^^^^^^^^ definition local1
//                                                  ^^^^^^^^^ definition local2
    void onItemRangeRemoved(int positionStart, int itemCount);
//       ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                              ^^^^^^^^^^^^^ definition local3
//                                                 ^^^^^^^^^ definition local4
  }

  private boolean notificationsPaused;
//                ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#notificationsPaused.
  private ModelListObserver observer;
//        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ModelListObserver#
//                          ^^^^^^^^ definition com/airbnb/epoxy/ModelList#observer.

  void pauseNotifications() {
//     ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#pauseNotifications().
    if (notificationsPaused) {
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notificationsPaused.
      throw new IllegalStateException("Notifications already paused");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }
    notificationsPaused = true;
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notificationsPaused.
  }

  void resumeNotifications() {
//     ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#resumeNotifications().
    if (!notificationsPaused) {
//       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notificationsPaused.
      throw new IllegalStateException("Notifications already resumed");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
    }
    notificationsPaused = false;
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notificationsPaused.
  }

  void setObserver(ModelListObserver observer) {
//     ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#setObserver().
//                 ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ModelListObserver#
//                                   ^^^^^^^^ definition local5
    this.observer = observer;
//  ^^^^ reference com/airbnb/epoxy/ModelList#this.
//       ^^^^^^^^ reference com/airbnb/epoxy/ModelList#observer.
//                  ^^^^^^^^ reference local5
  }

  private void notifyInsertion(int positionStart, int itemCount) {
//             ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#notifyInsertion().
//                                 ^^^^^^^^^^^^^ definition local6
//                                                    ^^^^^^^^^ definition local7
    if (!notificationsPaused && observer != null) {
//       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notificationsPaused.
//                              ^^^^^^^^ reference com/airbnb/epoxy/ModelList#observer.
      observer.onItemRangeInserted(positionStart, itemCount);
//    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#observer.
//             ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeInserted().
//                                 ^^^^^^^^^^^^^ reference local6
//                                                ^^^^^^^^^ reference local7
    }
  }

  private void notifyRemoval(int positionStart, int itemCount) {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#notifyRemoval().
//                               ^^^^^^^^^^^^^ definition local8
//                                                  ^^^^^^^^^ definition local9
    if (!notificationsPaused && observer != null) {
//       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notificationsPaused.
//                              ^^^^^^^^ reference com/airbnb/epoxy/ModelList#observer.
      observer.onItemRangeRemoved(positionStart, itemCount);
//    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#observer.
//             ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ModelListObserver#onItemRangeRemoved().
//                                ^^^^^^^^^^^^^ reference local8
//                                               ^^^^^^^^^ reference local9
    }
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public EpoxyModel<?> set(int index, EpoxyModel<?> element) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^ definition com/airbnb/epoxy/ModelList#set().
//                             ^^^^^ definition local10
//                                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                  ^^^^^^^ definition local11
    EpoxyModel<?> previousModel = super.set(index, element);
//  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                ^^^^^^^^^^^^^ definition local12
//                                ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//                                      ^^^ reference java/util/ArrayList#set().
//                                          ^^^^^ reference local10
//                                                 ^^^^^^^ reference local11

    if (previousModel.id() != element.id()) {
//      ^^^^^^^^^^^^^ reference local12
//                    ^^ reference com/airbnb/epoxy/EpoxyModel#id().
//                            ^^^^^^^ reference local11
//                                    ^^ reference com/airbnb/epoxy/EpoxyModel#id().
      notifyRemoval(index, 1);
//    ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyRemoval().
//                  ^^^^^ reference local10
      notifyInsertion(index, 1);
//    ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyInsertion().
//                    ^^^^^ reference local10
    }

    return previousModel;
//         ^^^^^^^^^^^^^ reference local12
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean add(EpoxyModel<?> epoxyModel) {
//               ^^^ definition com/airbnb/epoxy/ModelList#add().
//                   ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^^^^^^ definition local13
    notifyInsertion(size(), 1);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^ reference java/util/ArrayList#size().
    return super.add(epoxyModel);
//         ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//               ^^^ reference java/util/ArrayList#add(+1).
//                   ^^^^^^^^^^ reference local13
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void add(int index, EpoxyModel<?> element) {
//            ^^^ definition com/airbnb/epoxy/ModelList#add(+1).
//                    ^^^^^ definition local14
//                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                         ^^^^^^^ definition local15
    notifyInsertion(index, 1);
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^^ reference local14
    super.add(index, element);
//  ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//        ^^^ reference java/util/ArrayList#add(+2).
//            ^^^^^ reference local14
//                   ^^^^^^^ reference local15
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean addAll(Collection<? extends EpoxyModel<?>> c) {
//               ^^^^^^ definition com/airbnb/epoxy/ModelList#addAll().
//                      ^^^^^^^^^^ reference java/util/Collection#
//                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                          ^ definition local16
    notifyInsertion(size(), c.size());
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^ reference java/util/ArrayList#size().
//                          ^ reference local16
//                            ^^^^ reference java/util/Collection#size().
    return super.addAll(c);
//         ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//               ^^^^^^ reference java/util/ArrayList#addAll().
//                      ^ reference local16
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean addAll(int index, Collection<? extends EpoxyModel<?>> c) {
//               ^^^^^^ definition com/airbnb/epoxy/ModelList#addAll(+1).
//                          ^^^^^ definition local17
//                                 ^^^^^^^^^^ reference java/util/Collection#
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                     ^ definition local18
    notifyInsertion(index, c.size());
//  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyInsertion().
//                  ^^^^^ reference local17
//                         ^ reference local18
//                           ^^^^ reference java/util/Collection#size().
    return super.addAll(index, c);
//         ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//               ^^^^^^ reference java/util/ArrayList#addAll(+1).
//                      ^^^^^ reference local17
//                             ^ reference local18
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public EpoxyModel<?> remove(int index) {
//       ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                     ^^^^^^ definition com/airbnb/epoxy/ModelList#remove().
//                                ^^^^^ definition local19
    notifyRemoval(index, 1);
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyRemoval().
//                ^^^^^ reference local19
    return super.remove(index);
//         ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//               ^^^^^^ reference java/util/ArrayList#remove().
//                      ^^^^^ reference local19
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean remove(Object o) {
//               ^^^^^^ definition com/airbnb/epoxy/ModelList#remove(+1).
//                      ^^^^^^ reference java/lang/Object#
//                             ^ definition local20
    int index = indexOf(o);
//      ^^^^^ definition local21
//              ^^^^^^^ reference java/util/ArrayList#indexOf().
//                      ^ reference local20

    if (index == -1) {
//      ^^^^^ reference local21
      return false;
    }

    notifyRemoval(index, 1);
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyRemoval().
//                ^^^^^ reference local21
    super.remove(index);
//  ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//        ^^^^^^ reference java/util/ArrayList#remove().
//               ^^^^^ reference local21
    return true;
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public void clear() {
//            ^^^^^ definition com/airbnb/epoxy/ModelList#clear().
    if (!isEmpty()) {
//       ^^^^^^^ reference java/util/ArrayList#isEmpty().
      notifyRemoval(0, size());
//    ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyRemoval().
//                     ^^^^ reference java/util/ArrayList#size().
      super.clear();
//    ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//          ^^^^^ reference java/util/ArrayList#clear().
    }
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  protected void removeRange(int fromIndex, int toIndex) {
//               ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#removeRange().
//                               ^^^^^^^^^ definition local22
//                                              ^^^^^^^ definition local23
    if (fromIndex == toIndex) {
//      ^^^^^^^^^ reference local22
//                   ^^^^^^^ reference local23
      return;
    }

    notifyRemoval(fromIndex, toIndex - fromIndex);
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#notifyRemoval().
//                ^^^^^^^^^ reference local22
//                           ^^^^^^^ reference local23
//                                     ^^^^^^^^^ reference local22
    super.removeRange(fromIndex, toIndex);
//  ^^^^^ reference com/airbnb/epoxy/ModelList#super.
//        ^^^^^^^^^^^ reference java/util/ArrayList#removeRange().
//                    ^^^^^^^^^ reference local22
//                               ^^^^^^^ reference local23
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean removeAll(Collection<?> collection) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/ModelList#removeAll().
//                         ^^^^^^^^^^ reference java/util/Collection#
//                                       ^^^^^^^^^^ definition local24
    // Using this implementation from the Android ArrayList since the Java 1.8 ArrayList
    // doesn't call through to remove. Calling through to remove lets us leverage the notification
    // done there
    boolean result = false;
//          ^^^^^^ definition local25
    Iterator<?> it = iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//              ^^ definition local26
//                   ^^^^^^^^ reference com/airbnb/epoxy/ModelList#iterator().
    while (it.hasNext()) {
//         ^^ reference local26
//            ^^^^^^^ reference java/util/Iterator#hasNext().
      if (collection.contains(it.next())) {
//        ^^^^^^^^^^ reference local24
//                   ^^^^^^^^ reference java/util/Collection#contains().
//                            ^^ reference local26
//                               ^^^^ reference java/util/Iterator#next().
        it.remove();
//      ^^ reference local26
//         ^^^^^^ reference java/util/Iterator#remove().
        result = true;
//      ^^^^^^ reference local25
      }
    }
    return result;
//         ^^^^^^ reference local25
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean retainAll(Collection<?> collection) {
//               ^^^^^^^^^ definition com/airbnb/epoxy/ModelList#retainAll().
//                         ^^^^^^^^^^ reference java/util/Collection#
//                                       ^^^^^^^^^^ definition local27
    // Using this implementation from the Android ArrayList since the Java 1.8 ArrayList
    // doesn't call through to remove. Calling through to remove lets us leverage the notification
    // done there
    boolean result = false;
//          ^^^^^^ definition local28
    Iterator<?> it = iterator();
//  ^^^^^^^^ reference java/util/Iterator#
//              ^^ definition local29
//                   ^^^^^^^^ reference com/airbnb/epoxy/ModelList#iterator().
    while (it.hasNext()) {
//         ^^ reference local29
//            ^^^^^^^ reference java/util/Iterator#hasNext().
      if (!collection.contains(it.next())) {
//         ^^^^^^^^^^ reference local27
//                    ^^^^^^^^ reference java/util/Collection#contains().
//                             ^^ reference local29
//                                ^^^^ reference java/util/Iterator#next().
        it.remove();
//      ^^ reference local29
//         ^^^^^^ reference java/util/Iterator#remove().
        result = true;
//      ^^^^^^ reference local28
      }
    }
    return result;
//         ^^^^^^ reference local28
  }

  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public Iterator<EpoxyModel<?>> iterator() {
//       ^^^^^^^^ reference java/util/Iterator#
//                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                               ^^^^^^^^ definition com/airbnb/epoxy/ModelList#iterator().
    return new Itr();
//         ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#`<init>`().
//             ^^^ reference com/airbnb/epoxy/ModelList#Itr#
  }

  /**
   * An Iterator implementation that calls through to the parent list's methods for modification.
   * Some implementations, like the Android ArrayList.ArrayListIterator class, modify the list data
   * directly instead of calling into the parent list's methods. We need the implementation to call
   * the parent methods so that the proper notifications are done.
   */
  private class Itr implements Iterator<EpoxyModel<?>> {
//        ^^^ definition com/airbnb/epoxy/ModelList#Itr#
//        ^^^^^^ definition com/airbnb/epoxy/ModelList#Itr#`<init>`().
//                             ^^^^^^^^ reference java/util/Iterator#
//                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
    int cursor;       // index of next element to return
//      ^^^^^^ definition com/airbnb/epoxy/ModelList#Itr#cursor.
    int lastRet = -1; // index of last element returned; -1 if no such
//      ^^^^^^^ definition com/airbnb/epoxy/ModelList#Itr#lastRet.
    int expectedModCount = modCount;
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#Itr#expectedModCount.
//                         ^^^^^^^^ reference java/util/AbstractList#modCount.

    public boolean hasNext() {
//                 ^^^^^^^ definition com/airbnb/epoxy/ModelList#Itr#hasNext().
      return cursor != size();
//           ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
//                     ^^^^ reference java/util/ArrayList#size().
    }

    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
    public EpoxyModel<?> next() {
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                       ^^^^ definition com/airbnb/epoxy/ModelList#Itr#next().
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#checkForComodification().
      int i = cursor;
//        ^ definition local30
//            ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
      cursor = i + 1;
//    ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
//             ^ reference local30
      lastRet = i;
//    ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
//              ^ reference local30
      return ModelList.this.get(i);
//           ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//                     ^^^^ reference com/airbnb/epoxy/ModelList#this.
//                          ^^^ reference java/util/ArrayList#get().
//                              ^ reference local30
    }

    public void remove() {
//              ^^^^^^ definition com/airbnb/epoxy/ModelList#Itr#remove().
      if (lastRet < 0) {
//        ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
        throw new IllegalStateException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
      }
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#checkForComodification().

      try {
        ModelList.this.remove(lastRet);
//      ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//                ^^^^ reference com/airbnb/epoxy/ModelList#this.
//                     ^^^^^^ reference com/airbnb/epoxy/ModelList#remove().
//                            ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
        cursor = lastRet;
//      ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
//               ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
        lastRet = -1;
//      ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
        expectedModCount = modCount;
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#expectedModCount.
//                         ^^^^^^^^ reference java/util/AbstractList#modCount.
      } catch (IndexOutOfBoundsException ex) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
//                                       ^^ definition local31
        throw new ConcurrentModificationException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
      }
    }

    final void checkForComodification() {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#Itr#checkForComodification().
      if (modCount != expectedModCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#expectedModCount.
        throw new ConcurrentModificationException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
      }
    }
  }

  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public ListIterator<EpoxyModel<?>> listIterator() {
//       ^^^^^^^^^^^^ reference java/util/ListIterator#
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#listIterator().
    return new ListItr(0);
//         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ListItr#`<init>`().
//             ^^^^^^^ reference com/airbnb/epoxy/ModelList#ListItr#
  }

  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public ListIterator<EpoxyModel<?>> listIterator(int index) {
//       ^^^^^^^^^^^^ reference java/util/ListIterator#
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                   ^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#listIterator(+1).
//                                                    ^^^^^ definition local32
    return new ListItr(index);
//         ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#ListItr#`<init>`().
//             ^^^^^^^ reference com/airbnb/epoxy/ModelList#ListItr#
//                     ^^^^^ reference local32
  }

  /**
   * A ListIterator implementation that calls through to the parent list's methods for modification.
   * Some implementations may modify the list data directly instead of calling into the parent
   * list's methods. We need the implementation to call the parent methods so that the proper
   * notifications are done.
   */
  private class ListItr extends Itr implements ListIterator<EpoxyModel<?>> {
//        ^^^^^^^ definition com/airbnb/epoxy/ModelList#ListItr#
//                              ^^^ reference com/airbnb/epoxy/ModelList#Itr#
//                                             ^^^^^^^^^^^^ reference java/util/ListIterator#
//                                                          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
    ListItr(int index) {
//  ^^^^^^ definition com/airbnb/epoxy/ModelList#ListItr#`<init>`().
//              ^^^^^ definition local33
      cursor = index;
//    ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
//             ^^^^^ reference local33
    }

    public boolean hasPrevious() {
//                 ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#ListItr#hasPrevious().
      return cursor != 0;
//           ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    public int nextIndex() {
//             ^^^^^^^^^ definition com/airbnb/epoxy/ModelList#ListItr#nextIndex().
      return cursor;
//           ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    public int previousIndex() {
//             ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#ListItr#previousIndex().
      return cursor - 1;
//           ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
    }

    @SuppressWarnings("unchecked")
//   ^^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
    public EpoxyModel<?> previous() {
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^^^^ definition com/airbnb/epoxy/ModelList#ListItr#previous().
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#checkForComodification().
      int i = cursor - 1;
//        ^ definition local34
//            ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
      if (i < 0) {
//        ^ reference local34
        throw new NoSuchElementException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#
      }

      cursor = i;
//    ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
//             ^ reference local34
      lastRet = i;
//    ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
//              ^ reference local34
      return ModelList.this.get(i);
//           ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//                     ^^^^ reference com/airbnb/epoxy/ModelList#this.
//                          ^^^ reference java/util/ArrayList#get().
//                              ^ reference local34
    }

    public void set(EpoxyModel<?> e) {
//              ^^^ definition com/airbnb/epoxy/ModelList#ListItr#set().
//                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                ^ definition local35
      if (lastRet < 0) {
//        ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
        throw new IllegalStateException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalStateException#
      }
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#checkForComodification().

      try {
        ModelList.this.set(lastRet, e);
//      ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//                ^^^^ reference com/airbnb/epoxy/ModelList#this.
//                     ^^^ reference com/airbnb/epoxy/ModelList#set().
//                         ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
//                                  ^ reference local35
      } catch (IndexOutOfBoundsException ex) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
//                                       ^^ definition local36
        throw new ConcurrentModificationException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
      }
    }

    public void add(EpoxyModel<?> e) {
//              ^^^ definition com/airbnb/epoxy/ModelList#ListItr#add().
//                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                ^ definition local37
      checkForComodification();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#checkForComodification().

      try {
        int i = cursor;
//          ^ definition local38
//              ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
        ModelList.this.add(i, e);
//      ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//                ^^^^ reference com/airbnb/epoxy/ModelList#this.
//                     ^^^ reference com/airbnb/epoxy/ModelList#add(+1).
//                         ^ reference local38
//                            ^ reference local37
        cursor = i + 1;
//      ^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#cursor.
//               ^ reference local38
        lastRet = -1;
//      ^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#lastRet.
        expectedModCount = modCount;
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#Itr#expectedModCount.
//                         ^^^^^^^^ reference java/util/AbstractList#modCount.
      } catch (IndexOutOfBoundsException ex) {
//             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
//                                       ^^ definition local39
        throw new ConcurrentModificationException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
      }
    }
  }

  @NonNull
   ^^^^^^^ reference androidx/annotation/NonNull#
  @Override
   ^^^^^^^^ reference java/lang/Override#
  public List<EpoxyModel<?>> subList(int start, int end) {
//       ^^^^ reference java/util/List#
//            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                           ^^^^^^^ definition com/airbnb/epoxy/ModelList#subList().
//                                       ^^^^^ definition local40
//                                                  ^^^ definition local41
    if (start >= 0 && end <= size()) {
//      ^^^^^ reference local40
//                    ^^^ reference local41
//                           ^^^^ reference java/util/ArrayList#size().
      if (start <= end) {
//        ^^^^^ reference local40
//                 ^^^ reference local41
        return new SubList(this, start, end);
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#`<init>`().
//                 ^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#
//                         ^^^^ reference com/airbnb/epoxy/ModelList#this.
//                               ^^^^^ reference local40
//                                      ^^^ reference local41
      }
      throw new IllegalArgumentException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#
    }
    throw new IndexOutOfBoundsException();
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#`<init>`().
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
  }

  /**
   * A SubList implementation from Android's AbstractList class. It's copied here to make sure the
   * implementation doesn't change, since some implementations, like the Java 1.8 ArrayList.SubList
   * class, modify the list data directly instead of calling into the parent list's methods. We need
   * the implementation to call the parent methods so that the proper notifications are done.
   */
  private static class SubList extends AbstractList<EpoxyModel<?>> {
//               ^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#
//                                     ^^^^^^^^^^^^ reference java/util/AbstractList#
//                                                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
    private final ModelList fullList;
//                ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//                          ^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#fullList.
    private int offset;
//              ^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#offset.
    private int size;
//              ^^^^ definition com/airbnb/epoxy/ModelList#SubList#size.

    private static final class SubListIterator implements ListIterator<EpoxyModel<?>> {
//                       ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#
//                                                        ^^^^^^^^^^^^ reference java/util/ListIterator#
//                                                                     ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
      private final SubList subList;
//                  ^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#
//                          ^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
      private final ListIterator<EpoxyModel<?>> iterator;
//                  ^^^^^^^^^^^^ reference java/util/ListIterator#
//                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
      private int start;
//                ^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
      private int end;
//                ^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.

      SubListIterator(ListIterator<EpoxyModel<?>> it, SubList list, int offset, int length) {
//    ^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                    ^^^^^^^^^^^^ reference java/util/ListIterator#
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                ^^ definition local42
//                                                    ^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#
//                                                            ^^^^ definition local43
//                                                                      ^^^^^^ definition local44
//                                                                                  ^^^^^^ definition local45
        iterator = it;
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                 ^^ reference local42
        subList = list;
//      ^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//                ^^^^ reference local43
        start = offset;
//      ^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
//              ^^^^^^ reference local44
        end = start + length;
//      ^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
//            ^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
//                    ^^^^^^ reference local45
      }

      public void add(EpoxyModel<?> object) {
//                ^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#add().
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^ definition local46
        iterator.add(object);
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//               ^^^ reference java/util/ListIterator#add().
//                   ^^^^^^ reference local46
        subList.sizeChanged(true);
//      ^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#sizeChanged().
        end++;
//      ^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
      }

      public boolean hasNext() {
//                   ^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#hasNext().
        return iterator.nextIndex() < end;
//             ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^ reference java/util/ListIterator#nextIndex().
//                                    ^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
      }

      public boolean hasPrevious() {
//                   ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#hasPrevious().
        return iterator.previousIndex() >= start;
//             ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^^^^^ reference java/util/ListIterator#previousIndex().
//                                         ^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
      }

      public EpoxyModel<?> next() {
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                         ^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#next().
        if (iterator.nextIndex() < end) {
//          ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                   ^^^^^^^^^ reference java/util/ListIterator#nextIndex().
//                                 ^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
          return iterator.next();
//               ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                        ^^^^ reference java/util/ListIterator#next().
        }
        throw new NoSuchElementException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#
      }

      public int nextIndex() {
//               ^^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#nextIndex().
        return iterator.nextIndex() - start;
//             ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                      ^^^^^^^^^ reference java/util/ListIterator#nextIndex().
//                                    ^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
      }

      public EpoxyModel<?> previous() {
//           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                         ^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#previous().
        if (iterator.previousIndex() >= start) {
//          ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                   ^^^^^^^^^^^^^ reference java/util/ListIterator#previousIndex().
//                                      ^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
          return iterator.previous();
//               ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                        ^^^^^^^^ reference java/util/ListIterator#previous().
        }
        throw new NoSuchElementException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^ reference java/util/NoSuchElementException#
      }

      public int previousIndex() {
//               ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#previousIndex().
        int previous = iterator.previousIndex();
//          ^^^^^^^^ definition local47
//                     ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//                              ^^^^^^^^^^^^^ reference java/util/ListIterator#previousIndex().
        if (previous >= start) {
//          ^^^^^^^^ reference local47
//                      ^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
          return previous - start;
//               ^^^^^^^^ reference local47
//                          ^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#start.
        }
        return -1;
      }

      public void remove() {
//                ^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#remove().
        iterator.remove();
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//               ^^^^^^ reference java/util/ListIterator#remove().
        subList.sizeChanged(false);
//      ^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#subList.
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#sizeChanged().
        end--;
//      ^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#end.
      }

      public void set(EpoxyModel<?> object) {
//                ^^^ definition com/airbnb/epoxy/ModelList#SubList#SubListIterator#set().
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                  ^^^^^^ definition local48
        iterator.set(object);
//      ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#iterator.
//               ^^^ reference java/util/ListIterator#set().
//                   ^^^^^^ reference local48
      }
    }

    SubList(ModelList list, int start, int end) {
//  ^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#`<init>`().
//          ^^^^^^^^^ reference com/airbnb/epoxy/ModelList#
//                    ^^^^ definition local49
//                              ^^^^^ definition local50
//                                         ^^^ definition local51
      fullList = list;
//    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//               ^^^^ reference local49
      modCount = fullList.modCount;
//    ^^^^^^^^ reference java/util/AbstractList#modCount.
//               ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^^^^^^ reference java/util/AbstractList#modCount.
      offset = start;
//    ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//             ^^^^^ reference local50
      size = end - start;
//    ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
//           ^^^ reference local51
//                 ^^^^^ reference local50
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public void add(int location, EpoxyModel<?> object) {
//              ^^^ definition com/airbnb/epoxy/ModelList#SubList#add().
//                      ^^^^^^^^ definition local52
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                              ^^^^^^ definition local53
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        if (location >= 0 && location <= size) {
//          ^^^^^^^^ reference local52
//                           ^^^^^^^^ reference local52
//                                       ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          fullList.add(location + offset, object);
//        ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                 ^^^ reference com/airbnb/epoxy/ModelList#add(+1).
//                     ^^^^^^^^ reference local52
//                                ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//                                        ^^^^^^ reference local53
          size++;
//        ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          modCount = fullList.modCount;
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference java/util/AbstractList#modCount.
        } else {
          throw new IndexOutOfBoundsException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#`<init>`().
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
        }
      } else {
        throw new ConcurrentModificationException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
      }
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public boolean addAll(int location, Collection<? extends EpoxyModel<?>> collection) {
//                 ^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#addAll().
//                            ^^^^^^^^ definition local54
//                                      ^^^^^^^^^^ reference java/util/Collection#
//                                                           ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                          ^^^^^^^^^^ definition local55
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        if (location >= 0 && location <= size) {
//          ^^^^^^^^ reference local54
//                           ^^^^^^^^ reference local54
//                                       ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          boolean result = fullList.addAll(location + offset, collection);
//                ^^^^^^ definition local56
//                         ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                                  ^^^^^^ reference com/airbnb/epoxy/ModelList#addAll(+1).
//                                         ^^^^^^^^ reference local54
//                                                    ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//                                                            ^^^^^^^^^^ reference local55
          if (result) {
//            ^^^^^^ reference local56
            size += collection.size();
//          ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
//                  ^^^^^^^^^^ reference local55
//                             ^^^^ reference java/util/Collection#size().
            modCount = fullList.modCount;
//          ^^^^^^^^ reference java/util/AbstractList#modCount.
//                     ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                              ^^^^^^^^ reference java/util/AbstractList#modCount.
          }
          return result;
//               ^^^^^^ reference local56
        }
        throw new IndexOutOfBoundsException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
      }
      throw new ConcurrentModificationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public boolean addAll(@NonNull Collection<? extends EpoxyModel<?>> collection) {
//                 ^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#addAll(+1).
//                         ^^^^^^^ reference androidx/annotation/NonNull#
//                                 ^^^^^^^^^^ reference java/util/Collection#
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                                     ^^^^^^^^^^ definition local57
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        boolean result = fullList.addAll(offset + size, collection);
//              ^^^^^^ definition local58
//                       ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                                ^^^^^^ reference com/airbnb/epoxy/ModelList#addAll(+1).
//                                       ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//                                                ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
//                                                      ^^^^^^^^^^ reference local57
        if (result) {
//          ^^^^^^ reference local58
          size += collection.size();
//        ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
//                ^^^^^^^^^^ reference local57
//                           ^^^^ reference java/util/Collection#size().
          modCount = fullList.modCount;
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference java/util/AbstractList#modCount.
        }
        return result;
//             ^^^^^^ reference local58
      }
      throw new ConcurrentModificationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public EpoxyModel<?> get(int location) {
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                       ^^^ definition com/airbnb/epoxy/ModelList#SubList#get().
//                               ^^^^^^^^ definition local59
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        if (location >= 0 && location < size) {
//          ^^^^^^^^ reference local59
//                           ^^^^^^^^ reference local59
//                                      ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          return fullList.get(location + offset);
//               ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^ reference java/util/ArrayList#get().
//                            ^^^^^^^^ reference local59
//                                       ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
        }
        throw new IndexOutOfBoundsException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
      }
      throw new ConcurrentModificationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
    }

    @NonNull
//   ^^^^^^^ reference androidx/annotation/NonNull#
    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public Iterator<EpoxyModel<?>> iterator() {
//         ^^^^^^^^ reference java/util/Iterator#
//                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                 ^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#iterator().
      return listIterator(0);
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#listIterator().
    }

    @NonNull
//   ^^^^^^^ reference androidx/annotation/NonNull#
    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public ListIterator<EpoxyModel<?>> listIterator(int location) {
//         ^^^^^^^^^^^^ reference java/util/ListIterator#
//                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                     ^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#listIterator().
//                                                      ^^^^^^^^ definition local60
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        if (location >= 0 && location <= size) {
//          ^^^^^^^^ reference local60
//                           ^^^^^^^^ reference local60
//                                       ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          return new SubListIterator(fullList.listIterator(location + offset), this, offset, size);
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#`<init>`().
//                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#SubListIterator#
//                                   ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#listIterator(+1).
//                                                         ^^^^^^^^ reference local60
//                                                                    ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//                                                                             ^^^^ reference com/airbnb/epoxy/ModelList#SubList#this.
//                                                                                   ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//                                                                                           ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
        }
        throw new IndexOutOfBoundsException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
      }
      throw new ConcurrentModificationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public EpoxyModel<?> remove(int location) {
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                       ^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#remove().
//                                  ^^^^^^^^ definition local61
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        if (location >= 0 && location < size) {
//          ^^^^^^^^ reference local61
//                           ^^^^^^^^ reference local61
//                                      ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          EpoxyModel<?> result = fullList.remove(location + offset);
//        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                      ^^^^^^ definition local62
//                               ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                                        ^^^^^^ reference com/airbnb/epoxy/ModelList#remove().
//                                               ^^^^^^^^ reference local61
//                                                          ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
          size--;
//        ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          modCount = fullList.modCount;
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference java/util/AbstractList#modCount.
          return result;
//               ^^^^^^ reference local62
        }
        throw new IndexOutOfBoundsException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
      }
      throw new ConcurrentModificationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    protected void removeRange(int start, int end) {
//                 ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#removeRange().
//                                 ^^^^^ definition local63
//                                            ^^^ definition local64
      if (start != end) {
//        ^^^^^ reference local63
//                 ^^^ reference local64
        if (modCount == fullList.modCount) {
//          ^^^^^^^^ reference java/util/AbstractList#modCount.
//                      ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                               ^^^^^^^^ reference java/util/AbstractList#modCount.
          fullList.removeRange(start + offset, end + offset);
//        ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                 ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelList#removeRange().
//                             ^^^^^ reference local63
//                                     ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//                                             ^^^ reference local64
//                                                   ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
          size -= end - start;
//        ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
//                ^^^ reference local64
//                      ^^^^^ reference local63
          modCount = fullList.modCount;
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                   ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                            ^^^^^^^^ reference java/util/AbstractList#modCount.
        } else {
          throw new ConcurrentModificationException();
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
        }
      }
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public EpoxyModel<?> set(int location, EpoxyModel<?> object) {
//         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                       ^^^ definition com/airbnb/epoxy/ModelList#SubList#set().
//                               ^^^^^^^^ definition local65
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyModel#
//                                                       ^^^^^^ definition local66
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        if (location >= 0 && location < size) {
//          ^^^^^^^^ reference local65
//                           ^^^^^^^^ reference local65
//                                      ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
          return fullList.set(location + offset, object);
//               ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^ reference com/airbnb/epoxy/ModelList#set().
//                            ^^^^^^^^ reference local65
//                                       ^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#offset.
//                                               ^^^^^^ reference local66
        }
        throw new IndexOutOfBoundsException();
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#`<init>`().
//                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IndexOutOfBoundsException#
      }
      throw new ConcurrentModificationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
    }

    @Override
//   ^^^^^^^^ reference java/lang/Override#
    public int size() {
//             ^^^^ definition com/airbnb/epoxy/ModelList#SubList#size().
      if (modCount == fullList.modCount) {
//        ^^^^^^^^ reference java/util/AbstractList#modCount.
//                    ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                             ^^^^^^^^ reference java/util/AbstractList#modCount.
        return size;
//             ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
      }
      throw new ConcurrentModificationException();
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#`<init>`().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/util/ConcurrentModificationException#
    }

    void sizeChanged(boolean increment) {
//       ^^^^^^^^^^^ definition com/airbnb/epoxy/ModelList#SubList#sizeChanged().
//                           ^^^^^^^^^ definition local67
      if (increment) {
//        ^^^^^^^^^ reference local67
        size++;
//      ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
      } else {
        size--;
//      ^^^^ reference com/airbnb/epoxy/ModelList#SubList#size.
      }
      modCount = fullList.modCount;
//    ^^^^^^^^ reference java/util/AbstractList#modCount.
//               ^^^^^^^^ reference com/airbnb/epoxy/ModelList#SubList#fullList.
//                        ^^^^^^^^ reference java/util/AbstractList#modCount.
    }
  }
}
