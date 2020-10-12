/*****************************************************
 Jugador.java                   Autor: Javier Mombiela
                                Carne:           20067
                                Seccion:            21
                                        Fecha: 09/2020
Esta clase es heredada de la clase combatiente y es el
objeto de tipo jugador.
 ****************************************************/

class Jugador extends Combatiente { //creando la clase heredada combatiente


    public Jugador(String nombre, int hitpoints, int ataque, String item) { //creando el constructor guerrero
        
        //invocando el constructor de la clase madre (combatiente)
        super();

        //definiendo las variables
        Nombre    = nombre;
        Hitpoints = hitpoints;
        Ataque    = ataque;
        items.add(item);

    }

    public Jugador(String nombre, int hitpoints, int ataque, String item0, String item1) { //creando el constructor de explorador (overlading)
        
        //invocando el constructor de la clase madre (combatiente)
        super();

        //definiendo las variables
        Nombre    = nombre;
        Hitpoints = hitpoints;
        Ataque    = ataque;
        items.add(item0);
        items.add(item1);

    }

    @Override
    public String toString() { //creando el metodo toString
        
        //llamando al toString de combatiente
        String string = super.toString();

        //haciendo for para que tenga el numero correcto de items
        for(int i = 0; i<items.size(); i++) {
            string += "\nITEM " + (i+1) + "       : " + items.get(i);
        }

        return string;

    }
    
}
