/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiador;

import java.util.ArrayList;

/**
 *
 * @author Gerardo
 */
public class Compiador {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        AnalizadorLexiico aL = new AnalizadorLexiico();
        //Se crea una lista de objeto "table" para recopilar la informacion del alanisis Lexico
        ArrayList<tabla> table = new ArrayList<>();
        table = aL.analizar();
        // La clase tabla tiene una funcion estatica para imprimir una lista
        // la cual debe estar formada por ArrayList<tabla>
        tabla.PrintTabla(table);
        
        System.out.println("mierdaaaaaaaaaaaaaaaa");
        
        ArrayList<String> codigo = new ArrayList<>();
        for (int i = 0; i < table.size(); i++) {
            codigo.add(i, table.get(i).contenido);
        }
        //System.out.println(table.get(0).contenido);
        AnalizadorSintactico aS = new AnalizadorSintactico();
        
        aS.analisis(codigo);
        
        
    }
    
}
