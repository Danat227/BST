public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size; // Для задания Part 2.2 (1)

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;

        }
    }
    public int size() {
        return size;
    }
}

