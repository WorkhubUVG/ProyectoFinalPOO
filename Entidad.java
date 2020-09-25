import java.util.ArrayList;

public class Entidad{ //creando la clase madre entidad

    //Definiendo las variables de los objetos creados a partir de esta clase:
    private ArrayList<String> CorreosDeEntidad = new ArrayList<>();
    protected String CorreoElectronico;
    protected String Nombre;

    public void revisarCorreosEntidad(){
        if(encontrarCorreos()){
            for(int posCorreo = 0; posCorreo < CorreosDeEntidad.size(); posCorreo++){
                // CAMBIAR SYSOUT A INTERACCION 
                System.out.println(CorreosDeEntidad.get(posCorreo));
            }
        }
        else{
            // CAMBIAR SYSOUT A INTERACCION 
            System.out.println("No tienes correos aun!");
        }
    }
    private boolean encontrarCorreos(){
        if(Almacen.revisarCorreosNuevos(this.CorreoElectronico).size() != 0){
            CorreosDeEntidad = Almacen.revisarCorreosNuevos(this.CorreoElectronico);
            return true;
        }
        else{ return false; }
    }


}

class Usuario extends Entidad { //creando la clase heredada de entidad, que sera para los usuarios

    public Usuario(String nombre, String correo){
        this.Nombre = nombre;
        this.CorreoElectronico = correo;
    }
    

}

class Empresa extends Entidad { //creando la clase heredada de entidad, que sera para las empresas

    public Empresa(String nombre, String correo){
        this.Nombre = nombre;
        this.CorreoElectronico = correo;
    }

}
