public class empresa {
    
    //Atributos de la clase empresa.
    private String nombreEmpresa;
    private String contraseña;
    private String descripcionEmpresa;
    private String correoElectronico;
    private int numTelefono;
    
    //Builder de empresa
    public empresa(String inNombreEmpresa,String Contraseña, String inDescripcion,String inCorreoElectronico, int inNumTelefono) {
        this.descripcionEmpresa = inDescripcion;
        this.nombreEmpresa      = inNombreEmpresa;
        this.correoElectronico  = inCorreoElectronico;
        this.numTelefono        = inNumTelefono;
        this.contraseña         = Contraseña;
    }

    // Getter del metodo anterior
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    //getter del metodo anterior
    public String getDescripcionEmpresa(){
        return this.descripcionEmpresa;
    }

    //Getter del método anterior
    public String getCorreoEmpresa(){
        return this.correoElectronico;
    }
    //getter del método anterior
    public int getNumTelefono(){
        return this.numTelefono;
    }
    public String getContraseña(){
        return this.contraseña;
    }


}