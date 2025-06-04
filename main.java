public class main {
    public static void main(String[] args) {
        String palabra = "RICHART"; // en mayúsculas
        BST bst = new BST();

        for (char c : palabra.toCharArray()) {
            bst.insertar((int) c);
        }

        BSTVisualizer visual = new BSTVisualizer();
        visual.buildGraph(bst.getRoot(), null);
        visual.visualizar();
    }
}
