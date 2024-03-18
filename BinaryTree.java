/**
 * Clase que representa un árbol binario de búsqueda.
 *
 * @param <K> Tipo de la clave del nodo.
 * @param <V> Tipo del valor almacenado en el nodo.
 */
public class BinaryTree<K extends Comparable<K>, V> {
    /** Raíz del árbol binario. */
    public TreeNode<K, V> root;

    /**
     * Constructor de la clase BinaryTree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Método para insertar un nodo en el árbol.
     *
     * @param key   Clave del nodo a insertar.
     * @param value Valor asociado al nodo a insertar.
     */
    public void insert(K key, V value) {
        root = insertRec(root, key, value);
    }

    /**
     * Método auxiliar para insertar un nodo de forma recursiva.
     *
     * @param node  Nodo actual del árbol.
     * @param key   Clave del nodo a insertar.
     * @param value Valor asociado al nodo a insertar.
     * @return El nodo actualizado.
     */
    private TreeNode<K, V> insertRec(TreeNode<K, V> node, K key, V value) {
        if (node == null) {
            return new TreeNode<>(key, value);
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(insertRec(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(insertRec(node.getRight(), key, value));
        }

        return node;
    }

    /**
     * Método para buscar un valor asociado a una clave en el árbol.
     *
     * @param key Clave a buscar en el árbol.
     * @return El valor asociado a la clave especificada, o null si la clave no se encuentra en el árbol.
     */
    public V search(K key) {
        return searchRec(root, key);
    }

    /**
     * Método auxiliar para buscar un valor asociado a una clave de forma recursiva.
     *
     * @param node Nodo actual del árbol.
     * @param key  Clave a buscar en el árbol.
     * @return El valor asociado a la clave especificada, o null si la clave no se encuentra en el árbol.
     */
    private V searchRec(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            return searchRec(node.getLeft(), key);
        } else if (cmp > 0) {
            return searchRec(node.getRight(), key);
        } else {
            return node.getValue();
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode<K, V> node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeft());
        System.out.println(node.getKey() + " - " + node.getValue());
        inOrderTraversal(node.getRight());
    }
}