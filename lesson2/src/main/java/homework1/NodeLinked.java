package homework1;

import java.util.Iterator;

public class NodeLinked<E> implements MyLinkedList<E>, Iterable<E>, DescendingIterator<E> {

    private Node<E> firstNode; // первая ячейка
    private Node<E> lastNode;  // последняя ячейка
    private int size = 0;   // начальный размер

    public NodeLinked() {
        lastNode = new Node<E>(null, firstNode, null);
        firstNode = new Node<E>(null, null, lastNode);
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = lastNode;
        prev.setCurrentElement(e);
        lastNode = new Node<E>(null, prev, null);
        prev.setNextElement(lastNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = firstNode;
        next.setCurrentElement(e);
        firstNode = new Node<>(null, null, next);
        next.setPrevElement(firstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> target = firstNode.getNextElement();
        for (int i = 0; i < counter; i++){
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current){
        return current.getNextElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter < size;
            }
            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size - 1;
            @Override
            public boolean hasNext() {
                return counter >= 0;
            }
            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    private class Node<E>{
        private E CurrentElement;
        private Node<E> nextElement;
        private Node<E> prevElement;

        private Node(E CurrentElement, Node<E> prevElement, Node<E> nextElement) {
            this.CurrentElement = CurrentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return CurrentElement;
        }

        public void setCurrentElement(E currentElement) {
            CurrentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }
}
