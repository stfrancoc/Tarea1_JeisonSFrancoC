package Analizadores;
import java.io.*;
public class Analizador {
    private String ruta;
    private int contador = 0;
    private String textoSalida = "";

    private String palabra;

    private String[] extensionesPermitidas = {".txt",".xml",".json",".csv"};

    public Analizador(String ruta,String palabra){
        this.ruta = ruta;
        this.palabra = palabra;
    }

    public String Archivos(){
        try {
            File carpeta = new File(this.ruta);
            File[] archivos = carpeta.listFiles();

            if(archivos != null){
                int contarSin = 0;
                for(File archivo : archivos){
                    if(archivo.isFile()){

                        String nombreArchivo = archivo.getName();
                        String extension = nombreArchivo.substring(nombreArchivo.lastIndexOf("."));
                        String temporalString = "";
                        int temporalContador = 0;
                        int contarSino = 0;


                        for(String extensionPermitida : this.extensionesPermitidas){
                            if (extension.equalsIgnoreCase(extensionPermitida)){

                                FileInputStream archivoEntrada = new FileInputStream(archivo);
                                BufferedReader lector = new BufferedReader(new InputStreamReader(archivoEntrada));

                                String linea;

                                while ((linea = lector.readLine()) != null){
                                    String[] lineaSplit = linea.split("[,(\\s]+");
                                    for (String lineaS : lineaSplit){
                                        if (lineaS.equals(this.palabra)) {
                                            temporalContador++;
                                        }
                                    }
                                }
                                temporalString = nombreArchivo + " " + temporalContador + " veces" + "\n";
                                break;
                            }
                            else {
                                contarSino++;
                            }
                        }
                        this.contador += temporalContador;
                        this.textoSalida += temporalString;
                        if (contarSino == 4){
                            contarSin++;
                        }
                    }
                }
                if(contarSin == archivos.length){
                    return "La carpeta no contiene ningun archivo de texto valido";
                }
                else {
                    String tempoString = "total: " + this.contador;
                    this.textoSalida += tempoString;
                }
            }
            else{
                System.out.println("La carpeta indicada no se ha encontrado");
            }
        }
        catch (Exception e){
            return "La carpeta indicada no se ha encontrado";
        }
        return this.textoSalida;
    }
}
