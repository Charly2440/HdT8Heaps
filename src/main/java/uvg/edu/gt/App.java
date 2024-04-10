package uvg.edu.gt;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) {
        Vector<Paciente> pacientes = new Vector<>();

        // Agregar pacientes predefinidos
        agregarPaciente(pacientes, "Juan Perez", "fractura de pierna", "C");
        agregarPaciente(pacientes, "Maria Ramirez", "apendicitis", "A");
        agregarPaciente(pacientes, "Lorenzo Toledo", "chikungunya", "E");
        agregarPaciente(pacientes, "Carmen Sarmientos", "dolores de parto", "B");

        VectorHeap<Paciente> colaPacientesVectorHeap = new VectorHeap<>(pacientes);
        PriorityQueue<Paciente> colaPacientesJC = new PriorityQueue<>(pacientes);

        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\nMENÚ");
            System.out.println("1. Atender paciente (VectorHeap)");
            System.out.println("2. Atender paciente (Java Collections)");
            System.out.println("3. Agregar paciente");
            System.out.println("4. Atender paciente desde archivo");
            System.out.println("5. Salir");

            System.out.print("\nIngrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Atender paciente con VectorHeap
                    atenderPacienteVectorHeap(colaPacientesVectorHeap);
                    break;
                case 2:
                    // Atender paciente con Java Collections
                    atenderPacienteJavaCollections(colaPacientesJC);
                    break;
                case 3:
                    // Agregar paciente
                    agregarNuevoPaciente(colaPacientesVectorHeap, scanner);
                    break;
                case 4:
                    // Atender paciente desde archivo
                    atenderPacienteDesdeArchivo(colaPacientesVectorHeap, scanner);
                    break;
                case 5:
                    // Salir
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void atenderPacienteVectorHeap(VectorHeap<Paciente> colaPacientes) {
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

    private static void atenderPacienteJavaCollections(PriorityQueue<Paciente> colaPacientes) {
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

    private static void atenderPacienteDesdeArchivo(VectorHeap<Paciente> colaPacientes, Scanner scanner) {
        System.out.println("Ingrese el nombre del archivo de pacientes:");
        String nombreArchivo = scanner.nextLine();

        LeerArchivo lector = new LeerArchivo();
        List<String> lineas = lector.leerArchivo(nombreArchivo);

        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length == 3) {
                String nombre = partes[0];
                String condicion = partes[1];
                String prioridad = partes[2];

                Paciente paciente = new Paciente(nombre, condicion, prioridad);
                colaPacientes.add(paciente);
                System.out.println("Paciente agregado desde archivo: " + paciente);
            } else {
                System.out.println("Formato incorrecto en la línea: " + linea);
            }
        }
    }
}
