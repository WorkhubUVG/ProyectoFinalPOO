public class Controlador {
    
    public static void main(String[] args) {
        //Inicio del programa y único método contenido en el main.
        InicioPrograma();

    }
    public static void InicioPrograma(){


        
        // >> Una vez tenemos si el usuario ya existe o no, se manda a sus respectivos metodos:
        if(Interaccion.MenuInicio()){  // >> Verifica si es usuario o empresa (true si es usuario, false si es empresa)
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
                //InstanciaUsuario.revisarCorreosEntidad();
                // Sesion Iniciada:
                SesionIniciada(InstanciaUsuario);
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
                // Inicio del proceso de empresa. 
                Empresa InstanciaEmpresa = new Empresa(Almacen.getEmpresaEncontrada()[0],Almacen.getEmpresaEncontrada()[2]);
                //InstanciaEmpresa.revisarCorreosEntidad();
                // Sesion Iniciada:
                SesionIniciada(InstanciaEmpresa);
            }
            else{
                Interaccion.mostrarErrorInicioSesion(false);
                InicioPrograma();
            }
        }
    }
    private static void SesionIniciada(Entidad tipoDeEntidad){
        if(tipoDeEntidad.getClass().getName().equals("Usuario")){
            // forzando a la instancia 
            Entidad usuarioIniciado = (Usuario)tipoDeEntidad;
            int opcion = 0;
            while(true){
                opcion = Interaccion.MenuPrincipal(usuarioIniciado);
                if(opcion == 1){
                    usuarioIniciado.revisarCorreosEntidad();
                }else if(opcion == 4){
                    InicioPrograma();
                }else if(opcion == 2){
                    Interaccion.nuevoCorreo(usuarioIniciado);
                }
            }
        }
        else if(tipoDeEntidad.getClass().getName().equals("Empresa")){
            // Este sera el controlador para la sesion iniciada de tipo Empresa
            Entidad empresaIniciada = (Empresa)tipoDeEntidad;

            int opcion = 0;
            while(true){
                opcion = Interaccion.MenuPrincipal(empresaIniciada);
                if(opcion == 1){
                    empresaIniciada.revisarCorreosEntidad();
                }else if(opcion == 4){
                    InicioPrograma();
                }else if(opcion == 2){
                    Interaccion.nuevoCorreo(empresaIniciada);
                }
            }

            
        }
        else{Interaccion.errorDeInstancia(); InicioPrograma();}
    }



    private static void registroUsuario() {
        String[] datosNuevaEntidad;
        // Se inicia la creacion de una entidad, necesitamos saber si son usuarios o empresas:
        if(Interaccion.CrearEntidad()){
            // creacion de usuario:
            datosNuevaEntidad = Interaccion.NuevaCreacionNombre(true);
            if(Almacen.RevDatosEntidad(true, datosNuevaEntidad)){
                // datos agregados
                Almacen.agregarDatosCSV(true, datosNuevaEntidad);
                Interaccion.DatosAgregados(true);
                InicioPrograma();
            }
            else{
                // Error, datos sin agregar
                Interaccion.DatosAgregados(false);
                InicioPrograma();
            }
        }
        else{
            // creacion de empresa:
            datosNuevaEntidad = Interaccion.NuevaCreacionNombre(false);
            if(Almacen.RevDatosEntidad(false, datosNuevaEntidad)){
                // datos agregados
                Almacen.agregarDatosCSV(false, datosNuevaEntidad);
                Interaccion.DatosAgregados(true);
                InicioPrograma();
            }
            else{
                // Error, datos sin agregar
                Interaccion.DatosAgregados(false);
                InicioPrograma();
            }
        }
    }
}