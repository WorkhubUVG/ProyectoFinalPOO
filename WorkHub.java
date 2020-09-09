//importando la clase Scnanner
import java.util.Scanner;


public class WorkHub { 
    
    public static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void sesionIniciada(String x){
        if(x.equals("usuario")){
            System.out.println("usuario");
        }else if(x.equals("empresa")){
            System.out.println("empresa");
        }
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
                    System.out.println();
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

            if(op == 1){
                //iniciar sesion.
                System.out.println("\n----------- INICIO DE SESION ------------\n");
                System.out.print("\n Ingrese su nombre --> ");
                nombre = scan.next();
                System.out.println();
                System.out.print("\n Ingrese la contraseña --> ");
                contra = scan.next();
                System.out.println();

                boolean existe = almacen.iniciar_sesion(nombre, contra);
                if(existe == true){
                    sesionIniciada("usuario");
                }else{
                    System.out.println("\n Datos incorrectos! \n");
                }

                
            }else if(op == 2){
                //registrarse.
                System.out.println("\n-------------- REGISTRO ---------------\n");
                System.out.print("\n Ingrese su nombre --> ");
                String n = scan.next();
                System.out.println();

                System.out.print("\n Ingrese su contraseña --> ");
                String c = scan.next();
                System.out.println();

                boolean con = false;
                while(con == false){

                    System.out.print("\n Repita su contraseña --> ");
                    String segundoc = scan.next();
                    System.out.println();

                    if(segundoc.equals(c)){
                        con = true;
                    }else{
                        System.out.println("\n\t ! Contraseña incorrecta, vuelva a intentar !");
                    }

                }

                System.out.print("\n Ingrese su apellido --> ");
                String apellido = scan.next();
                System.out.println();

                System.out.print("\n Ingrese su correo --> ");
                String correo = scan.next();
                System.out.println();

                System.out.print("\n Ingrese su carrera --> ");
                String prof = scan.next();
                System.out.println();

                int edad = 0;
                boolean nu = false;
                while(nu==false){
                    try{
                        System.out.print("\n Ingrese su edad -->");
                        edad = scan.nextInt();
                        System.out.println();
                        nu = true;
                    }catch(Exception e){
                        System.out.println("\n\t ! Ingrese valores numericos ! ");
                        scan.nextLine();
                    }
                    
                }
                

                usuario = new usuario(n, c, apellido, correo, prof, edad);
            }
            //quitar despues
            salir = true;
            
            
            
        }
    } 
}