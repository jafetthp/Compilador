/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


class AnalizadorLexiico {
        
    ArrayList<tabla> lista = new ArrayList();
    
    public ArrayList<tabla> analizar(){
        lectorArchivo aPal = new lectorArchivo("palabras.txt");
        lectorArchivo aOp = new lectorArchivo("operadores.txt");
        lectorArchivo codigo = new lectorArchivo("code.txt");
        lectorArchivo signos = new lectorArchivo("signos.txt");
        try {
            aPal.abrirArchivo();
            aOp.abrirArchivo();
            codigo.abrirArchivo();
            signos.abrirArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Compiador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Tokenizar todo lo encontrado en el codigo y guardarlo en un array de string
        ArrayList<String> todo = new ArrayList();
        
        for(String s : codigo.palabras){
            String aux[] = s.split(" ");
            for(String y : aux){
                todo.add(y);
            }
        }
        
        System.out.println("Codigo Tokenizado: "+todo);
        
        //Crear tabla revisando si es un operador etc...
        
        for(String s : todo){
            // revisar si es operador
            if(s.equals(" ") || s.equals("\n"))
                continue;
            if(aOp.palabras.contains(s))
                lista.add(new tabla(s,"Operador"));
            else if(aPal.palabras.contains(s))
                lista.add(new tabla(s,"Palabra Reservada"));
            else if(signos.palabras.contains(s)){
                lista.add(new tabla(s,"Signo"));
            }
            else{
                lista.add(new tabla(s,"Expresion"));
            }
        }
        
        revisarTextos();
        
        return lista;
    }
    
    void revisarTextos(){
        int sz = lista.size();
        ArrayList<Integer> borrar = new ArrayList();        
        for(int i=0; i<sz;i++){            
            if(lista.get(i).tipo.equals("Expresion")){                
                String s = lista.get(i).contenido;
                if(s.length() > 0 && s.charAt(0) == '"'){
                    //Se detecta que la palabra es un texto
                    System.out.println("Texto detectado: " + s);
                    int j = i;                    
                    boolean go = true;
                    while(go){
                        j++;
                        String s1 = lista.get(j).contenido;
                        int sz2 = s1.length();
                        s = s + " " +s1;
                        borrar.add(j);
                        //Para revisar el cuerre con " necesitamos visitar el ultimo simbolo
                        if(s1.charAt(sz2-1)=='"'){
                            lista.get(i).contenido=s;
                            lista.get(i).tipo="Texto";
                            go = false;
                            i=j+1;
                        }
                    }
                    //Actualizar la tabla borrando los textos intermedios
                    System.out.println("El texto rescatado es:" + s);
                }     
            }
        }
        System.out.println("El array a borrar es: " + borrar);
        
        sz = lista.size();
//        no esta borrando como deberia
//        for(int x=sz-1; x >=0 && sz > 0 ; x--){
//            System.out.print("borre: " + lista.get(borrar.get(x)).contenido+" ");
//            lista.remove(borrar.get(x));
//            System.out.println(borrar.get(x));
//        }
        
//        Metodo de borrado mas lento
        ArrayList<tabla> nuevo = new ArrayList<>();
        for(int i=0; i<sz;i++){
            if(!borrar.contains(i))
                nuevo.add(lista.get(i));
        }
        lista = nuevo;        
    }    
}
