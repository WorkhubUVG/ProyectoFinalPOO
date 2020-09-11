//importando la clase ArrayList
import java.util.ArrayList; 
public class almacen { //creando la clase almacen

    //creando variables
    private ArrayList<usuario> usuario;
    private ArrayList<empresa> empresa;

    public almacen(){ //creando el constructor

        //definiendo variables
        usuario = new ArrayList();
        empresa = new ArrayList();
    }

    public boolean registrar_usuario(usuario x) {

        //agregando la informacion del usuario a la lista de usuario
        usuario.add(x);

        return true;
    }

    
    public boolean registrar_empresa(empresa x) {

        //agregando la informacion de la empresa a la lista de empresa
        empresa.add(x);

        return true;
    }

    public boolean iniciar_sesion(String nombre, String contraseña){ //meotod para ver si la informacion de iniciar sesion ya esta en las listas

        if(usuario.contains(nombre) && usuario.contains(contraseña)) {
            return true;
        } else if(empresa.contains(nombre) && empresa.contains(contraseña)) {
            return true;
        } else {
            return false;
        }
    }    


}