package uvg.edu.gt;

import java.util.Vector;

/**
 * Esta clase implementa una cola de prioridad utilizando un heap almacenado en un vector.
 * El heap se implementa como un árbol binario completo, donde cada nodo tiene un valor
 * y cumple con la propiedad de heap, donde el valor de cada nodo es menor o igual que
 * el valor de sus hijos.
 *
 * IMPORTANTE: Algunas funciones del presente código fueron recuperadas de las notas de clase
 *
 * @param <E> el tipo de elementos que se almacenarán en el heap, debe ser comparable.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> heap;

    /**
     * Construye una nueva cola de prioridad a partir de un vector no ordenado de elementos.
     *
     * @param v el vector no ordenado de elementos.
     */
    public VectorHeap(Vector<E> v) {
        heap = new Vector<E>(v.size()); // sabemos el tamaño final
        for (int i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    /**
     * Retorna el índice del padre de un nodo en el heap.
     *
     * @param i el índice del nodo.
     * @return el índice del padre del nodo.
     */
    protected static int parent(int i) {
        return (int) Math.floor((i - 1) / 2);
    }

    /**
     * Retorna el índice del hijo izquierdo de un nodo en el heap.
     *
     * @param i el índice del nodo.
     * @return el índice del hijo izquierdo del nodo.
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Retorna el índice del hijo derecho de un nodo en el heap.
     *
     * @param i el índice del nodo.
     * @return el índice del hijo derecho del nodo.
     */
    protected static int right(int i) {
        return (2 * i + 1) + 1;
    }

    /**
     * Mueve un nodo hacia arriba en el heap para mantener la propiedad del heap.
     *
     * @param leaf el índice del nodo a mover hacia arriba.
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = heap.get(leaf);
        while (leaf > 0 && (value.compareTo(heap.get(parent)) < 0)) {
            heap.set(leaf, heap.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        heap.set(leaf, value);
    }

    /**
     * Agrega un valor a la cola de prioridad.
     *
     * @param value el valor a agregar.
     */
    public void add(E value) {
        heap.add(value);
        percolateUp(heap.size() - 1);
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     *
     * @return true si la cola de prioridad está vacía, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Retorna el tamaño de la cola de prioridad.
     *
     * @return el tamaño de la cola de prioridad.
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Elimina todos los elementos de la cola de prioridad.
     */
    @Override
    public void clear() {
        heap.clear();
    }

    /**
     * Mueve un nodo hacia abajo en el heap a partir de la raíz para mantener la propiedad del heap.
     *
     * @param root el índice del nodo raíz.
     */
    protected void pushDownRoot(int root) {
        int heapSize = heap.size();
        E value = heap.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                        ((heap.get(childpos + 1)).compareTo(heap.get(childpos)) < 0)) {
                    childpos++;
                }
                // Se asegura que childpos indexa al hijo más pequeño de los dos hijos
                if ((heap.get(childpos)).compareTo(value) < 0) {
                    heap.set(root, heap.get(childpos));
                    root = childpos; // sigue bajando
                } else { // se ha encontrado la posición correcta
                    heap.set(root, value);
                    return;
                }
            } else { // está en una hoja, inserta y termina
                heap.set(root, value);
                return;
            }
        }
    }

    /**
     * Retorna el primer elemento de la cola de prioridad, que es el elemento mínimo.
     *
     * @return el primer elemento de la cola de prioridad.
     */
    @Override
    public E getFirst() {
        return heap.get(0);
    }

    /**
     * Elimina y retorna el elemento mínimo de la cola de prioridad.
     *
     * @return el elemento mínimo de la cola de prioridad.
     * @throws IllegalStateException si la cola de prioridad está vacía.
     */
    public E remove() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola de prioridad está vacía");
        }
        E minVal = getFirst();
        heap.set(0, heap.get(heap.size() - 1));
        heap.setSize(heap.size() - 1);
        if (heap.size() > 1) {
            pushDownRoot(0);
        }
        return minVal;
    }

    /**
     * Retorna una representación en cadena de la cola de prioridad.
     *
     * @return una representación en cadena de la cola de prioridad.
     */
    public String toString() {
        if (heap.isEmpty()) {
            return "[]";
        }

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[");
        strBuilder.append(heap.get(0));

        for (int i = 1; i < heap.size(); i++) {
            strBuilder.append(", ");
            strBuilder.append(heap.get(i).toString());
        }

        strBuilder.append("]");
        return strBuilder.toString();
    }


}
