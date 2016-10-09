/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiador;
    
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class lectorArchivo {
    
    public ArrayList<String> palabras = new ArrayList();
    
    InputStream is;
    InputStreamReader isr;
    FileInputStream fis;
    FileReader fr;
    File file;
    BufferedReader br;
    String nombre;
    
    lectorArchivo(String nombre){
        this.nombre = nombre;
    }

//    lectorArchivo(String[] nombre) {
//        for(int i=0 ; i< nombre.length ; i++){
//            this.nombre = nombre[i];
//        }
//    }
    
    void abrirArchivo() throws IOException{
        
        try {
            file = new File("src/compiador/"+nombre);
            is = new FileInputStream(file);
            isr = new InputStreamReader(is,Charset.forName("UTF-8"));
            br = new BufferedReader(isr);
            
            String linea;
            while((linea = br.readLine()) != null){
                palabras.add(linea);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(lectorArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Leyo: " + palabras);
    }
}
