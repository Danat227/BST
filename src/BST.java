import java.util.Iterator;
import java.util.Stack;

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
    public V get(K key) {
       Node current = root;
       while (current != null) {
           int cmp = key.compareTo(current.key);
           if (cmp < 0) {
               current = current.left;
           } else if (cmp > 0) {
               current = current.right;
           } else {
               return current.val;
           }
       }
        return null;
    }
    public void put(K key, V val) {
        if (root == null) {
            root = new Node(key, val);
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left = new Node(key, val);
        } else {
            parent.right = new Node(key, val);
        }
        size++;
    }
    public class KeyValuePair {
        private K key;
        private V val;

        public KeyValuePair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() { return key; }
        public V getValue() { return val; }
    }
    public Iterable<KeyValuePair> iterator() {
        return new Iterable<KeyValuePair>() {
            public Iterator<KeyValuePair> iterator() {
                return new Iterator<KeyValuePair>() {
                    private Stack<Node> stack = new Stack<>();
                    private Node current = root;

                    public boolean hasNext() {
                        return current != null || !stack.isEmpty();
                    }


                    public KeyValuePair next() {
                        while (current != null) {
                            stack.push(current);
                            current = current.left;
                        }

                        Node node = stack.pop();
                        KeyValuePair result = new KeyValuePair(node.key, node.val);

                        current = node.right;
                        return result;
                    }
                };
            }
        };
    }
    public void delete(K key) {
        Node parent = null;
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) { parent = current; current = current.left; }
            else if (cmp > 0) { parent = current; current = current.right; }
            else break;
        }

        if (current == null) return;

        if (current.left != null && current.right != null) {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            current.key = successor.key;
            current.val = successor.val;
            current = successor;
            parent = successorParent;
        }

        Node replacementChild = (current.left != null) ? current.left : current.right;

        if (parent == null) root = replacementChild;
        else if (parent.left == current) parent.left = replacementChild;
        else parent.right = replacementChild;

        size--;
    }



}






