//importando la clase Scnanner
import java.util.Scanner;

public class WorkHub { //creando la clase  driver
    public static void main(String []args){ // creando el meotodo main para interactuar con el usuario

        //instanciando las clases
        Scanner scan = new Scanner(System.in);
        usuario usuario;
        empresa empersa;
        almacen almacen = new almacen();
 
        //empezando la simulacion
        System.out.println("--------------Bienvenido a WorkHub------------------");

        boolean salir = false;
        int op = 0;
        String nombre = "";
        String contra = "";
        String conContra = "";
        
        //ciclo para el inicio del programa
        while(salir==false){

            //inicio de sesion o crear usuario.
            System.out.println("\n [1] Iniciar sesion.");
            System.out.println("\n [2] Registrarse");
            
        }
    } 
}