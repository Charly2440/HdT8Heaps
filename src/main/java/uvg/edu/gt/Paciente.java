package uvg.edu.gt;

/**
 * Esta clase representa a un paciente en un sistema de gestión de hospitales.
 * Cada paciente tiene un nombre, una condición médica y una prioridad asociada.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String condicion;
    private String prioridad;

    /**
     * Constructor de la clase Paciente.
     *
     * @param n el nombre del paciente.
     * @param c la condición médica del paciente.
     * @param p la prioridad del paciente.
     */
    public Paciente(String n, String c, String p) {
        this.nombre = n;
        this.condicion = c;
        this.prioridad = p;
    }

    /**
     * Retorna el nombre del paciente.
     *
     * @return el nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del paciente.
     *
     * @param nombre el nuevo nombre del paciente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la condición médica del paciente.
     *
     * @return la condición médica del paciente.
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * Establece la condición médica del paciente.
     *
     * @param condicion la nueva condición médica del paciente.
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    /**
     * Retorna la prioridad del paciente.
     *
     * @return la prioridad del paciente.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Establece la prioridad del paciente.
     *
     * @param prioridad la nueva prioridad del paciente.
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Compara este paciente con otro paciente basado en su prioridad.
     *
     * @param paciente el paciente con el que se va a comparar.
     * @return un valor negativo si este paciente tiene una prioridad menor que el paciente dado,
     *         cero si ambos pacientes tienen la misma prioridad, o un valor positivo si este paciente
     *         tiene una prioridad mayor que el paciente dado.
     */
    @Override
    public int compareTo(Paciente paciente) {
        return prioridad.compareTo(paciente.getPrioridad());
    }

    /**
     * Retorna una representación en cadena del paciente, que es su nombre.
     *
     * @return una representación en cadena del paciente.
     */
    @Override
    public String toString() {
        return this.nombre;
    }
}
