/*****************************************************
 Vista.java                     Autor: Javier Mombiela
                                Carne:           20067
                                Seccion:            21
                                        Fecha: 09/2020
Esta clase es la que interactua con el usuario, esta 
clase tiene todos los sysouts y los inputs, y recibe 
informacion de la clase Driver.
 ****************************************************/

 //importando clases externas
 import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Vista { //creando la clase vista

    //instanciando clases
    private static Scanner scan = new Scanner(System.in);

    //creando variables
    private static String nombre_mayus = "";

    public Vista() { //creando el constructor

    }

    //metodo para iniciar el juego y para que el jugador escoja que tipo de jugador quiere ser
    public static String[] escogerJugador() { 

        //mensaje de bienvenida y opciones iniciales
        System.out.println("\n\n-----BIENVENIDO A CALL OF BOOTY----- \nLas reglas son sencillas. \nUsted peleara con un numero aleatorio de enemigos y el juego termina cuando usted acabe con todos los enemigos o cuando ellos acaben con usted.\nBuena suerte!\n");
        System.out.println("PRIMERO, DEBES INGRESAR TU NOMBRE!");
        String nombre = scan.nextLine(); //guardando el nombre del jugador
        nombre_mayus = nombre.toUpperCase(); // haciendo todas las letras del nombre mayusculas

        //pediendo que rol quiere y explicando las diferencias
        System.out.println("\nEXCELENTE! " + nombre_mayus + ", AHORA ESCOGE TU ROL!\n");
        System.out.println("(1) GUERRERO!\n\t-300 HITPOINTS!\n\t-80 DE ATAQUE!\n\t-1 ESPACIO PARA ITEM!");
        System.out.println("(2) EXPLORADOR!\n\t-150 HITPOINTS!\n\t-60 DE ATAQUE!\n\t-2 ESPACIOS PARA ITEMS!");
        System.out.println("(3) SALIR DEL JUEGO!\n\t-SERAS UN PERDEDOR!\n");

        int opcion;
        //Ciclo while para obtener la opción ingresada por el usuario, siendo protegido por try-catch. 
        while(true){
            try{
                System.out.print("OPCION: ");
                opcion = scan.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion > 3 || opcion < 1){
                    System.out.println("APRENDE A CONTAR! HAZLO DE NUEVO...");
                }
                //Si el usuario ingresa los datos correctos terminará el ciclo while
                else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error. 
            catch(Exception o){
                scan.nextLine();
                System.out.println("APRENDE A DIFERENCIAR ENTRE LETRAS Y NUMEROS! HAZLO DE NUEVO...");
            }
        }

        String queRol="";
        //if para seguir dependiendo de la opcion esocgida
        if(opcion==1) {
            System.out.println("\n"+ nombre_mayus + ", AHORA ERES UN(A) GUERRERO/A!\n");
            queRol = "GUERRERO";
        }
        if(opcion==2) {
            System.out.println("\n"+ nombre_mayus + ", AHORA ERES UN(A) EXPLORADOR(A)!\n");
            queRol = "EXPLORADOR";
        }
        //saliendo del programa
        if(opcion==3){ 
            System.out.println("\nAHORA ERES UN(A) PERDEDOR(A), NO VUELVAS!\n\n");
            System.exit(0);
        }

        //creando un array y agregando el nombre y el rol del jugador
        String[] jugador = {nombre_mayus, queRol}; 

        return jugador;

    }

    //metodo para definir el jugador y los enemigos
    public static void definirPersonajes(Jugador jug, ArrayList<Enemigos> en) {

        //if para ver si el jugador es explorador o guerrero y asi poder imprimir sus datos
        if(jug.items.size() == 1) {

            System.out.println("\n~~~~~[DATOS DEL GUERRERO]~~~~~");
            System.out.println(jug.toString() + "\n"); //imprimiendo el toString del jugador

        } else if(jug.items.size() == 2) { 

            System.out.println("\n~~~~~[DATOS DEL EXPLORADOR]~~~~~");
            System.out.println(jug.toString() + "\n"); //imprimiendo el toString del jugador

        }

        //imprimiendo los datos de los enemigos creados
        System.out.println("~~~~~[ENEMIGO(S) A VENCER]~~~~~");
        //for para crear la cantidad de enemigos correctos
        for(int i = 0; i<en.size(); i++) {

            System.out.println("-ENEMIGO "+ (i+1) + "-" + en.get(i).toString() + "\n"); //imprimiendo el toString de los enemigos

        }

        System.out.println("~~~~~[ES HORA DE PELEAR!]~~~~~\n");

    }

    //metodo para ver de quien es el turno
    public static int turnoJugador(boolean esUsuario) {

        
        // empezando el turno del jugador
        if(esUsuario) {

            System.out.println("\nES EL TURNO DE " + nombre_mayus + "!");

        } else{

            System.out.println("\nES EL TURNO DEL ENEMIGO!");
        }


        //opciones del turno
        System.out.println("\nQUE DESEAS HACER EN TU TURNO?");
        System.out.println("(1) ATACAR!");
        System.out.println("(2) PASAR!");
        System.out.println("(3) ITEM/HABILIDAD!\n");

        int opcion;
        //Ciclo while para obtener la opción ingresada por el usuario, siendo protegido por try-catch. 
        while(true){
            try{
                System.out.print("OPCION: ");
                opcion = scan.nextInt();
                //(Programación defensiva)
                //Protección por si el usuario elige un número menor a uno o mayor a dos, seguirá pidiendo la opción. 
                if(opcion > 3 || opcion < 1){
                    System.out.println("APRENDE A CONTAR! HAZLO DE NUEVO...");
                }
                //Si el usuario ingresa los datos correctos terminará el ciclo while
                else{break;}
            }
            //Si el usuario ingresa una letra regresará un mensaje de error. 
            catch(Exception o){
                scan.nextLine();
                System.out.println("APRENDE A DIFERENCIAR ENTRE LETRAS Y NUMEROS! HAZLO DE NUEVO...");
            }
        }

        return opcion;

    }

    //metodo para ver los enemigos disponibles para poder atacar   
    public static int mostrarEnemigos(ArrayList<Enemigos> listaEnemigos) {

        System.out.println("ELIGE EL ENEMIGO AL QUE QUIERES ATACAR!\n");

        //foreach para obtener el nombre de los enemigos y sus posiciones
        for (Enemigos enemigos : listaEnemigos) {
            System.out.println((listaEnemigos.indexOf(enemigos) + 1) + " " + enemigos.getNombre());
        }
        
        System.out.println("\n");
        return scan.nextInt() - 1;

    }

    public static void pasarTurno(boolean esUsuario) { //metodo para el la opcionn de pasar turno

        //if para ver quien ha pasado el turno y retornar el mensaje
        if(esUsuario) {

            System.out.println("\nEL ENEMIGO HA PASADO SU TURNO!");

        } else {

            System.out.println("\n" + nombre_mayus + " HA PASADO SU TURNO!");            

        }


    }

    //metodo para ver quien gana el turno
    public static void quienGana() {

    }

    //metodo para ver quien pierde el turno
    public static void quienPierde() {

    }

    //metodo para ver como va la vida de los jugadores
    public static void vidaJugador() {
        
    }

    
}
