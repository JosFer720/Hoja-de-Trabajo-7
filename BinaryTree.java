public class BinaryTree<K extends Comparable<K>, V> {
    public TreeNode<K, V> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(K key, V value) {
        root = insertRec(root, key, value);
    }

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

    public V search(K key) {
        return searchRec(root, key);
    }

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
}