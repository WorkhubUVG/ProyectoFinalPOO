class Controlador {
    
    public static void main(String[] args) {
        // Se inicia el programa, unico metodo contenido en el main.
        InicioPrograma();

    }
    private static void InicioPrograma(){

        // >> El primer paso del programa es saber si la entidad ya existe o si necesita ser creada:
        boolean usuarioExistente = Interaccion.MenuInicio();
        // >> Una vez tenemos si el usuario ya existe o no, se manda a sus respectivos metodos:
        if(usuarioExistente){  // >> Verifica si es usuario o empresa (true si es usuario, false si es empresa)
            if(Interaccion.usuario_empresa()){ inicioDeSesion(true); }
             else{ inicioDeSesion(false); }
        }
        else { registroUsuario(); }
    }

    private static void inicioDeSesion(boolean esUsuario) {
        if(esUsuario){
            Almacen.revisarUsuarios();
            if(Almacen.verificarDatosUsuario(Interaccion.nombreUsuario(true), Interaccion.claveUsuario())){
                Interaccion.InicioSesionCorrecto(Almacen.getUsuarioEncontrado()[0], Almacen.getUsuarioEncontrado()[2], true);
                // AQUI comienza el proceso de usuario
                Usuario InstanciaUsuario = new Usuario(Almacen.getUsuarioEncontrado()[0],Almacen.getUsuarioEncontrado()[2]);
                InstanciaUsuario.revisarCorreosEntidad();
            }
            else{
                Interaccion.mostrarErrorInicioSesion(true);
                InicioPrograma();
            }
        }
        else {
            Almacen.revisarEmpresas();
            if(Almacen.verificarDatosEmpresa(Interaccion.nombreUsuario(false), Interaccion.claveUsuario())){
                Interaccion.InicioSesionCorrecto(Almacen.getEmpresaEncontrada()[0], Almacen.getEmpresaEncontrada()[2], false);
                // AQUI comienza el proceso de empresa
                Empresa InstanciaEmpresa = new Empresa(Almacen.getEmpresaEncontrada()[0],Almacen.getEmpresaEncontrada()[2]);
                InstanciaEmpresa.revisarCorreosEntidad();
            }
            else{
                Interaccion.mostrarErrorInicioSesion(false);
                InicioPrograma();
            }


        }
    }

    private static void registroUsuario() {


    }

}
