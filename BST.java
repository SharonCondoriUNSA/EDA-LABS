public class BST {
    TreeNode<Integer> root;

    public void insertar(int value) {
        root = insertarRec(root, value);
    }

    private TreeNode<Integer> insertarRec(TreeNode<Integer> current, int value) {
        if (current == null) return new TreeNode<>(value);
        if (value < current.data) current.left = insertarRec(current.left, value);
        else current.right = insertarRec(current.right, value);
        return current;
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }
}