package uvg.edu.gt;

import java.util.Scanner;
import java.util.Vector;

public class App {
    public static void main(String[] args) {
        Vector<Paciente> pacientes = new Vector<>();

        // Agregar pacientes predefinidos
        agregarPaciente(pacientes, "Juan Perez", "fractura de pierna", "C");
        agregarPaciente(pacientes, "Maria Ramirez", "apendicitis", "A");
        agregarPaciente(pacientes, "Lorenzo Toledo", "chikungunya", "E");
        agregarPaciente(pacientes, "Carmen Sarmientos", "dolores de parto", "B");

        VectorHeap<Paciente> colaPacientes = new VectorHeap<>(pacientes);

        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\nMENÚ");
            System.out.println("1. Atender paciente");
            System.out.println("2. Agregar paciente");
            System.out.println("3. Salir");

            System.out.print("\nIngrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Atender paciente
                    atenderPaciente(colaPacientes);
                    break;
                case 2:
                    // Agregar paciente
                    agregarNuevoPaciente(colaPacientes, scanner);
                    break;
                case 3:
                    // Salir
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void agregarPaciente(Vector<Paciente> pacientes, String nombre, String condicion, String prioridad) {
        Paciente paciente = new Paciente(nombre, condicion, prioridad);
        pacientes.add(paciente);
    }

    private static void agregarNuevoPaciente(VectorHeap<Paciente> colaPacientes, Scanner scanner) {
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la condición del paciente:");
        String condicion = scanner.nextLine();

        System.out.println("Ingrese la prioridad del paciente:");
        String prioridad = scanner.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre, condicion, prioridad);
        colaPacientes.add(nuevoPaciente);

        System.out.println("Paciente agregado correctamente.");
    }

    private static void atenderPaciente(VectorHeap<Paciente> colaPacientes) {
        if (!colaPacientes.isEmpty()) {
            Paciente pacienteAtendido = colaPacientes.remove();
            System.out.println("\nPaciente atendido:");
            System.out.println("Nombre: " + pacienteAtendido.getNombre());
            System.out.println("Condición: " + pacienteAtendido.getCondicion());
            System.out.println("Prioridad: " + pacienteAtendido.getPrioridad());
        } else {
            System.out.println("\nNo hay pacientes en la cola.");
        }
    }
}
