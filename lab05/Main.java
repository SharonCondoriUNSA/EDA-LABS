public class Main {
    public static void main(String[] args) {
        String palabra = "HOLA";
        ArbolAVL arbol = new ArbolAVL();

        NodoAVL raiz = null;
        System.out.println("Insertando valores ASCII de: " + palabra);

        for (char c : palabra.toCharArray()) {
            int ascii = (int) c;
            System.out.println("Letra: " + c + " -> ASCII: " + ascii);
            raiz = arbol.insert(raiz, ascii);
        }

        System.out.println("\n- Búsqueda de 'L' (76): " + arbol.search(raiz, 76));
        System.out.println("- Mínimo: " + arbol.getMin(raiz));
        System.out.println("- Máximo: " + arbol.getMax(raiz));

        NodoAVL padre = arbol.parent(raiz, 79, null);
        if (padre != null)
            System.out.println("- Padre de 79: " + padre.valor);
        else
            System.out.println("- Padre de 79: No encontrado");

        System.out.println("- Hijos de 72:");
        arbol.son(raiz, 72);
    }
}