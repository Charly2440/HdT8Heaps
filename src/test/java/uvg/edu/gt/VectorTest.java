package uvg.edu.gt;

import org.junit.Test;

import java.util.Vector;

public class VectorTest {
    @Test
    public void CreandoVector(){
        Paciente P1 = new Paciente("Diego", "Ruptura", "B");
        Paciente P2 = new Paciente("Daniel", "Dolor de cabeza", "C");
        Paciente P3 = new Paciente("Perdo", "Ruptura", "B");
        Paciente P4 = new Paciente("Juan", "Alergia", "C");
        Paciente P5 = new Paciente("Pepe" ,"Gripe", "C");
        Paciente P6 = new Paciente("Tiago","Asfixia", "A");

        Vector<Paciente> pacientes = new Vector<Paciente>();
        pacientes.add(P1);
        pacientes.add(P2);
        pacientes.add(P3);
        pacientes.add(P4);
        pacientes.add(P5);
        pacientes.add(P6);
        System.out.println(pacientes);
        VectorHeap heap = new VectorHeap(pacientes);
        System.out.println(heap.getFirst());
    }

}
