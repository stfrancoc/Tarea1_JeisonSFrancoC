package Analizadores;

import javax.swing.*;

public class Ejecutar {
    public static void main(String[] args) {
        String ruta = JOptionPane.showInputDialog("Ingrese la ruta");
        String palabra = JOptionPane.showInputDialog("Ingrese la palabra");
        //Analizador analizador = new Analizador("C:/Users/jeison Franco/IdeaProjects/Tarea1_JeisonSFrancoC/software1_pruebas/pruebas1","arar");
        Analizador analizador = new Analizador(ruta,palabra);
        System.out.println(analizador.Archivos());
    }
}

