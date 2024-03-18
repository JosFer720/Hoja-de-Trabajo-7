/**
 * Clase que representa un nodo de un árbol binario.
 *
 * @param <K> Tipo de la clave del nodo.
 * @param <V> Tipo del valor almacenado en el nodo.
 */
public class TreeNode<K, V> {
    private K key;
    private V value;
    private TreeNode<K, V> left;
    private TreeNode<K, V> right;

    /**
     * Constructor de la clase TreeNode.
     *
     * @param key   Clave del nodo.
     * @param value Valor asociado al nodo.
     */
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Método para obtener la clave del nodo.
     *
     * @return La clave del nodo.
     */
    public K getKey() {
        return key;
    }

    /**
     * Método para establecer la clave del nodo.
     *
     * @param key La nueva clave del nodo.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Método para obtener el valor almacenado en el nodo.
     *
     * @return El valor almacenado en el nodo.
     */
    public V getValue() {
        return value;
    }

    /**
     * Método para establecer el valor almacenado en el nodo.
     *
     * @param value El nuevo valor a almacenar en el nodo.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Método para obtener el hijo izquierdo del nodo.
     *
     * @return El hijo izquierdo del nodo.
     */
    public TreeNode<K, V> getLeft() {
        return left;
    }

    /**
     * Método para establecer el hijo izquierdo del nodo.
     *
     * @param left El nuevo hijo izquierdo del nodo.
     */
    public void setLeft(TreeNode<K, V> left) {
        this.left = left;
    }

    /**
     * Método para obtener el hijo derecho del nodo.
     *
     * @return El hijo derecho del nodo.
     */
    public TreeNode<K, V> getRight() {
        return right;
    }

    /**
     * Método para establecer el hijo derecho del nodo.
     *
     * @param right El nuevo hijo derecho del nodo.
     */
    public void setRight(TreeNode<K, V> right) {
        this.right = right;
    }
}