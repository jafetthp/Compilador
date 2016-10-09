/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiador;

import java.util.ArrayList;

/**
 *
 * @author luis.hurtado
 */
public class tabla {
    public String contenido,tipo;
        
    tabla(String cont, String tipo){
        contenido = cont;
        this.tipo = tipo;            
    }

    @Override
    public String toString(){
        return("| "+contenido+" | "+tipo+" |");
    }
    
    public static void PrintTabla(ArrayList<tabla> ta){
        //Imprimir toda la tabla
        System.out.println("\n");
        System.out.println("--------- Tabla Generada ----------");
        for(tabla t : ta){
            System.out.println(t);
        }
    }
        
}
