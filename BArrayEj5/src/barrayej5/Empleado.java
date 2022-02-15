package barrayej5;

import inputs.EntradaTextos;
import objects.Fecha;

/**
 *
 * @author dam
 */
public class Empleado {

    private String nombre;
    private Fecha fechaAlta;
    private Fecha[] hijos;

    public Empleado() {
    }

    /**
     * Graba la información del empleado
     *
     * @param nombre
     * @param fechaAlta
     */
    public void setInfo(String nombre, Fecha fechaAlta) {
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }

    /**
     * Introduce los hijos de un empleado
     *
     * @param numHijos Se introduce el numero que tiene el empleado
     */
    public void setHijos(int numHijos) {
        this.hijos = new Fecha[numHijos];
        for (int i=0;i<hijos.length;i++) {
            hijos[i] = EntradaTextos.inputFechaPasada("Introduce la fecha de nacimiento del hijo "+(i+1)+": ");
        }
    }

    /**
     *
     * @return Devuelve el número de hijos menores de 18
     */
    public int numHijosLess18() {
        int numHijos = 0;
        for (Fecha i : hijos) {
            if (Fecha.calcularEnios(i, 18) == 0) {
                numHijos++;
            }
        }
        return numHijos;
    }

    /**
     *
     * @return Devuelve el número de hijos mayores de 18
     */
    public int numHijosGreat18() {
        int numHijos = 0;
        for (Fecha i : hijos) {
            if (Fecha.calcularEnios(i, 18) != 0) {
                numHijos++;
            }
        }
        return numHijos;
    }

    /**
     * Devuele la cantidad de hijos del empleado
     *
     * @return
     */
    public int numHijos() {
        int numHijos = 0;
        if (hijos.length > 0) {
            numHijos = hijos.length;
        }
        return numHijos;

    }

    public String fechaHijoZero(){
        String fecha="";
        if(hijos.length!=0){
            fecha=hijos[0].stringFecha();
        }
        return fecha;
    }
    
    public String fechaHijosResto(){
        String fechas="";
        for(int i=1;i<hijos.length;i++){
            fechas=fechas+"\n\t\t\t"+hijos[i].stringFecha();
        }
        
        return fechas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public Fecha[] getHijos() {
        return hijos;
    }

}
