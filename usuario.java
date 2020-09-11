public class usuario {

    //Atributos de la clase usuario.
    private static int usuarios_totales = 0;
    private String nombre;
    private String contraseña;
    private String apellido;
    private String correo;
    private String profesion;
    private int    edad;

    // >> Constructor de la clase "usuario":
    public usuario(String nombreUsuarioInput, String contraseñaInput, String apellidoInput, String correoInput, String profesionInput, int edadInput){

        // >> Asignando las propiedades desde el contructor:
        this.nombre     = nombreUsuarioInput;
        this.contraseña = contraseñaInput;
        this.apellido   = apellidoInput;
        this.correo     = correoInput;
        this.profesion  = profesionInput;
        this.edad       = edadInput;

        // >> Aumentando el contador de instancias.
        usuarios_totales++;
        
        
    }    

    // Getter de profesion usuario:
    public String getProfesion(){
        return this.profesion;
    }
    // Getter de corre de usuario:
    public String getCorreo(){
        return this.correo;
    }
    // getter de apellido de usaurio
    public String getApellido(){
        return this.apellido;
    }
    // getter de edad del usuario
    public int getedad(){
        return this.edad;
    }
    // getter de nombre de usuario
    public String getNombre(){
        return nombre;
    }
    // getter de clave de usuario
    public String getContraseña(){
        return contraseña;
    }
}
