import java.util.ArrayList;
public class almacen {

    private ArrayList<usuario> usuario;
    private ArrayList<empresa> empresa;

    public almacen(){
        usuario = new ArrayList();
        empresa = new ArrayList();
    }

    public boolean registrar_usuario(usuario nombre, usuario contraseña) {

        //agregando la informacion a las listas
        usuario.add(nombre);
        usuario.add(contraseña);

        return true;
    }

    public boolean iniciar_sesion(String nombre, String contraseña){

        if(usuario.contains(nombre) && usuario.contains(contraseña)) {
            return true;
        } else {
            return false;
        }
    }


}