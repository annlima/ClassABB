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

                    System.out.print("Ingrese los detalles del aula (ej. Edificio A - Aula 101): ");
                    String detalles = scanner.nextLine();

                    abb.insert(capacidad, detalles);
                    System.out.println("Aula ingresada con éxito!");
                    break;

                case 2:
                    System.out.print("Ingrese la capacidad de estudiantes para la clase: ");
                    int capacidadEstudiantes = scanner.nextInt();

                    String aulaAsignada = abb.assignAula(capacidadEstudiantes);
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
