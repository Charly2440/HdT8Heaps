package uvg.edu.gt;

public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private String condicion;
    private String prioridad;

    public Paciente(String n, String c, String p){
        this.nombre = n;
        this.condicion = c;
        this.prioridad = p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Paciente paciente) {
        return prioridad.compareTo(paciente.getPrioridad());
    }
}
