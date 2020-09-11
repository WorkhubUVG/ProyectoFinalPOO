//importando la clase ArrayList
import java.util.ArrayList; 
public class almacen { //creando la clase almacen

    //creando variables
    private  ArrayList<usuario> usuario;
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

    public boolean iniciar_sesion_u(String nombre, String contraseña){ //meotod para ver si la informacion de iniciar sesion ya esta en las listas

        boolean respuesta = false;
        for(int i = 0; i<usuario.size();i++){
            if((usuario.get(i).getNombre()).equals(nombre) && (usuario.get(i).getContraseña()).equals(contraseña)) {
                respuesta = true;
                break;
            }else {
                respuesta = false;
            }
        }
        return respuesta;
        
    }   
    public boolean iniciar_sesion_e(String nombre, String contraseña){ //meotod para ver si la informacion de iniciar sesion ya esta en las listas

        boolean respuesta = false;
        for(int i = 0; i<empresa.size();i++){
            if(empresa.get(i).getNombreEmpresa().equals(nombre) && empresa.get(i).getContraseña().equals(contraseña)) {
                respuesta = true;
                break;
            } else {
                respuesta = false;
            }
        }
        return respuesta;
        
    } 

    // Getters de tanto el arreglo de usaurios como el arreglo de la empresa para la clase de Workhub:
    
    public ArrayList<usuario> getArregloUsuarios(){

        return this.usuario;

    }
    public ArrayList<empresa> getArregloEmpresa(){

        return this.empresa;

    }

    
    


}