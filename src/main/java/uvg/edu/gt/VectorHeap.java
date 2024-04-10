package uvg.edu.gt;

import java.util.Vector;

public class  VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
    protected Vector<E> heap;

    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        heap = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }

    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }

    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }

    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2*i+1) + 1;
    }

    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = heap.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(heap.get(parent)) < 0))
        {
            heap.set(leaf,heap.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        heap.set(leaf,value);
    }

    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        heap.add(value);
        percolateUp(heap.size()-1);
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     *
     */
    @Override
    public void clear() {
        heap.clear();
    }

    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = heap.size();
        E value = heap.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((heap.get(childpos+1)).compareTo
                                (heap.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((heap.get(childpos)).compareTo
                        (value) < 0)
                {
                    heap.set(root,heap.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    heap.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                heap.set(root,value);
                return;
            }
        }
    }

    /**
     * @return
     */
    @Override
    public E getFirst() {
        return heap.get(0);
    }

    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        heap.set(0,heap.get(heap.size()-1));
        heap.setSize(heap.size()-1);
        if (heap.size() > 1) pushDownRoot(0);
        return minVal;
    }


}
