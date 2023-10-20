import java.util.Iterator;

public class Main {
      public static void main(String[] args) {
            SingleLinkedList<Contact> contacts = new SingleLinkedList<>();
            contacts.addToEnd(new Contact(1,"One"));
            contacts.addToEnd(new Contact(2,"Two"));
            contacts.addToEnd(new Contact(3,"Three"));
            contacts.addToEnd(new Contact(4,"Four"));
            contacts.addToEnd(new Contact(5,"Five"));
            System.out.println("Before");
            for (Contact contact : contacts) {
                  System.out.println(contact);
            }

            contacts.reverse();
            System.out.println("After");
            for (Contact contact : contacts) {
                  System.out.println(contact);
            }
      }

      static class SingleLinkedList<T> implements Iterable<T> {

            Node<T> firstNode;
            Node<T> lastNode;

            private static class Node<T> {
                  T data;
                  Node<T> next;
            }

            @Override
            public Iterator<T> iterator() {
                  return new Iterator<T>() {
                         Node<T> current = firstNode;
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

            public void addToEnd(T item) {
                  Node<T> newItem = new Node<>();
                  newItem.data = item;
                  if (isEmpty()) {
                        firstNode = newItem;
                        lastNode = newItem;
                  } else {
                        lastNode.next = newItem;
                        lastNode = newItem;
                  }
            }

            //check if it is on the list by link to first item
            public boolean isEmpty() {
                  return firstNode == null;
            }

            public void reverse() {
                  //check if we have more than one element in list
                  if (!isEmpty() && firstNode.next != null) {
                        lastNode = firstNode;
                        Node<T> current = firstNode.next;
                        firstNode.next = null;
                        while (current != null) {
                              Node<T> next = current.next;
                              current.next = firstNode;
                              firstNode = current;
                              current = next;
                        }
                  }
            }

      }

      static class Contact {
            int id;
            String name;

            public Contact(int id, String name) {
                  this.id = id;
                  this.name = name;
            }

            @Override
            public String toString() {
                  return "Contact{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
            }
      }
}

