public class Test {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(2, "two");
        tree.put(1, "one");
        tree.put(3, "three");
        for (BST<Integer, String>.Node node : tree) {
            System.out.println("key is " + node.key + " and value is " + node.val);
        }
    }
}

