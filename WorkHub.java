//importando la clase Scnanner
import java.util.Scanner;

public class WorkHub { //creando la clase  driver
    public static void main(String []args){ // creando el meotodo main para interactuar con el usuario

        //instanciando las clases
        Scanner scan = new Scanner(System.in);
        usuario usuario;
        almacen almacen = new almacen();
 
        //empezando la simulacion
        System.out.println("--------------Bienvenido a WorkHub------------------");

        boolean numero = false;
        int op = 0;
        String usua = "";
        String contra = "";
        String conContra = "";
        
        //ciclo para el inicio del programa
        while(numero==false){
            
            //Opciones para el usuario.
            System.out.println("\n [1]  Registrarse.");
            System.out.println("\n [2]  Iniciar Sesión.\n");     
            //verificar que es valor numerico.
            try{
                op = scan.nextInt();
                numero = true;
                scan.nextLine();
            //mensaje de alerta.3

            }catch(Exception e){
                System.out.print("\n\t ! Ingrese valores numéricos !  \n");
                scan.nextLine();
            }
            
            if(op == 1){ //registrarse

                //submenu para empresas o empresarios.
                int subop = 0;
                while(subop !=3) {

                    System.out.println("\n [1]  Registrarse como empresa.");
                    System.out.println("\n [2]  Registrarse como empresario.\n");  
                    scan.nextInt();

                    if(subop == 1) { 

                        //Registro como empresa
                        System.out.print("\nIngrese el nombre de su empresa -->");
                        usua = scan.next();
                        System.out.print("\nIngrese su contraseña -->");
                        contra = scan.next();
                        System.out.print("\nConfirme su contraseña -->");
                        conContra = scan.next();

                    } else if(subop == 2) {

                        //Registro como empresario
                        System.out.print("\nIngrese su nombre -->");
                        System.out.print("\nIngrese su apellido -->");
                         
                        System.out.print("\nIngrese su nombre de usuario -->");
                        usua = scan.next();
                        System.out.print("\nIngrese su contraseña -->");
                        contra = scan.next();
                        System.out.print("\nConfirme su contraseña -->");
                        conContra = scan.next();

                    } else {
                        
                        System.out.println("\n\t ! Ingrese un numero entre 1 y 2 !\n");

                    }
                }

            }else if (op == 2){
                
                // >> Iniciar sesion 
                System.out.print("\nIngrese su nombre de usuario -->");
                usua    = scan.next();
                System.out.print("\nIngrese su contraseña -->");
                contra  = scan.next();

            }else{
                System.out.println("\n\t ! Ingrese una opcion valida ! \n");
            }
        }
    } 
}