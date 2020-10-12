/*****************************************************
 Combatiente.java               Autor: Javier Mombiela
                                Carne:           20067
                                Seccion:            21
                                        Fecha: 09/2020
Esta clase es la clase madre de jugador y enemigos
y tendra los datos de los mismos.
 ****************************************************/

//importando clase externa
import java.util.ArrayList;

public class Combatiente { //creando la clase combatiente

        //creando variables
        protected String Nombre;
        protected int    Ataque;
        protected int    Hitpoints;  
        protected ArrayList<String> items       = new ArrayList<>();
        protected ArrayList<String> habilidades = new ArrayList<>();


        public Combatiente() { //creando el constructor

        }

        @Override
        public String toString() {
                String string = "\nNOMBRE       : " + Nombre + "\nHITPOINTS    : " + Hitpoints + "\nATAQUE       : " + Ataque;
                return string;
        }

    
}
