/*****************************************************
 Pelear.java                    Autor: Javier Mombiela
                                Carne:           20067
                                Seccion:            21
                                        Fecha: 09/2020
Esta clase es la que hara la simulacion de la pelea 
entre el jugador y los enemigos.
 ****************************************************/

//importando clases externas
import java.util.ArrayList;
import java.util.Random;

public class Pelear { //creando la case pelear

    //instanciando clases
    Random rand = new Random();

    //creando variables
    Jugador bueno;
    ArrayList<Enemigos> malos = new ArrayList<>();

    //estas listas se cambiaron de arraylist a array porque era mas facil tener todas las habilidades y los items en Strings
    private String[] items = {"FUSIL" /*el ataque aumento por 15 puntos*/, "BASUCA"/*el ataque aumento por el doble de putnos*/, "ANTIBALAS"/*el ataque causado en el no causa dano*/, "KIT-MEDICO"/*recupera 50 hitpoints*/, "KIT-REVIVIR"/*el jugador puede revivir*/};
    private String[] habilidades = {"MEDICO"/*el enemigo puede recuperar 50 puntos*/, "JUGGERNUT"/*el ataque al enemigo es reducido por el doble*/, "SNIPER"/*el ataque del enemigo hace 20 mas de dano*/, "GHOST"/*el enemigo esquiva un ataque*/, "STUNNER"/*el jugador pierde turno*/};

    
    public Pelear(String nombre, String queRol) { //creando el constructor para recibir datos del jugador

        //creando el jugador en base al rol escogido
        if(queRol.equals("GUERRERO")) { //creando el jugador de tipo guerrero
            //escogiendo un item aleatorio
            int usar = rand.nextInt(items.length);
            bueno = new Jugador(nombre, 300, 80, items[usar]);

        } else if(queRol.equals("EXPLORADOR")) { //creando el jugador de tipo explorador
            //escogiendo 2 items aleatorios
            int usar1 = rand.nextInt(items.length);
            int usar2 = rand.nextInt(items.length);
            bueno = new Jugador(nombre, 150, 60, items[usar1], items[usar2]);
        }

        //creando un numero aleatorio de enemigos
        int cuantos_malos = rand.nextInt(3) + 1;

        //for para crear el numero de enemigos que salgan
        for(int i = 0; i <cuantos_malos; i ++) {

            //creando atributos
            int que_malo = rand.nextInt(4);
            Enemigos malo = new Enemigos();

            // if para ver que tipo de malo sera
            if(que_malo == 0) {
                
                //1. SPETSNAZ: 100 HITPOINTS, 20 DE ATAQUE, 1 HABILIDAD

                //dandole una habilidad aleatoria
                int usar = rand.nextInt(habilidades.length);  
                malo = new Enemigos("SPETSNAZ", 100, 20, habilidades[usar]);

            } else if(que_malo == 1) {

                //2. SPETSNAZ BOSS: 150 HITPOINTS, 40 DE ATAQUE, 2 HABILIDADES

                //dandole sus dos habilidadaes aleatorias
                int usar1 = rand.nextInt(habilidades.length);
                int usar2 = rand.nextInt(habilidades.length);
                malo = new Enemigos("SPETSNAZ BOSS", 150, 40, habilidades[usar1], habilidades[usar2]);

            } else if(que_malo == 2) {

                //3. SEAL: 80 HITPOINTS, 30 DE ATAQUE, 1 HABILIDAD

                //dandole su habilidad aleatoria al seal
                int usar = rand.nextInt(habilidades.length);
                malo = new Enemigos("SEAL", 80, 40, habilidades[usar]);

            } else if(que_malo == 3) {

                //4. SEAL BOSS: 130 HITPOINTS, 55 ATAQUE, 2 HABILIDADES

                //dandole sus dos habilidades aleatorias
                int usar1 = rand.nextInt(habilidades.length);
                int usar2 = rand.nextInt(habilidades.length);
                malo = new Enemigos("SEAL BOSS", 130, 55, habilidades[usar1], habilidades[usar2]);

            }

            malos.add(malo); //agregando los enemigos creados a la lista dinamica
            
        }

    }

    //getter para obtener el jugador y asi poder mandarlo al driver
    public Jugador getJugador() {
        
        return this.bueno; //retornando la instancia del jugador creado

    }

    //getter para obtener a los enemigos y asi poder mandarlos al driver
    public ArrayList<Enemigos> getEnemigos() {

        return this.malos; //retornando la instancia de los malos creados

    }

    //metodo para que el jugador pueda escoger su item de eleccion
    public void queItem() {

    }

    //metodo para que los enemigos puedan escoger la habilidad 
    public void queHabilidad() {

    }

    //metodo para simular los combates
    public void pelear() {
        
    }
    
}
