package com.revature;

import java.util.Iterator;

public class CustomLinkedList<E> implements CustomList<E> {
    Node<E> head;
    //Node<E> tail; - only necessary for doubly-linked-list



    @Override
    public void add(E e) {
        //implement this method
        //When we add an element to the list, we need to traverse the current list until we get to the end,
        //and then we need to set the next ref on the final node to point to the new final node.
    }

    //This one is optional as we removed it from the interface
    public E add(int index, E e) {
        //this one is optional
        return null;
    }

    @Override
    public E get(int index) {
        //implement this method
        //you traverse the linked list until you reach the Nth (index) node, and return that.
        return null;
    }



    @Override
    public void remove(int index) {
        //implement this method
        //traverse list to the specified index
        //if we are removing the front or back end of the list all we need to do is update the references to not point
        //to the now missing node. If the node is in the middle, you have to "splice" by adjusting the references
        //on either side of the removed node

    }

    @Override
    public void remove(E e) {
        //implement this method
        //traverse list looking for a matching object.
        //if we are removing the front or back end of the list all we need to do is update the references to not point
        //to the now missing node. If the node is in the middle, you have to "splice" by adjusting the references
        //on either side of the removed node
        Node<E> cursor = head;
        Node<E> prev = null;
        while(cursor != null) {
            if(cursor.obj.equals(e)) {
                //we found the node holding the object in question, and now we need to remove.
                //For a singly-linked list: either we are at the head, or we are not.
                if (cursor == head) {
                    //we're still at the head, let's lop it off.
                    head = cursor.next;
                    break;
                } else {
                    //splice out the node
                    prev.next = cursor.next;
                    break;
                }

            }
            prev = cursor;
            cursor = cursor.next;
        }

    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                //implement this method
                return false;
            }

            @Override
            public E next() {
                //implement this method
                return null;
            }
        };
    }

    private class Node<E> {
        //Node represents a "payload" which is a reference to an object we want the list to store.
        //Nodes also have references to other nodes, and this is how we make the linked list.
        //A linked list is made up of a chain of linked nodes in this way.

        E obj;
        Node<E> next;
        //Node<E> prev; - only necessary for doubly-linked-list


    }

}