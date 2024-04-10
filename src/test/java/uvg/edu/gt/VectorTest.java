package uvg.edu.gt;

import org.junit.Assert;
import org.junit.Test;

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


}
