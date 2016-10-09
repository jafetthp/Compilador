
package compiador;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizadorSintactico {
    
    void analisis(ArrayList<String> codigo){
        Pattern pat;// = Pattern.compile("^[^\\d].*");
        Matcher mat;// = pat.matcher(codigo.get(i));
        
        for (int i = 0; i < codigo.size(); i++) {
            //validacion if
            if (codigo.get(i).equals("#include")) {
                if (codigo.get(i+1).equals("<")) {
                    if (codigo.get(i+2).equals("iostream") || codigo.get(i+2).equals("conio.h")
                            || codigo.get(i+2).equals("stdio.h")|| codigo.get(i+2).equals("stdlib.h")
                            || codigo.get(i+2).equals("math.h")) {
                        if (codigo.get(i+3).equals(">")) {
                            System.out.println("Declaracion de libreria: correcta");
                        }
                    }
                }
            }
            //validacion using namespace std
            if (codigo.get(i).equals("using")) {
                if (codigo.get(i+1).equals("namespace")) {
                    if (codigo.get(i+2).equals("std")) {
                        if (codigo.get(i+3).equals(";")) {
                            System.out.println("Declaracion de using namespace std: correcta");
                        }
                    }
                }
            }
            //validacion de variable
            if (codigo.get(i).equals("char") || codigo.get(i).equals("int")||codigo.get(i).equals("float")
                    ||codigo.get(i).equals("string")||codigo.get(i).equals("double")) {
                pat = Pattern.compile("^[^\\d].*");
                String palabra = codigo.get(i+1);
                mat = pat.matcher(palabra);
                boolean paso;
                if (mat.matches()) {
                    paso = true;
                } else {
                    paso = false;
                    System.out.println("Declaracion de variable: incorrecta");
                }
                if (paso == true) {
                    if (codigo.get(i+2).equals(";")) {
                        System.out.println("Declaracion de variable: correcta");
                    }
                }
            }
            //validacion if
            if (codigo.get(i).equals("if")) {
                if (codigo.get(i+1).equals("(")) {
                    pat = Pattern.compile("^[^\\d].*");  
                    String palabra = codigo.get(i+2);
                    mat = pat.matcher(palabra);
                    boolean paso;
                    if (mat.matches()) {
                        paso = true;
                    } else {
                        paso = false;
                    }
                    if (paso == true) {
                        if (codigo.get(i+3).equals("==")||codigo.get(i+3).equals("<")||codigo.get(i+3).equals(">")||
                                codigo.get(i+3).equals("<=")||codigo.get(i+3).equals(">=") || codigo.get(i+3).equals("!=")) {
                            pat = Pattern.compile("\\d");  
                            palabra = codigo.get(i+4);
                            mat = pat.matcher(palabra);
                            if (mat.matches()) {
                                paso = true;
                            } else {
                                paso = false;
                            }
                            if (paso == true) {
                                if (codigo.get(i+5).equals(")")) {
                                    System.out.println("Declaracion de if: correcta");
                                }
                            }
                        }
                    }
                }
            }
            //validacion while
            if (codigo.get(i).equals("while")) {
                if (codigo.get(i+1).equals("(")) {
                    pat = Pattern.compile("^[^\\d].*");  
                    String palabra = codigo.get(i+2);
                    mat = pat.matcher(palabra);
                    boolean paso;
                    if (mat.matches()) {
                        paso = true;
                    } else {
                        paso = false;
                    }
                    if (paso == true) {
                        if (codigo.get(i+3).equals("==")||codigo.get(i+3).equals("<")||codigo.get(i+3).equals(">")||
                                codigo.get(i+3).equals("<=")||codigo.get(i+3).equals(">=") || codigo.get(i+3).equals("!=")) {
                            pat = Pattern.compile("\\d");  
                            palabra = codigo.get(i+4);
                            mat = pat.matcher(palabra);
                            if (mat.matches()) {
                                paso = true;
                            } else {
                                paso = false;
                            }
                            if (paso == true) {
                                if (codigo.get(i+5).equals(")")) {
                                    System.out.println("Declaracion de while: correcta");
                                }
                            }
                        }
                    }
                }
            }
            //validacion for
            pat = Pattern.compile("^[^\\d].*");            
            if (codigo.get(i).equals("for")) {
                if (codigo.get(i+1).equals("(")) {
                    String palabra = codigo.get(i+2);
                    mat = pat.matcher(palabra);
                    boolean paso;
                    if (mat.matches()) {
                        paso = true;
                    } else {
                        paso = false;
                    }
                    if (codigo.get(i+2).equals("int")||codigo.get(i+2).equals("char")||codigo.get(i+2).equals("float")||
                            codigo.get(i+2).equals("string")||codigo.get(i+2).equals("double") || paso == true) {
                        if (codigo.get(i+3).equals("=")||codigo.get(i+3).equals("<")||codigo.get(i+3).equals(">")||
                                codigo.get(i+3).equals("<=")||codigo.get(i+3).equals(">=")) {
                            pat = Pattern.compile("\\d");
                            palabra = codigo.get(i+4);
                            mat = pat.matcher(palabra);
                            paso = false;
                            if (mat.matches()) {
                                paso = true;
                            } else {
                                paso = false;
                            }
                            if (paso == true ) {
                                if (codigo.get(i+5).equals(";")) {
                                    pat = Pattern.compile("^[^\\d].*");
                                    palabra = codigo.get(i+6);
                                    mat = pat.matcher(palabra);
                                    if (mat.matches()) {
                                        paso = true;
                                    } else {
                                        paso = false;
                                    }
                                    if (paso == true) {
                                        if (codigo.get(i+7).equals("=")||codigo.get(i+7).equals("<")||codigo.get(i+7).equals(">")||
                                codigo.get(i+7).equals("<=")||codigo.get(i+7).equals(">=")) {
                                            pat = Pattern.compile("\\d");
                                            palabra = codigo.get(i+8);
                                            mat = pat.matcher(palabra);
                                            paso = false;
                                            if (mat.matches()) {
                                                paso = true;
                                            } else {
                                                paso = false;
                                            }
                                            if (paso == true) {
                                                if (codigo.get(i+9).equals(";")) {
                                                    pat = Pattern.compile("^[^\\d].*");
                                                    palabra = codigo.get(i+10);
                                                    mat = pat.matcher(palabra);
                                                    if (mat.matches()) {
                                                        paso = true;
                                                    } else {
                                                        paso = false;
                                                    }
                                                    if (paso == true) {
                                                        if (codigo.get(i+11).equals("++")) {
                                                            if (codigo.get(i+12).equals(")")) {
                                                                System.out.println("Declaracion de for: correcta");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }
}