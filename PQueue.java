import java.util.*;

/**
 * This class describes a priority min-queue that uses an array-list-based min binary heap 
 * that implements the PQueueAPI interface. The array list holds objects that implement 
 * the parameterized Comparable interface.
 * @author Duncan, Sheridan
 * <pre>
 * Date: 9-28-2024
 * course: csc 3102
 * Programming Project: 1
 * Instructor: Dr. Duncan
 * <pre>
 */
 
 
 /**
  * A min-priority queue implementation that uses an 
  * array list as its data container
  * @param <E> the priority queue element type.   
  */
public class PQueue<E extends Comparable<E>> implements PQueueAPI<E>
{    
   /**
    * A complete tree stored in an array list representing the 
    * binary heap
    */
   private ArrayList<E> tree;
   /**
    * A comparator lambda function that compares two elements of this
    * heap when rebuilding it; cmp.compare(x,y) gives 1. negative when x less than y
    * 2. positive when x greater than y 3. 0 when x equal y
    */   
   private Comparator<? super E> cmp;
   
   /**
    * Constructs an empty PQueue using the compareTo method of its data type as the 
	* comparator
    */
   public PQueue()
   {
      tree = new ArrayList<>();
      cmp = Comparator.naturalOrder();

   }
   
   /**
    * copy constructor
    */
   public PQueue(PQueue pQ)
   {
      this.tree = new ArrayList<>(pQ.tree);
      this.cmp = pQ.cmp;

   }
   
   /**
    * A parameterized constructor that uses an externally defined comparator    
    * @param fn - a trichotomous integer value comparator function   
    */
   public PQueue(Comparator<? super E> fn)
   {
      this.tree = new ArrayList<>();
      this.cmp = fn;
   }

   public boolean isEmpty()
   {
      return tree.isEmpty();
   }

   public void insert(E obj)
   {
      tree.add(obj);
      int place = tree.size() - 1;
      int parent = (place - 1) / 2;
      while (place > 0 && cmp.compare(tree.get(place), tree.get(parent)) < 0) {
         swap(place, parent);
         place = parent;
         parent = (place - 1) / 2;
      }
   }

   public E remove() throws PQueueException
   {
      if (isEmpty()) throw new PQueueException("Priority queue is empty");
      E root = tree.get(0);
      E last = tree.remove(tree.size() - 1);
      if (!tree.isEmpty()) {
         tree.set(0, last);
         rebuild(0);
      }
      return root;
   }
 
   public E peek() throws PQueueException
   {
      if (isEmpty()) throw new PQueueException("Priority queue is empty");
      return tree.get(0);
   }

   public int size()
   {
      return tree.size();
   }
   
   /**
    * Swaps a parent and child elements of this heap at the specified indices
    * @param place an index of the child element on this heap
    * @param parent an index of the parent element on this heap
    */
   private void swap(int place, int parent)
   {
      E temp = tree.get(place);
      tree.set(place, tree.get(parent));
      tree.set(parent, temp);
   }

   /**
    * Rebuilds the heap to ensure that the heap property of the tree is preserved.
    * @param root the root index of the subtree to be rebuilt
    */
   private void rebuild(int root)
   {
      int smallest = root;
      int left = 2 * root + 1;
      int right = 2 * root + 2;

      if (left < tree.size() && cmp.compare(tree.get(left), tree.get(smallest)) < 0) {
         smallest = left;
      }
      if (right < tree.size() && cmp.compare(tree.get(right), tree.get(smallest)) < 0) {
         smallest = right;
      }
      if (smallest != root) {
         swap(root, smallest);
         rebuild(smallest);
      }
   }
}
