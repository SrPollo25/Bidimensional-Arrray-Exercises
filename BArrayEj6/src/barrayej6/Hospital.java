/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barrayej6;

import inputs.EntradaNumeros;
import inputs.EntradaTextos;

/**
 *
 * @author dam
 */
public class Hospital {

    Proyecto[] proyectos;
    Sanitario[] sanitarios;
    int[][] importeArticulos;
    Categoria[] categorias;
    float[][] irpf;
    int[] hastaImporteB;
    String[] situaciones;

    public Hospital() {
        generateTables();
    }

    private void generateTables() {
        proyectos = new Proyecto[]{
            new Proyecto("COVID-19", "20/2/2020", 10000),
            new Proyecto("ENFERMEDADES RARAS", "15/4/2017", 4500),
            new Proyecto("SIFILIS", "28/2/2019", 5500),//30/2/2019 no existe
            new Proyecto("BIOQUIMICA", "15/8/2020", 6000)
        };

        situaciones = new String[]{"Soltero", "Casado", "Otros", "Es complicado"};

        importeArticulos = new int[][]{
            {20, 1500},
            {40, 1800},
            {50, 3000},
            {Integer.MAX_VALUE, 4300}
        };

        categorias = new Categoria[]{
            new Categoria("Medico", 1500),
            new Categoria("Enfermero", 1000),
            new Categoria("Auxiliar Clinico", 500)
        };

        irpf = new float[][]{
            {12, 15, 20, 25},
            {10, 14, 16, 18},
            {5, 7, 10, 15}
        };

        hastaImporteB = new int[]{3000, 5000, 10000, Integer.MAX_VALUE};
    }

    public void dataInput() {
        int categoria, proyectoAdherido, situacionPersonal, personalProyecto;
        String nombre;
        int totalPersonal = 0;

        printProyectos();
        for (int i = 0; i < proyectos.length; i++) {
            personalProyecto = EntradaNumeros.numIntBetween("Sanitarios en el proyecto " + proyectos[i].getDenominacion(), 0, 100);
            totalPersonal += personalProyecto;
            proyectos[i].setParticipantes(personalProyecto);
        }
        if (totalPersonal != 0) {
            sanitarios = new Sanitario[totalPersonal];
            
            printSituacionPersonal();
            printCategorias();
        }
    }

    //"INTERFACE" PRINTS
    private void printProyectos() {
        System.out.println("\n\t\tPROYECTOS EN CURSO\n"
                + "DENOMINACION\t\tFECHA DE INICIO\tIMPORTE ANUAL");
        for (Proyecto i : proyectos) {
            System.out.println(i.getDenominacion() + "\t\t" + i.getFechaComienzo().stringFecha() + "\t" + i.getImporteAnual());
        }
    }

    private void printSituacionPersonal() {
        System.out.println("\nSituaciones personal:");
        for (int i = 0; i < this.situaciones.length; i++) {
            System.out.println((i + 1) + ". " + this.situaciones[i]);
        }
    }

    private void printCategorias() {
        System.out.println("\nCategorias");
        for (int i = 0; i < this.categorias.length; i++) {
            System.out.println((i + 1) + ". " + this.categorias[i].getDenominacion());
        }
    }

}
