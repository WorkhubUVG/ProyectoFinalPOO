import java.util.Scanner;

public class Interaccion {
    
    private static Scanner inputUsuario = new Scanner(System.in);
    //Variable para el scanner de la queja. 
    private static Scanner soporte = new Scanner(System.in);

    //Método para el menú de inicio de seción
    public static boolean MenuInicio(){
        //Se imprime un mensaje donde se le pide al usuario que seleccione una opción. (Inicio de seción o registrarse). 
        System.out.println("\nBienvenido a WorkHub, porfavor elige una opcion:\n");
        System.out.println  ("[ 1 ] Iniciar Sesion");
        System.out.println  ("[ 2 ] Registrarme");
        System.out.println  ("[ 3 ] Obtener ayuda.\n");
        int opcion;
        //Ciclo while para obtener la opción ingresada por el usuario, siendo protegido por try-catch. 
        while(true){
            try{
                System.out.print("Opcion: ");
                opcion = inputUsuario.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion > 3 || opcion < 1){
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
        if(opcion==3){ayuda(); Controlador.InicioPrograma();} 
        if(opcion == 1){return true;}
        else{return false;}

    }
    public static void DatosAgregados(boolean correctos){
        if(correctos){
            System.out.println("\n> Su perfil ha sido agregado correctamente a la base de datos, podemos continuar.");
        }
        else{
            System.out.println("\nHubo un error al momento de agregar su perfil, el error puede ser:");
            System.out.println("Nombre del perfil ya en uso.\nCorreo de perfil ya en uso.\nNumero telefonico de perfil ya en uso.");
            System.out.println("Por favor intente ingresar los datos nuevamente o iniciar sesion.");
        }
    }
    //Método para comprobar si es usuario o empresa. 
    public static String nombreUsuario(boolean esUsuario){
        //Si es usuario le pedirá el nombre de usuario
        if(esUsuario){
            String nom;
            while(true){
                System.out.print("\nIngrese su nombre de usuario: ");
                //Scanner sc = new Scanner(System.in);
                nom = inputUsuario.nextLine();
                if(nom.length() != 0){
                    break;
                }
                else{
                    System.out.println("Error en input, intente de nuevo..");
                }
            }
            return nom;
        }
        //Si es empresa le pedirá el nombre de empresa
        else{
            String nom;
            while(true){
                System.out.print("\nIngrese el nombre de empresa: ");
                //Scanner sc = new Scanner(System.in);
                nom = inputUsuario.nextLine();
                if(nom.length() != 0){
                    break;
                }
                else{
                    System.out.println("Error en input, intente de nuevo..");
                }
            }
            return nom;
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

    public static boolean CrearEntidad(){
        System.out.println(">> Creando cuenta, porfavor especifique lo siguiente:");
        System.out.println("\n[ 1 ] Crear usuario");
        System.out.println("[ 2 ] Crear empresa\n");
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
    public static String[] NuevaCreacionNombre(boolean esUsuario){
        String nombre, numero, correo, clave, datoextra1, datoextra2;
        if(esUsuario){
            while(true){
                System.out.print("\n> Ingrese el nombre de usuario  : ");
                //Scanner sc = new Scanner(System.in);
                nombre = inputUsuario.nextLine();
                if(nombre.length() != 0){
                    break;
                }
                else{
                    System.out.println("Error en input, intente de nuevo..");
                }
            }
            while(true){
                System.out.print("> Ingrese su numero de telefono : ");
                numero = inputUsuario.nextLine();
                if(numero.length() != 8){
                    System.out.println("El numero de telefono no es valido (8 numeros), intenta de nuevo..");
                }
                else{
                    boolean esNumeroValido = false;
                    try {
                        Integer.parseInt(numero);
                        esNumeroValido = true;
                    } catch (Exception e) {
                        System.out.println("El numero de telefono contiene caracteres invalidos. Intente de nuevo..");
                    }
                    if(esNumeroValido){ break; }
                    else{ ; }
                
                }
            }
            while(true){
                System.out.print("> Ingrese su correo             : ");
                correo = inputUsuario.nextLine();
                int tieneArroba = 0;
                for(int i = 0; i < correo.length(); i++){
                    if(correo.charAt(i) == '@'){
                        tieneArroba++;
                    }
                }
                if(tieneArroba != 1){
                    System.out.println("El correo carece de una @ o se presentan multiples veces, porfavor intente de nuevo..");
                }
                else{ break; }
            }
            while(true){
                System.out.print("> Ingrese su clave              : ");
                clave = inputUsuario.nextLine();
                System.out.print("> Repita su clave               : ");
                String clave2 = inputUsuario.nextLine();
                if(clave.equals(clave2)){
                    break;
                }
                else{ System.out.println("La clave no coincide, intente de nuevo..");}
            }
        }
        else{
            while(true){
                System.out.print("\n> Ingrese el nombre de la empresa : ");
                //Scanner sc = new Scanner(System.in);
                nombre = inputUsuario.nextLine();
                if(nombre.length() != 0){
                    break;
                }
                else{
                    System.out.println("Error en input, intente de nuevo..");
                }
            }
            while(true){
                System.out.print("> Ingrese el numero de telefono   : ");
                numero = inputUsuario.nextLine();
                if(numero.length() != 8){
                    System.out.println("El numero de telefono no es valido (8 numeros), intenta de nuevo..");
                }
                else{
                    boolean esNumeroValido = false;
                    try {
                        Integer.parseInt(numero);
                        esNumeroValido = true;
                    } catch (Exception e) {
                        System.out.println("El numero de telefono contiene caracteres invalidos. Intente de nuevo..");
                    }
                    if(esNumeroValido){ break; }
                    else{ ; }
                }
            }
            while(true){
                System.out.print("> Ingrese el correo               : ");
                correo = inputUsuario.nextLine();
                int tieneArroba = 0;
                for(int i = 0; i < correo.length(); i++){
                    if(correo.charAt(i) == '@'){
                        tieneArroba++;
                    }
                }
                if(tieneArroba != 1){
                    System.out.println("El correo carece de una @ o se presentan multiples veces, porfavor intente de nuevo..");
                }
                else{ break; }
            }
            while(true){
                System.out.print("> Ingrese la clave                : ");
                clave = inputUsuario.nextLine();
                System.out.print("> Repita la clave                 : ");
                String clave2 = inputUsuario.nextLine();
                if(clave.equals(clave2)){
                    break;
                }
                else{ System.out.println("La clave no coincide, intente de nuevo..");}
            }
        }
        return new String[]{nombre,numero,correo,clave};
    }
    public void enviarCorreo(){

    }
    public static int  MenuPrincipal(Entidad entidad){
        //Pagina de inicio del programa.
        System.out.println("\nElije la accion que quiera realizar:       ");
        System.out.println("\n[ 1 ] Ver correos");
        System.out.println("[ 2 ] Enviar correos");
        System.out.println("[ 3 ] Ver informacion");
        System.out.println("[ 4 ] Salir\n");
        int opcion;

        while(true){
            try{
                System.out.print("Opcion: ");
                opcion = inputUsuario.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion > 4 || opcion < 1){
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


        return opcion;
    }

    public static void nuevoCorreo(Entidad entidad){
        
    }

    public void verInformacion(){

    }
    
    //Problemas. 
    public static void ayuda(){
        
        //Cuerpo. 
        System.out.println("Ingrese el problema que ha tenido.");
       
        //Variable para el soporte.
        String sop; 

        //Recibiendo la queja. 
        sop = soporte.nextLine();
    } 
}