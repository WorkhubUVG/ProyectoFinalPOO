import java.util.ArrayList;

public class Entidad{ //creando la clase madre entidad

    //Definiendo las variables de los objetos creados a partir de esta clase:
    private ArrayList<String> CorreosDeEntidad = new ArrayList<>();
    protected String CorreoElectronico;
    protected String Nombre;

    public void revisarCorreosEntidad(){
        if(encontrarCorreos()){
            ArrayList<String> correosOrganizados = new ArrayList<>();
            int dirCorreoTamLargo = 0;
            for(int i = 0; i < CorreosDeEntidad.size(); i++){
                dirCorreoTamLargo = (CorreosDeEntidad.get(i).split(":")[0].length() > dirCorreoTamLargo) ? CorreosDeEntidad.get(i).split(":")[0].length() : dirCorreoTamLargo;
            }
            for(int i = 0; i < CorreosDeEntidad.size(); i++){
                String dirCorreo = CorreosDeEntidad.get(i).split(":")[0];
                if(CorreosDeEntidad.get(i).split(":")[0].length() < dirCorreoTamLargo){
                    dirCorreo = dirCorreo + " ".repeat(dirCorreoTamLargo - dirCorreo.length());
                }
                correosOrganizados.add(" > " + dirCorreo + ":" + CorreosDeEntidad.get(i).split(":")[1]);
            }
            for(int posCorreo = 0; posCorreo < correosOrganizados.size(); posCorreo++){
                Interaccion.ImprimirCorreos(correosOrganizados.get(posCorreo),posCorreo);
                if(posCorreo == (correosOrganizados.size() - 1)){ Interaccion.imprimirBandejaEntrada(true); }
            }
        }
        else{ Interaccion.sinCorreos(); }
    }
    private boolean encontrarCorreos(){
        if(Almacen.revisarCorreosNuevos(this.CorreoElectronico).size() != 0){
            CorreosDeEntidad = Almacen.revisarCorreosNuevos(this.CorreoElectronico);
            return true;
        }
        else{ return false; }
    }
}
// >> creando la clase heredada de entidad, que sera para los usuarios
class Usuario extends Entidad { 
    public Usuario(String nombre, String correo){
        this.Nombre = nombre;
        this.CorreoElectronico = correo;
    }

class Empresa extends Entidad { //creando la clase heredada de entidad, que sera para las empresas

    public Empresa(String nombre, String correo){
        this.Nombre = nombre;
        this.CorreoElectronico = correo;
    }

}
