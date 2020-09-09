import java.util.ArrayList;
public class almacen {

    private ArrayList<usuario> usuario;
    private ArrayList<empresa> empresa;

    public almacen(){
        usuario = new ArrayList();
        empresa = new ArrayList();
    }

    public boolean registrar_usuario(usuario nombre, usuario contraseña) {

        //agregando la informacion del usuario a la lista de usuario
        usuario.add(nombre);
        usuario.add(contraseña);

        return true;
    }

    
    public boolean registrar_empresa(empresa nombre, empresa contraseña) {

        //agregando la informacion de la empresa a la lista de empresa
        empresa.add(nombre);
        empresa.add(contraseña);

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