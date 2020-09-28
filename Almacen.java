import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Almacen{

    // >> Se crean espacios de almacenamiento para guardar temporalmente los datos de Usuario.
    private static ArrayList<String[]> listaUsuarios = new ArrayList<>();
    private static String[] usuarioElegido;

    // >> Se crean espacios de almacenamiento para guardar temporalmente los datos de Empresa.
    private static ArrayList<String[]> listaEmpresas = new ArrayList<>();
    private static String[] empresaElegida;

    // >> Este metodo se encarga de ver si existe el usuario en el archivo de CSV, en el caso de si, se agregaran los usuarios a la ArrayList

    public static void revisarUsuarios(){

        try {
            File ArchivoUsuarios = new File("usuariosExistentes.csv");
            Scanner lectorUsuarios = new Scanner(ArchivoUsuarios);
            while(lectorUsuarios.hasNextLine()){
                String datosUsuarioEspecifico = lectorUsuarios.nextLine();
                listaUsuarios.add(datosUsuarioEspecifico.split(">>"));
            }
            lectorUsuarios.close();
        }
        catch (Exception archivoNoEncontrado){
            ;
        }
    }
    // >> Este metodo se encarga de ver si existen las empresas en el archivo de CSV, en el caso de si, se agregaran las empresas a la ArrayList
    public static void revisarEmpresas(){
        try {
            File ArchivoEmpresas = new File("empresasExistentes.csv");
            Scanner lectorEmpresas = new Scanner(ArchivoEmpresas);
            while(lectorEmpresas.hasNextLine()){
                String datosUsuarioEspecifico = lectorEmpresas.nextLine();
                listaEmpresas.add(datosUsuarioEspecifico.split(">>"));
            }
            lectorEmpresas.close();
        }
        catch (Exception archivoNoEncontrado){
            ;
        }
    }

    // >> Este metodo verifica sin los datos que se pasan desde el controlador son correctos, en el caso de ser asi, este metodo retornara true
    public static boolean verificarDatosUsuario(String nombre, String clave){
        boolean usuarioEncontrado = false;
        for(int posicion = 0; posicion < listaUsuarios.size(); posicion++){
            if(listaUsuarios.get(posicion)[0].equals(nombre) && listaUsuarios.get(posicion)[3].equals(clave)){
                usuarioElegido = listaUsuarios.get(posicion);
                usuarioEncontrado = true;
            }
        }
        return usuarioEncontrado;
    }
    // >> Este metodo verifica sin los datos que se pasan desde el controlador son correctos, en el caso de ser asi, este metodo retornara true
    public static boolean verificarDatosEmpresa(String nombre, String clave){
        boolean empresaEncontrada = false;
        for(int posicion = 0; posicion < listaEmpresas.size(); posicion++){
            if(listaEmpresas.get(posicion)[0].equals(nombre) && listaEmpresas.get(posicion)[3].equals(clave)){
                empresaElegida = listaEmpresas.get(posicion);
                empresaEncontrada = true;
            }
        }
        return empresaEncontrada;
    }

    // Getter de la matriz de usuarioElegido
    public static String[] getUsuarioEncontrado(){
        return usuarioElegido; 
    }
    // Getter de la matriz de empresaElegida
    public static String[] getEmpresaEncontrada(){
        return empresaElegida;
    }

    public static ArrayList<String> revisarCorreosNuevos(String correoElectronico){
        ArrayList<String> correosEncontrados = new ArrayList<>();
        try {
            File Correos = new File("correosExistentes.csv");
            Scanner lectorCorreos = new Scanner(Correos);
            while(lectorCorreos.hasNextLine()){
                String[] correoDividido = lectorCorreos.nextLine().split(">>");
                if(correoDividido[0].equals(correoElectronico)){
                    correosEncontrados.add(correoDividido[1]+ " : " +correoDividido[2]);
                }
            }
            lectorCorreos.close();
        }
        catch (Exception archivoNoEncontrado){
            ;
        }
        return correosEncontrados;
    }

    public static void agregarDatosCSV(boolean esUsuario, String[] datos){

        if(esUsuario){
            try {
                
                File objetoCSV = new File("usuariosExistentes.csv");
                if(objetoCSV.createNewFile()){
                    System.out.println("Archivo creado");
                }
                else{
                   // System.out.println("Archivo existente");
                }

            } catch (Exception e) {
                ;
            }
            try {
                FileWriter escritor = new FileWriter("usuariosExistentes.csv",true);
                escritor.write("\n"+datos[0]+">>"+datos[1]+">>"+datos[2]+">>"+datos[3]);
                escritor.close();

            } catch (Exception e) {
                ;
            }
        }
        else{
            try {
                
                File objetoCSV = new File("empresasExistentes.csv");
                if(objetoCSV.createNewFile()){
                    System.out.println("Archivo creado");
                }
                else{
                    //System.out.println("Archivo existente");
                }

            } catch (Exception e) {
                ;
            }
            try {
                FileWriter escritor = new FileWriter("empresasExistentes.csv",true);
                escritor.write("\n"+datos[0]+">>"+datos[1]+">>"+datos[2]+">>"+datos[3]);
                escritor.close();

            } catch (Exception e) {
                ;
            }
        }
    }
    public static boolean RevDatosEntidad(boolean esUsuario, String[] datosProporcionados){
        if(esUsuario){
            // OBTENEMOS DATOS PREVIOS ALMACENADOS EN EN CSV:
            ArrayList<String[]> datosPreviosAlmacenados = new ArrayList<>();
            try {
                File objetoCSV = new File("usuariosExistentes.csv");
                Scanner archivoCSV = new Scanner(objetoCSV);
                while(archivoCSV.hasNextLine()){
                    datosPreviosAlmacenados.add(archivoCSV.nextLine().split(">>"));
                }
                archivoCSV.close();
            } catch (Exception e) {
                ;
            }
            // VERIFICAMOS QUE LOS DATOS NO ESTEN REPETIDOS:
            
            boolean datoRepetido = false;
            for(int posLista = 0; posLista < datosPreviosAlmacenados.size(); posLista++){
                if(datosPreviosAlmacenados.get(posLista)[0].equals(datosProporcionados[0])){
                    datoRepetido = true;
                }
                if(datosPreviosAlmacenados.get(posLista)[1].equals(datosProporcionados[1])){
                    datoRepetido = true;
                }
                if(datosPreviosAlmacenados.get(posLista)[2].equals(datosProporcionados[2])){
                    datoRepetido = true;
                }
            }
            if(datoRepetido){ return false; }
            else{ return true;}
        }
        else{
            // OBTENEMOS DATOS PREVIOS ALMACENADOS EN EN CSV:
            ArrayList<String[]> datosPreviosAlmacenados = new ArrayList<>();
            try {
                File objetoCSV = new File("empresasExistentes.csv");
                Scanner archivoCSV = new Scanner(objetoCSV);
                while(archivoCSV.hasNextLine()){
                    datosPreviosAlmacenados.add(archivoCSV.nextLine().split(">>"));
                }
                archivoCSV.close();
            } catch (Exception e) {
                ;
            }
            // VERIFICAMOS QUE LOS DATOS NO ESTEN REPETIDOS:
            boolean datoRepetido = false;
            for(int posLista = 0; posLista < datosPreviosAlmacenados.size(); posLista++){
                if(datosPreviosAlmacenados.get(posLista)[0].equals(datosProporcionados[0])){
                    datoRepetido = true;
                }
                if(datosPreviosAlmacenados.get(posLista)[1].equals(datosProporcionados[1])){
                    datoRepetido = true;
                }
                if(datosPreviosAlmacenados.get(posLista)[2].equals(datosProporcionados[2])){
                    datoRepetido = true;
                }
            }
            if(datoRepetido){ return false; }
            else{ return true;}
        }

    }
    
}
