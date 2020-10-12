/*****************************************************
 Enemigos.java                  Autor: Javier Mombiela
                                Carne:           20067
                                Seccion:            21
                                        Fecha: 09/2020
Esta clase es heredada de la clase combatiente y es el
objeto de tipo enemigos.
 ****************************************************/

class Enemigos extends Combatiente { //creando la clase heredada enemigos

    public Enemigos() { //creando el constructor 

    }

    public Enemigos(String nombre, int hitpoints, int ataque, String habilidad) { //creando el constructor de los enemigos normales

        //invocando el constructor de la clase madre (combatiente)
        super();

        //definiendo las variables
        Nombre    = nombre;
        Hitpoints = hitpoints;
        Ataque    = ataque;
        habilidades.add(habilidad);

    }

    public Enemigos(String nombre, int hitpoints, int ataque, String habilidad1, String habilidad2) {//creando el constructor de los enemigos "boss" (overloading)

        //invocando el constructor de la clase madre (combatiente)
        super();

        //definiendo las variables
        Nombre    = nombre;
        Hitpoints = hitpoints;
        Ataque    = ataque;
        habilidades.add(habilidad1);
        habilidades.add(habilidad2);

    } 

    public String getNombre() { //metodo para obtener el nombre de los enemigos

        return this.Nombre;
    }

    @Override
    public String toString() { //creando el metodo toString
        
        //llamando al toString de combatiente
        String string = super.toString();

         //haciendo for para que tenga el numero correcto de habilidades
         for(int i = 0; i<habilidades.size(); i++) {
            string += "\nHABILIDAD " + (i+1) + "  : " + habilidades.get(i);
        }

        return string;

    }
    
}
