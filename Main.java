import java.util.Scanner;

// Clase principal que maneja la interacción con el usuario
public class Main {
    public static void main(String[] args) {
        ABB abb = new ABB();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Gestión de Aulas");
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar una nueva aula");
            System.out.println("2. Asignar un aula");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la capacidad del aula: ");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea

                    System.out.print("Ingrese los detalles del aula: ");
                    String descripcion = scanner.nextLine();
                    scanner.nextLine();  // Consumir el salto de línea


                    System.out.print("Ingreseel edificio del aula: ");
                    String edificio = scanner.nextLine();
                    scanner.nextLine();  // Consumir el salto de línea

                    System.out.print("Ingrese el numero del aula: ");
                    int salon = scanner.nextInt();

                    System.out.print("Ingrese 0 si quiere no quiere pc y 1 si si ");
                    int pc = scanner.nextInt();

                    System.out.print("Ingrese 0 si quiere no quiere proyector y 1 si si ");
                    int proyector = scanner.nextInt();

                    System.out.print("Ingrese 0 si quiere no quiere pizarron y 1 si si ");
                    int pizarron = scanner.nextInt();

                    abb.insert(capacidad, edificio, salon, descripcion, pc, proyector, pizarron);
                    System.out.println("Aula ingresada con éxito!");
                    break;

                case 2:
                    System.out.print("Ingrese la capacidad de estudiantes para la clase: ");
                    int capacidadEstudiantes = scanner.nextInt();

                    System.out.print("Ingrese si quiere pc: ");
                    int pcaula = scanner.nextInt();

                    System.out.print("Ingrese la capacidad de estudiantes para la clase: ");
                    int proyectoraula = scanner.nextInt();

                    System.out.print("Ingrese la capacidad de estudiantes para la clase: ");
                    int pizarronaula = scanner.nextInt();

                    String aulaAsignada = abb.assignAula(capacidadEstudiantes, pcaula, proyectoraula, pizarronaula);
                    if (aulaAsignada != null) {
                        System.out.println("Aula asignada: " + aulaAsignada);
                    } else {
                        System.out.println("No se encontró un aula adecuada.");
                    }
                    break;

                case 3:
                    System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
                    break;
            }
        }
    }
}
