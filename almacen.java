import java.util.ArrayList;
public class almacen {

    private ArrayList<usuario> empresa;
    private ArrayList<empresa> empresario;

    public almacen(){
        empresa = new ArrayList();
        empresario = new ArrayList();
    }

    public boolean iniciar_sesion(String nombre, String contraseña){ //prueba pushea
        if(nombre == contraseña) {
            return true;
        } else {
            return false;
        }
    }



}