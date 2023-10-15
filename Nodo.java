// Modelo de un nodo para el Árbol Binario de Búsqueda
class Nodo {
    Aula aula;
    Nodo izquierda;
    Nodo derecha;
    int altura;

    public Nodo(Aula aula) {
        this.aula = aula;
        this.altura = 1;  // Al crear un nuevo nodo, su altura es 1.
    }
}



