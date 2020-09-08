public class usuario {

    private static int usuarios_totales = 0;
    private String nombre;
    private String contraseña;
    private String apellido;
    private String correo;
    private String profesion;
    private int    edad;
    
    //prueba de un comentario alterado

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
}
