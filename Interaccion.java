import java.util.Scanner;

public class Interaccion {
    
    private static Scanner inputUsuario = new Scanner(System.in);

    public static boolean MenuInicio(){

        System.out.println("\nBienvenido a WorkHub, porfavor elige una opcion:\n");
        System.out.println  ("[ 1 ] Iniciar Sesion");
        System.out.println  ("[ 2 ] Registrarme\n");
        int opcion;
        while(true){
            try{
                System.out.print("Opcion: ");
                opcion = inputUsuario.nextInt();
                if(opcion > 2 || opcion < 1){
                    System.out.println("Opcion incorrecta, intenta de nuevo..");
                }
                else{break;}
            }
            catch(Exception o){
                inputUsuario.nextLine();
                System.out.println("Caracter invalido! Intenta de nuevo..");
            }
        }
        if(opcion == 1){return true;}
        else{return false;}

    }
    public static String nombreUsuario(boolean esUsuario){
        if(esUsuario){
            System.out.print("Ingrese su nombre de usuario: ");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }
        else{
            System.out.print("Ingrese el nombre de empresa: ");
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }
    }
    public static String claveUsuario(){
        System.out.print("Ingrese su clave: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    
}
