public class empresa {
    
    //Atributos de la clase empresa.
    private String nombreEmpresa;
    private String descripcionEmpresa;
    private String correoElectronico;
    private String numTelefono;
    
    //Builder de empresa
    public empresa(String inNombreEmpresa,String inDescripcion,String inCorreoElectronico, String inNumTelefono) {
        this.descripcionEmpresa = inDescripcion;
        this.nombreEmpresa      = inNombreEmpresa;
        this.correoElectronico  = inCorreoElectronico;
        this.numTelefono        = inNumTelefono;
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
    public String getNumTelefono(){
        return this.numTelefono;
    }


}