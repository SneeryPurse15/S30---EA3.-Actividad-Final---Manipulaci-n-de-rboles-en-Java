public class ArbolInventario {
    private Producto raiz;

    // Insertar producto en el árbol (recursivo)
    public void insertar(int id, String nombre) {
        Producto nuevo = new Producto(id, nombre);
        raiz = insertarRecursivo(raiz, nuevo);
    }

    private Producto insertarRecursivo(Producto actual, Producto nuevo) {
        if (actual == null) return nuevo;
        if (nuevo.id < actual.id) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, nuevo);
        } else if (nuevo.id > actual.id) {
            actual.derecho = insertarRecursivo(actual.derecho, nuevo);
        }
        return actual;
    }

    // Recorrido inorden (izquierda - raíz - derecha)
    public void inorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Producto actual) {
        if (actual != null) {
            inordenRecursivo(actual.izquierdo);
            System.out.println(actual);
            inordenRecursivo(actual.derecho);
        }
    }

    // Buscar producto por ID
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private Producto buscarRecursivo(Producto actual, int id) {
        if (actual == null) return null;
        if (id == actual.id) return actual;
        return id < actual.id ? buscarRecursivo(actual.izquierdo, id) : buscarRecursivo(actual.derecho, id);
    }
}
