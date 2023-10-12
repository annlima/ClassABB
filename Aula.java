// Modelo de una clase Aula
class Aula {
    int capacidad; // Capacidad máxima de estudiantes que puede albergar el aula
    String edificio; // Edificio del salon
    int salon; //Numero de salon del edificio
    String descripcion; // Descripcion del salon
    int pc;
    int proyector;
    int pizarron;


    Aula() {} // Constructor vacío

    // Constructor con parámetros
    Aula(int capacidad, String edificio,int salon, String descripcion, int pc, int proyector, int pizarron) {
        this.capacidad = capacidad;
        this.edificio = edificio;
        this.salon = salon;
        this.descripcion = descripcion;
        this.pc = pc;
        this.proyector = proyector;
        this.pizarron = pizarron;

    }
}
