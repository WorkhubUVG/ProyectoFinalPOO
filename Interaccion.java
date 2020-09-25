import java.util.Scanner;

public class Interaccion {
    
    private static Scanner inputUsuario = new Scanner(System.in);

    //Método para el menú de inicio de seción
    public static boolean MenuInicio(){
        //Se imprime un mensaje donde se le pide al usuario que seleccione una opción. (Inicio de seción o registrarse). 
        System.out.println("\nBienvenido a WorkHub, porfavor elige una opcion:\n");
        System.out.println  ("[ 1 ] Iniciar Sesion");
        System.out.println  ("[ 2 ] Registrarme\n");
        int opcion;
        //Ciclo while para obtener la opción ingresada por el usuario, siendo protegido por try-catch. 
        while(true){
            try{
                System.out.print("Opcion: ");
                opcion = inputUsuario.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion > 2 || opcion < 1){
                    System.out.println("Opcion incorrecta, intenta de nuevo..");
                }
                //Si el usuario ingresa los datos correctos terminará el ciclo while
                else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error. 
            catch(Exception o){
                inputUsuario.nextLine();
                System.out.println("Caracter invalido! Intenta de nuevo..");
            }
        }
        
        //Si se completa el ciclo while y la opción es uno retornará un true, de otro modo retornará false. 
        if(opcion == 1){return true;}
        else{return false;}

    }

    //Método para comprobar si es usuario o empresa. 
    public static String nombreUsuario(boolean esUsuario){
        //Si es usuario le pedirá el nombre de usuario
        if(esUsuario){
            System.out.print("\nIngrese su nombre de usuario: ");
            //Scanner sc = new Scanner(System.in);
            return inputUsuario.nextLine();
        }
        //Si es empresa le pedirá el nombre de empresa
        else{
            System.out.print("\nIngrese el nombre de empresa: ");
            //Scanner sc = new Scanner(System.in);
            return inputUsuario.nextLine();
        }
        //Dependiendo si es usuario y empresa, retornará el respectivo nombre. 
    }
    //Método para pedirle una clave al usuario. 
    public static String claveUsuario(){
        System.out.print("Ingrese su clave: ");
        //Scanner sc = new Scanner(System.in);
        return inputUsuario.nextLine();
    }
    //Método para comprobar si el la persona es un usuario o una empresa. 
    public static boolean usuario_empresa(){
        System.out.println("\nIngrese el tipo de usuario:");
        System.out.println("\n[ 1 ] Usuario");
        System.out.println("[ 2 ] Empresa\n");
        int opcion;
        //Ciclo while para pedirle a la persona una de las opciones del menú.
        //Mientras que la persona no ingrese los datos correctos permanecerá en el while.
        while(true){
            try{
                System.out.print("Opcion: ");
                opcion = inputUsuario.nextInt();
                inputUsuario.nextLine();
                //Condicional para proteger que el usuario no ingrese un número mayor a dos o menor a uno. 
                if(opcion > 2 || opcion < 1){
                    //Mensaje de error si los números no son 1 o 2
                    System.out.println("Opcion incorrecta, intenta de nuevo..");
                }
                //Si se ingresan los números correctos termina el ciclo while.
                else{break;}
            }
            //Si se ingresa un caractér no numérico imprimirá un mensaje de error.
            catch(Exception o){
                inputUsuario.nextLine();
                System.out.println("Caracter invalido! Intenta de nuevo..");
            }
        }
        //Si la opción es 1 el método retorna true, de lo contrario regresa false. 
        if(opcion == 1){return true;}
        else{return false;}
    }

    public static void mostrarErrorInicioSesion(boolean esUsuario){
        if(esUsuario){
            System.out.println("El nombre de usuario o clave son incorrectos!");
        }
        else{ System.out.println("El nombre de la empresa o la clave son incorrectas!"); }
    }
    public static void InicioSesionCorrecto(String nombreEntidad, String correoEntidad, boolean esUsuario){
        if(esUsuario){
            System.out.println("\n>> Se ha iniciado sesion de usuario como " + nombreEntidad + " con asociacion al correo: " + correoEntidad+"\n");
        }
        else{
            System.out.println("\n>> Se ha iniciado sesion de empresa como " + nombreEntidad + " con asociacion al correo: " + correoEntidad+"\n");
        }
    }
    public static void imprimirBandejaEntrada(boolean esUltimo){
        if(esUltimo == false){ System.out.println("Bandeja de correos:\n"); }
        else{System.out.println(" ");}
        
    }
    public static void ImprimirCorreos(String correo, int posicion){
        if(posicion == 0){ imprimirBandejaEntrada(false); }
        System.out.println(correo);
    }
    public static void sinCorreos(){
        System.out.println("No se han encontrado correos.");
    }
    public static void errorDeInstancia(){
        System.out.println("Ocurrio un error durante el inicio de sesion, porfavor intentelo de nuevo.");
    }
    
}
