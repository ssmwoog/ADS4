public class Test {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(2, "two");
        tree.put(7, "nine");
        tree.put(9, "six");
        for (BST<Integer, String>.Node node : tree) {
            System.out.println("key is " + node.key + " and value is " + node.val);
        }
    }
}

