// Modelo de una clase Aula
class Aula {
    int capacidad;
    String edificio;
    int salon;
    String descripcion;
    int pc;
    int proyector;
    int pizarron;

    public Aula() {
        // Constructor vacío para inicialización
    }

    public Aula(int capacidad, String edificio, int salon, String descripcion, int pc, int proyector, int pizarron) {
        this.capacidad = capacidad;
        this.edificio = edificio;
        this.salon = salon;
        this.descripcion = descripcion;
        this.pc = pc;
        this.proyector = proyector;
        this.pizarron = pizarron;
    }
}


