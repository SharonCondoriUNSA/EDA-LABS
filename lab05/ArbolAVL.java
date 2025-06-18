
public class ArbolAVL {

	    int altura(NodoAVL nodo) {
	        if (nodo == null)
	            return 0;
	        return nodo.altura;
	    }

	    int factorEquilibrio(NodoAVL nodo) {
	        if (nodo == null)
	            return 0;
	        return altura(nodo.izquierdo) - altura(nodo.derecho);
	    }

	    NodoAVL rotacionDerecha(NodoAVL y) {
	        NodoAVL x = y.izquierdo;
	        NodoAVL T2 = x.derecho;

	        x.derecho = y;
	        y.izquierdo = T2;

	        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
	        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

	        return x;
	    }

	    NodoAVL rotacionIzquierda(NodoAVL x) {
	        NodoAVL y = x.derecho;
	        NodoAVL T2 = y.izquierdo;

	        y.izquierdo = x;
	        x.derecho = T2;

	        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
	        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

	        return y;
	    }

	    NodoAVL insert(NodoAVL nodo, int valor) {
	        if (nodo == null)
	            return new NodoAVL(valor);

	        if (valor < nodo.valor)
	            nodo.izquierdo = insert(nodo.izquierdo, valor);
	        else if (valor > nodo.valor)
	            nodo.derecho = insert(nodo.derecho, valor);
	        else
	            return nodo;

	        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
	        int balance = factorEquilibrio(nodo);

	        // Rotaciones
	        if (balance > 1 && valor < nodo.izquierdo.valor)
	            return rotacionDerecha(nodo);

	        if (balance < -1 && valor > nodo.derecho.valor)
	            return rotacionIzquierda(nodo);

	        if (balance > 1 && valor > nodo.izquierdo.valor) {
	            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
	            return rotacionDerecha(nodo);
	        }

	        if (balance < -1 && valor < nodo.derecho.valor) {
	            nodo.derecho = rotacionDerecha(nodo.derecho);
	            return rotacionIzquierda(nodo);
	        }

	        return nodo;
	    }

	    boolean search(NodoAVL nodo, int valor) {
	        if (nodo == null) return false;
	        if (nodo.valor == valor) return true;
	        return valor < nodo.valor ? search(nodo.izquierdo, valor) : search(nodo.derecho, valor);
	    }

	    int getMin(NodoAVL nodo) {
	        while (nodo.izquierdo != null)
	            nodo = nodo.izquierdo;
	        return nodo.valor;
	    }

	    int getMax(NodoAVL nodo) {
	        while (nodo.derecho != null)
	            nodo = nodo.derecho;
	        return nodo.valor;
	    }

	    NodoAVL parent(NodoAVL nodo, int valor, NodoAVL padre) {
	        if (nodo == null)
	            return null;
	        if (nodo.valor == valor)
	            return padre;
	        return valor < nodo.valor ?
	            parent(nodo.izquierdo, valor, nodo) :
	            parent(nodo.derecho, valor, nodo);
	    }

	    void son(NodoAVL nodo, int valor) {
	        if (nodo == null) return;

	        if (nodo.valor == valor) {
	            if (nodo.izquierdo != null)
	                System.out.println("Hijo izquierdo: " + nodo.izquierdo.valor);
	            if (nodo.derecho != null)
	                System.out.println("Hijo derecho: " + nodo.derecho.valor);
	            return;
	        }

	        if (valor < nodo.valor)
	            son(nodo.izquierdo, valor);
	        else
	            son(nodo.derecho, valor);
	    }
	}

