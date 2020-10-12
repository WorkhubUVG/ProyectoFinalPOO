/*****************************************************
 Driver.java                    Autor: Javier Mombiela
                                Carne:           20067
                                Seccion:            21
                                        Fecha: 09/2020
Esta clase es la que controla el programa, recibe 
informacion de las clases y las manda a la clase 
vista.
 ****************************************************/

 //importando clases externas
 import java.util.ArrayList;

public class Driver { //creando la clase Driver

    public static void main(String[] args) { //creando el metodo main
        
        //guardando el array de Vista con una variable
        String[] jugador = Vista.escogerJugador();

        //instanciando clase pelear y a la vez enviando los datos de vista a la clase pelear
        Pelear pel = new Pelear(jugador[0], jugador[1]);

        //creando instancias de las clases heredadas
        Jugador jug = pel.getJugador();
        ArrayList<Enemigos> en = pel.getEnemigos();

        //imprimir a los personajes ya definidos
        Vista.definirPersonajes(jug, en);

        //(--empezando ciclo de batalla--)

        //creando variables para la siumlacion
        boolean vivo           = true;
        boolean turnoJugador   = true;
        int hitpoints_enemigos = 0;

        while(vivo) { // empezando while loop para ver los turnos

            if(turnoJugador) { // if para que los turnos vayan rotando

                turnoJugador = false;

                //switch para ver que opcion eligio el jugador
                switch(Vista.turnoJugador(true)) {
                
                case 1: 
                en.get(Vista.mostrarEnemigos(en)).Hitpoints -= jug.Ataque; //quitandole vida al enemigo

                System.out.println("\n" + jugador[0] + " LE HA HECHO " + jug.Ataque + " DE DAÑO AL ENEMIGO.\n");

                for (Enemigos enemigos : en) { //foreach para ver la vida de los jugadores

                    System.out.println("LA NUEVA VIDA DEL ENEMIGO ES: " + enemigos.Hitpoints);
                    
                }

                break;

                case 2: 
                Vista.pasarTurno(turnoJugador); //llamando el metodo que tiene el mensaje de pasar turno

                break;

                case 3:

                System.out.println(en.get(Vista.mostrarEnemigos(en)).Hitpoints);

                break;
                    
                }

            } else { //switch para que sea el turno del enemigo

                turnoJugador = true;

                switch(Vista.turnoJugador(false)) {
                
                case 1:
                jug.Hitpoints -= en.get(Vista.mostrarEnemigos(en)).Hitpoints; //quitandole vida al jugador

                System.out.println("\nEl LE HA HECHO " + en.get(Vista.mostrarEnemigos(en)).Hitpoints + " DE DAÑO A " + jugador[0] + ".\n");
                System.out.println("LA NUEVA VIDA DE " + jugador[0] + " ES: " + jug.Hitpoints);

                break;

                case 2:
                Vista.pasarTurno(turnoJugador); //llamando el metodo que tiene el mensaje de pasar turno  

                break;

                case 3:
                break;
                    
                }

            }

            //creando if para ver la vida de los jugdores y termianr simulacion si es necesario
            if(jug.Hitpoints <= 0) {

                System.out.println("LOS ENEMIGOS HAN GANADO EL JUEGO!\n");
                vivo = false; //cambiar variable a false para que termine la simulacion

            } else if(jug.Hitpoints <= 0) {

                System.out.println(jugador[0] + " HA GANADO EL JUEGO!\n");
                vivo = false; //cambiar variable a false para que termine la simulacion

            }
            

        }

    }
    
}
