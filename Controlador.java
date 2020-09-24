class Controlador {
    
    public static void main(String[] args) {
        // Se inicia el programa, unico metodo contenido en el main.
        InicioPrograma();

    }
    private static void InicioPrograma(){

        // >> El primer paso del programa es saber si la entidad ya existe o si necesita ser creada:
        boolean usuarioExistente = Interaccion.MenuInicio();
        // >> Una vez tenemos si el usuario ya existe o no, se manda a sus respectivos metodos:



        // AUN SE NECESITA SABER SI ES EMPRESA O USUARIO



        boolean tipo = Interaccion.usuario_empresa();
        if(usuarioExistente){  // >> Verifica si es usuario o empresa (true si es usuario, false si es empresa)
            if(tipo == true){ inicioDeSesion(true); }
             else{ inicioDeSesion(false);}
        }
        else { registroUsuario(); }

    }


    private static void inicioDeSesion(boolean esUsuario) {
        if(esUsuario){
            Almacen.revisarUsuarios();
            if(Almacen.verificarDatosUsuario(Interaccion.nombreUsuario(true), Interaccion.claveUsuario())){
                System.out.println("Se encontro el usuario: " + Almacen.getUsuarioEncontrado()[0] + " " + Almacen.getUsuarioEncontrado()[2]);
            }
            else{
                System.out.println("No se ha encontrado usuario!");
                InicioPrograma();
            }
        }
        else {
            Almacen.revisarEmpresas();
            if(Almacen.verificarDatosEmpresa(Interaccion.nombreUsuario(false), Interaccion.claveUsuario())){
                System.out.println("Se encontro la empresa: " + Almacen.getEmpresaEncontrada()[0] + " " + Almacen.getEmpresaEncontrada()[2]);
            }
            else{
                System.out.println("No se ha encontrado empresa!");
                InicioPrograma();
            }


        }
    }

    private static void registroUsuario() {


    }

}
