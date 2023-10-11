// Modelo de un nodo para el Árbol Binario de Búsqueda
class Nodo {
    Aula aula; // Datos del nodo (el aula)
    Nodo izquierda, derecha; // Nodos hijos
    int altura; // Altura del nodo para mantener el árbol balanceado

    // Constructor del Nodo
    Nodo(Aula aula) {
        this.aula = aula;
        this.altura = 1;  // Por defecto, la altura es 1 al crear el nodo
    }
}

