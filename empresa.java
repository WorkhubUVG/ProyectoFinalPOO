public class empresa {
    
    //Atributos de la clase empresa.
    private String nombreEmpresa;
    private String descripcionEmpresa;
    private String correoElectronico;
    private String numTelefono;
    
    //Setter
    public void setNombreEmpresa(String inNombreEmpresa) {
        this.nombreEmpresa = inNombreEmpresa;
    }

    // Getter del metodo anterior
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    // Setter de la descripcion de la empresa
    public void setDescripcionEmpresa(String inDescripcion) {
        this.descripcionEmpresa = inDescripcion;
    }

    //getter del metodo anterior
    public String getDescripcionEmpresa(){
        return this.descripcionEmpresa;
    }

    //Setter del correo de la empresa
    public void setCorreoEmpresa(String inCorreoElectronico){
        this.correoElectronico = inCorreoElectronico;
    }
    //Getter del método anterior
    public String getCorreoEmpresa(){
        return this.correoElectronico;
    }

    //Setter del correos 
    public void setNumTelefono(String inNumTelefono){
        this.numTelefono = inNumTelefono;
    }
    //getter del método anterior
    public String getNumTelefono(){
        return this.numTelefono;
    }


}