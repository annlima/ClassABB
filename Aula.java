// Modelo de una clase Aula
class Aula {
    int capacidad; // Capacidad máxima de estudiantes que puede albergar el aula
    String detalles; // Detalles del aula, como su ubicación

    Aula() {} // Constructor vacío

    // Constructor con parámetros
    Aula(int capacidad, String detalles) {
        this.capacidad = capacidad;
        this.detalles = detalles;
    }
}
