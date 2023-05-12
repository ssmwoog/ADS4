import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
        size++;
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            return new Node(key, val);
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = put(x.left, key, val);
        }
        else if (compare > 0) {
            x.right = put(x.right, key, val);
        }
        else {
            x.val = val;
        }
        return x;
    }

    public V get(K key) {
        Node x = root;
        while (x != null) {
            int compare = key.compareTo(x.key);
            if (compare < 0) {
                x = x.left;
            }
            else if (compare > 0) {
                x = x.right;
            }
            else {
                return x.val;
            }
        }
        return null;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        else {
            return min(x.left);
        }
    }

    public void delete(K key) {
        root = delete(root, key);
        size--;
    }

    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = delete(x.left, key);
        }
        else if (compare > 0) {
            x.right = delete(x.right, key);
        }
        else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public int size() {
        return size;
    }

    public Iterator<Node> iterator() {
        Queue<Node> queue = new LinkedList<>();
        inorder(root, queue);
        return queue.iterator();
    }

    private void inorder(Node x, Queue<Node> queue) {
        if (x == null) return;
        inorder(x.left, queue);
        queue.offer(x);
        inorder(x.right, queue);
    }
}