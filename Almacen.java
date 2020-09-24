import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Almacen{

    private static ArrayList<String[]> listaUsuarios = new ArrayList<>();
    private static String[] usuarioElegido;

    private static ArrayList<String[]> listaEmpresas = new ArrayList<>();
    private static String[] empresaElegida;
    public static void revisarUsuarios(){

        try {
            File ArchivoUsuarios = new File("usuariosExistentes.csv");
            Scanner lectorUsuarios = new Scanner(ArchivoUsuarios);
            while(lectorUsuarios.hasNextLine()){
                String datosUsuarioEspecifico = lectorUsuarios.nextLine();
                listaUsuarios.add(datosUsuarioEspecifico.split(","));
            }
            lectorUsuarios.close();
        }
        catch (Exception archivoNoEncontrado){
            ;
        }
    }
    public static void revisarEmpresas(){
        try {
            File ArchivoEmpresas = new File("empresasExistentes.csv");
            Scanner lectorEmpresas = new Scanner(ArchivoEmpresas);
            while(lectorEmpresas.hasNextLine()){
                String datosUsuarioEspecifico = lectorEmpresas.nextLine();
                listaEmpresas.add(datosUsuarioEspecifico.split(","));
            }
            lectorEmpresas.close();
        }
        catch (Exception archivoNoEncontrado){
            ;
        }
    }
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

    public static String[] getUsuarioEncontrado(){
        return usuarioElegido;
    }
    public static String[] getEmpresaEncontrada(){
        return empresaElegida;
    }

    
}
