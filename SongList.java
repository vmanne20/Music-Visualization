/**
 * 
 */
package prj5;

import java.util.AbstractList;

//import java.util.Iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

//import java.util.NoSuchElementException;




/**
 * @author vmanne20, jason199, zjames1
 * @version 11/14
 *
 * @param <E> - generic types can be held in the list
 */
public class SongList<E> extends AbstractList<E>  {

    
    private int size;
    private Node<E> head;
    /**
     * calls clear() to reset fields such as size
     * to 0 and head to null.
     */
    public SongList()
    {
        clear();
    }
    
    public Iterator<E> iterator()
    {
        return new SongListIterator();
    }
    
    /**
     * returns number of entries in list
     * 
     * @return int - size
     */
    public int size()
    {
        return size;
    }
    
    /*public Iterator<E> iterator()
    {
        return new SongListIterator();
    }*/
    
    /**
     * Returns the element at the specified index
     * in the list. 
     * 
     * @return E - element at index
     * @throws IndexOutOfBoundsException if index
     * is out of range
     */
    @Override
    public E get(int index) 
    {
        E value = null;
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node<E> currNode = head;
            int pos = 0;
            while (pos <= index)
            {
                if (pos == index)
                {
                    value = currNode.getData();
                }
                pos++;
                currNode = currNode.next();
            }
        }
        return value;
    }
    
    /**
     * appends the specified element to the end of this list 
     * increases size after
     * @param entry - entry to be added
     * @throws IllegalArgumentException if entry to add is null
     * @return true if addition was successful
     */
    public boolean add(E entry)
    {
        if (entry == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            Node<E> newNode = new Node<E>(entry);
            Node<E> currNode = head;
            if (isEmpty())
            {
                head = newNode;
            }
            
            
            
            else
            {
                while (currNode.next() != null)
                {
                    currNode = currNode.next();
                }
                currNode.setNext(newNode);
            }

        }
        size++;
        return true;
    }
    
    /**
     * sorts the SongList by title, calls
     * the insertInOrderByTitle() and 
     * compareByTitle() methods. Insertion 
     * sort is performed on the list.
     */
    public void sortByTitle()
    {
        if (size > 1)
        {
            //assert head != null;
            
            Node<E> unsortedPart = head.next();
            //assert unsortedPart != null;
            head.setNext(null);
            while (unsortedPart != null)
            {
                Node<E> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertInOrderByTitle(nodeToInsert);
            }
        }
    }
    
     /**
      * helper method to insert nodes in order
      * 
      * @param nodeToInsert - the node that is part 
      * of unsorted part, needs to placed in sorted part
      * of list
      */
    private void insertInOrderByTitle(Node<E> nodeToInsert)
    {
        E item = nodeToInsert.getData();
        Node<E> currNode = head;
        Node<E> prevNode = null;
        
        while ((currNode != null) && 
                (compareByTitle(item, currNode.getData()) > 0))
        {
            prevNode = currNode;
            currNode = currNode.next();
        }
        
        if (prevNode != null)
        {
            prevNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currNode);
        }
        
        else
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }
    
    
    /**
     * compares Song objects by title using
     * getTitle() method
     * 
     * @param song1 - 1st object
     * @param song2 - 2nd object
     * @return int - value returned by compareTo()
     */
    private int compareByTitle(E song1, E song2)
    {
        return ((Song) song1).getTitle().compareTo(((Song) 
                song2).getTitle());
    }

    
    
    
    
    
    
    
    /**
     * sorts the SongList by genre, calls
     * the insertInOrderByGenre() and 
     * compareByGenre() methods. Insertion 
     * sort is performed on the list.
     */
    public void sortByGenre()
    {
        if (size > 1)
        {
            //assert head != null;
            
            Node<E> unsortedPart = head.next();
            //assert unsortedPart != null;
            head.setNext(null);
            while (unsortedPart != null)
            {
                Node<E> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertInOrderByGenre(nodeToInsert);
            }
        }
    }
    
     /**
      * helper method to insert nodes in order
      * 
      * @param nodeToInsert - the node that is part 
      * of unsorted part, needs to placed in sorted part
      * of list
      */
    private void insertInOrderByGenre(Node<E> nodeToInsert)
    {
        E item = nodeToInsert.getData();
        Node<E> currNode = head;
        Node<E> prevNode = null;
        
        while ((currNode != null) && 
                (compareByGenre(item, currNode.getData()) > 0))
        {
            prevNode = currNode;
            currNode = currNode.next();
        }
        
        if (prevNode != null)
        {
            prevNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currNode);
        }
        
        else
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }
    
    /**
     * compares Song objects by genre using
     * getGenre() method
     * 
     * @param song1 - 1st object
     * @param song2 - 2nd object
     * @return int - value returned by compareTo()
     */
    private int compareByGenre(E song1, E song2)
    {
        return ((Song) song1).getGenre().compareTo
                (((Song) song2).getGenre());
    }
   
    
    
    
    
    
    
    /**
     * sorts the SongList by artist, calls
     * the insertInOrderByArtist() and 
     * compareByArtist() methods. Insertion 
     * sort is performed on the list.
     */
    public void sortByArtist()
    {
        if (size > 1)
        {
            //assert head != null;
            
            Node<E> unsortedPart = head.next();
            //assert unsortedPart != null;
            head.setNext(null);
            while (unsortedPart != null)
            {
                Node<E> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertInOrderByArtist(nodeToInsert);
            }
        }
    }
    
     /**
      * helper method to insert nodes in order
      * 
      * @param nodeToInsert - the node that is part 
      * of unsorted part, needs to placed in sorted part
      * of list
      */
    private void insertInOrderByArtist(Node<E> nodeToInsert)
    {
        E item = nodeToInsert.getData();
        Node<E> currNode = head;
        Node<E> prevNode = null;
        
        while ((currNode != null) && 
                (compareByArtist(item, currNode.getData()) > 0))
        {
            prevNode = currNode;
            currNode = currNode.next();
        }
        
        if (prevNode != null)
        {
            prevNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currNode);
        }
        
        else
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }
    
    
    /**
     * compares Song objects by artist using
     * getArtist() method
     * 
     * @param song1 - 1st object
     * @param song2 - 2nd object
     * @return int - value returned by compareTo()
     */
    private int compareByArtist(E song1, E song2)
    {
        return ((Song) song1).getArtist().compareTo(((Song) 
                song2).getArtist());
    }
   
    
    
    
    
    
    
    
    
    
    /**
     * sorts the SongList by date, calls
     * the insertInOrderByDate() and 
     * compareByDate() methods. Insertion 
     * sort is performed on the list.
     */
    public void sortByDate()
    {
        if (size > 1)
        {
            //assert head != null;
            
            Node<E> unsortedPart = head.next();
            //assert unsortedPart != null;
            head.setNext(null);
            while (unsortedPart != null)
            {
                Node<E> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertInOrderByDate(nodeToInsert);
            }
        }
    }
    
     /**
      * helper method to insert nodes in order
      * 
      * @param nodeToInsert - the node that is part 
      * of unsorted part, needs to placed in sorted part
      * of list
      */
    private void insertInOrderByDate(Node<E> nodeToInsert)
    {
        E item = nodeToInsert.getData();
        Node<E> currNode = head;
        Node<E> prevNode = null;
        
        while ((currNode != null) && 
                (compareByDate(item, currNode.getData()) > 0))
        {
            prevNode = currNode;
            currNode = currNode.next();
        }
        
        if (prevNode != null)
        {
            prevNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currNode);
        }
        
        else
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }
    
    
    /**
     * compares Song objects by date using
     * getDate() method
     * 
     * @param song1 - 1st object
     * @param song2 - 2nd object
     * @return int - value returned by compareTo()
     */
    private int compareByDate(E song1, E song2)
    {
        return ((Song) song1).getDate().compareTo(((Song) 
                song2).getDate());
    }
    
    /**
     * 
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++)
        {
            if (i != size - 1)
            {
                builder.append(this.get(i) + ", ");
            }
            else
            {
                builder.append(this.get(i));
            }
        }
        builder.append("]");
        return builder.toString();
    }
    
    
    
    
    
    /**
     * This represents a node in a doubly linked list. This node stores data, a
     * pointer to the node before it in the list, and a pointer to the node
     * after it in the list
     *
     * @param <E>
     *            This is the type of object that this class will store
     * @author Mark Wiggans (mmw125)
     * @version 4/14/2015
     */
    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }

        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }

        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<E> n) {
            previous = n;
        }
        
        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }

        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous() {
            return previous;
        }

        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }
    }
    
    
    
    
    
    
    
    
    
    /**
     * 
     * @author Vamsi Manne vmanne20
     * @version 10/28
     * 
     * this is the inner class iterator that can be used 
     * to traverse a DLList
     */
    public class SongListIterator implements Iterator<E> {

        private Node<E> nextNode;
        private boolean wasNextCalled;
        /**
         * Creates a new DLListIterator
         */
        public SongListIterator() 
        {
            nextNode = head;
            wasNextCalled = false;
        }

        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() 
        {
            if (nextNode != null)
            {
                return nextNode.getData() != null;
            }
            else
            {
                return false;
            }
        }

        /**
         *Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() 
        {
            if (hasNext())
            {
                wasNextCalled = true;
                Node<E> returnNode = nextNode;
                if (nextNode.next() != null)
                {
                    nextNode = nextNode.next();
                }
                else
                {
                    Node<E> tail = new Node<E>(null);
                    nextNode.setNext(tail);
                    nextNode = tail;
                }
                return returnNode.getData();
            }
            else
            {
                throw new NoSuchElementException("Illegal call");
            }
        }

        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         * @throws IllegalStateException
         *             if the element has already been removed
         */
        @Override
        public void remove() 
        {
            if (wasNextCalled)
            {
                Node<E> currNode = nextNode.previous();
                if (currNode != null)
                {
                    nextNode.setPrevious(currNode.previous());
                    if (currNode.previous() != null)
                    {
                        currNode.previous.setNext(nextNode);
                    }
                }
                else
                {
                    nextNode.setPrevious(null);
                }
                size--;
                wasNextCalled = false;
            }
            else
            {
                throw new IllegalStateException("Illegal call to remove()");
            }
        }
    }
    




    




 
}
