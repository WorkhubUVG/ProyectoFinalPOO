//importando la clase Scnanner
import java.util.Scanner;


public class WorkHub { 
    
    public static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
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

            boolean opcion = false;

            while(opcion == false){
                try{
                    System.out.print("\n Opcion --> ");
                    op = scan.nextInt();
                    if(op<1 || op>2){
                        System.out.println("\n\t ! Ingrese valores entre 1 y 2 !\n");
                    }else{
                        opcion = true;
                    }
    
                }catch(Exception e){
                    System.out.println("\n\t ! Ingrese valores numericos !\n");
                    scan.nextLine();
                }
            }
            clear();

            
            salir = true;
            
            
            
        }
    } 
}