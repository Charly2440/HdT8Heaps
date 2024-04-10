package uvg.edu.gt;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

public class VectorTest {
    static VectorHeap<Paciente> CreandoVector(){
        Paciente P1 = new Paciente("Juan Perez", "fractura de pierna", "C");
        Paciente P2 = new Paciente("Maria Ramirez", "apendicitis", "A");
        Paciente P3 = new Paciente("Lorenzo Toledo", "chikungunya", "E");
        Paciente P4 = new Paciente("Carmen Sarmientos", "dolores de parto", "B");

        Vector<Paciente> pacientes = new Vector<>();
        pacientes.add(P1);
        pacientes.add(P2);
        pacientes.add(P3);
        pacientes.add(P4);
        VectorHeap<Paciente> heap = new VectorHeap<Paciente>(pacientes);
        return heap;
    }

    @Test
    public void getFirstTest(){
        VectorHeap<Paciente> heap = CreandoVector();
        Assert.assertEquals(heap.getFirst().getNombre(), "Maria Ramirez");
    }
    @Test
    public void removeTest(){
        VectorHeap<Paciente> heap = CreandoVector();
        heap.remove();
        Assert.assertEquals(heap.getFirst().getNombre(), "Carmen Sarmientos");
    }
    @Test
    public void leerArchivo(){
        LeerArchivo lector = new LeerArchivo();
        List<String> lineas = lector.leerArchivo("C:\\Users\\cjvil\\IdeaProjects\\pacientes.txt");
        Vector<Paciente> pacientes = new Vector<>();
        for (String linea : lineas) {
            // Dividir la línea en partes usando la coma como delimitador
            String[] partes = linea.split(",");

            // Crear un paciente con la información de la línea
            if (partes.length == 3) {
                String nombre = partes[0];
                String condicion = partes[1];
                String prioridad = partes[2];

                Paciente paciente = new Paciente(nombre, condicion, prioridad);
                pacientes.add(paciente);
            } else {
                System.out.println("Formato incorrecto en la línea: " + linea);
            }
        }
        VectorHeap<Paciente> heap = new VectorHeap<Paciente>(pacientes);
        Assert.assertEquals(heap.getFirst().getNombre(), "Maria Ramirez");
    }

}
