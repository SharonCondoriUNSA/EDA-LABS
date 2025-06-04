import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class BSTVisualizer {
    private Graph graph;
    private int contador = 0;
    private boolean pintóRpadre = false; 
    public BSTVisualizer() {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new SingleGraph("Árbol Binario");
        graph.setAttribute("ui.stylesheet",
                "node { fill-color: lightblue; size: 25px; text-size: 16px; shape: circle; }" +
                "node.padre { fill-color: yellow; }" +
                "edge { arrow-shape: arrow; }");
    }

    public void buildGraph(TreeNode<Integer> node, String parentId) {
        if (node == null) return;

        String letra = Character.toString((char)(int) node.data);
        String nodeId = letra + "_" + contador++;
        NodeInfo info = new NodeInfo(nodeId, letra);

        Node gsNode = graph.addNode(nodeId);
        gsNode.setAttribute("ui.label", letra);

        if (!pintóRpadre && letra.equals("R") && (node.left != null || node.right != null)) {
            gsNode.setAttribute("ui.class", "padre");
            pintóRpadre = true;  // ya pintamos la R mayor
        }
        if (parentId != null) {
            graph.addEdge(parentId + "-" + nodeId, parentId, nodeId, true);
        }

        buildGraph(node.left, nodeId);
        buildGraph(node.right, nodeId);
    }

    public void visualizar() {
        graph.display();
    }

    private static class NodeInfo {
        String id;
        String label;

        public NodeInfo(String id, String label) {
            this.id = id;
            this.label = label;
        }
    }
}


