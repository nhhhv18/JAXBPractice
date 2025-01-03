package entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@EqualsAndHashCode
@ToString
public class CustomLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Map<Object, Object> stream() {
        return null;
    }

    // Node class to store the data
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
        }
    }

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add a new item to the linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Get the size of the linked list
    public int size() {
        return size;
    }

    // Iterator to loop over the linked list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }


    // Print the contents of the list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}