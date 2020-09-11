//importando la clase Scnanner
import java.util.ArrayList;
import java.util.Scanner;


public class WorkHub { 


    public static boolean sesionIniciada(String x , almacen datos){
        boolean salir = true;
        if(x.equals("usuario")){

            // Se empieza el proceso de busqueda de empresas:
            ArrayList<empresa> lista_empresas = datos.getArregloEmpresa();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBuenas tardes, aqui se presenta la lista de empresas que lo estan buscando:\n");
            for(int i = 0; i < lista_empresas.size(); i++){
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Nombre de la empresa: " + lista_empresas.get(i).getNombreEmpresa()); 
                System.out.println("La empresa mayormente se dedica a:\n" + lista_empresas.get(i).getDescripcionEmpresa());
                System.out.println("Para ponerse en contacto con la empresa puede escribir a: " + lista_empresas.get(i).getCorreoEmpresa());
                System.out.println("O puede llamar al numero de telefono: " + lista_empresas.get(i).getNumTelefono());
                System.out.println("-------------------------------------------------------------------");
            }

        }else if(x.equals("empresa")){
        
            // Se comienza el proceso de busqueda de usuarios:
            ArrayList<usuario> lista_usuarios = datos.getArregloUsuarios();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBuenas tardes, aqui se presenta la lista de usuarios que estan disponibles a ser contratados:\n");
            for(int i = 0; i < lista_usuarios.size(); i++){

                System.out.println("-------------------------------------------------------------------");
                System.out.println("Nombre del usuario: " + lista_usuarios.get(i).getNombre() + " " + lista_usuarios.get(i).getApellido());
                System.out.println("Se dedica a: " + lista_usuarios.get(i).getProfesion());
                System.out.println("Tiene una edad de: " + lista_usuarios.get(i).getedad());
                System.out.println("Su contacto puede ser accedido por medio de: " + lista_usuarios.get(i).getCorreo());

            }

        }
        return salir;
    }
    private static void crearInstancias(almacen p){

        String[] nombres = new String[]{"Pablo","Alejandro","Juan","Estuardo","Jose"};
        String[] claves = new String[]{"asdasd","asdasd","asdasd","asdasd","asdasd"};
        String[] apellidos = new String[]{"Gonzales","Archila","Padilla","Hernandez","Davila"};
        String[] correo = new String[]{"pa3@gmail.com","ar4@gmail.com","ju5@gmail.com","pa3@gmail.com","soynuevo@uvg.edu.gt"};
        int[]    edades = new int[]{20,31,30,22,43};
        String[] profesion = new String[]{"Ingeniero en sistemas","Ingeniero en sistemas","Abogado","Ingeniero Civil","Ingeniero Industrial"};

        for(int i = 0; i < nombres.length; i++){

            usuario comodin = new usuario(nombres[i], claves[i], apellidos[i], correo[i], profesion[i], edades[i]);
            p.registrar_usuario(comodin);
        }


        ArrayList<String> nombreEmpresa = new ArrayList<>();
        nombreEmpresa.add("McDonalds");
        nombreEmpresa.add("Berguer King");
        nombreEmpresa.add("Kentucky free chicken");
        nombreEmpresa.add("Faceook");
        nombreEmpresa.add("Amazonias Inc S.A.");
        String[] Descripciones = new String[]{"No somos veganos, las mejores hambargasas de la city!","El de arriba es puto, compren aqui mejor","Quien quiere hambargasas cuando hay pollo","Mejor que Instagram","Soy mejor que walmart, manda tu paqueton de forma segura!"};
        String[] Correos = new String[]{"mcrules@mc.com","theoneabovesucks@burgerrules.com","Alabama sucks","We spy on you","We spy on you as well"};
        String[] clavesempresas = new String[]{"123e","123e","123e","123e","123e"};
        int[] telefonosempresa = new int[]{12123434,12121232,34234324,6546456,456456};

        for(int i = 0; i < nombreEmpresa.size(); i++){
            empresa comodin = new empresa(nombreEmpresa.get(i), clavesempresas[i], Descripciones[i],Correos[i], telefonosempresa[i]);
            p.registrar_empresa(comodin);
        }







        

    }
    public static void main(String []args){ // creando el meotodo main para interactuar con el usuario

        //instanciando las clases
        Scanner scan = new Scanner(System.in);  
        usuario usuario;
        empresa empresa;
        almacen almacen = new almacen();
        crearInstancias(almacen);
 
        //empezando la simulacion
        System.out.println("--------------Bienvenido a WorkHub------------------");

        boolean salir = false;
        int op = 0;
        String nombre = "";
        String contra = "";
        String conContra = "";
        
        //ciclo para el inicio del programa
        while(salir==false){

            //inicio de sesion o crear usuario.

            System.out.println("\n [1] Iniciar sesion.");
            System.out.println("\n [2] Registrarse");

            boolean opcion = false;

            while(opcion == false){
                try{
                    System.out.print("\n Opcion --> ");
                    op = scan.nextInt();
                    System.out.println();
                    if(op<1 || op>2){
                        System.out.println("\n\t ! Ingrese valores entre 1 y 2 !\n");
                    }else{
                        opcion = true;
                    }
    
                }catch(Exception e){
                    System.out.println("\n\t ! Ingrese valores numericos !\n");
                    scan.nextLine();
                }
            }

            int opcion_tipo = 0;
            opcion = false;
            System.out.println("\n [1] Usuario. ");
            System.out.println("\n [2] Empresa. ");
            while(opcion == false){
                try{
                    System.out.print("\n Opcion --> ");
                    opcion_tipo = scan.nextInt();
                    System.out.println();
                    if(opcion_tipo<1 || opcion_tipo>2){
                        System.out.println("\n\t ! Ingrese valores entre 1 y 2 ! \n");
                    }else{
                        opcion = true;
                    }
                }catch(Exception e){
                    System.out.println("\n\t ! Ingrese valores numericos !\n");
                    scan.nextLine();
                }
            }

            if(opcion_tipo ==1){
                if(op == 1){
                    //iniciar sesion.
                    System.out.println("\n----------- INICIO DE SESION ------------\n");
                    System.out.print("\n Ingrese su nombre --> ");
                    nombre = scan.next();
                    System.out.println();
                    System.out.print("\n Ingrese la contraseña --> ");
                    contra = scan.next();
                    System.out.println();
    
                    boolean existe = almacen.iniciar_sesion_u(nombre, contra);
                    if(existe == true){
                        salir = sesionIniciada("usuario",almacen);
                    }else{
                        System.out.println("\n Datos incorrectos! \n");
                    }
    
                    
                }else if(op == 2){
                    //registrarse.
                    System.out.println("\n-------------- REGISTRO ---------------\n");
                    System.out.print("\n Ingrese su nombre --> ");
                    String n = scan.next();
                    System.out.println();
    
                    System.out.print("\n Ingrese su contraseña --> ");
                    String c = scan.next();
                    System.out.println();
    
                    boolean con = false;
                    while(con == false){
    
                        System.out.print("\n Repita su contraseña --> ");
                        String segundoc = scan.next();
                        System.out.println();
    
                        if(segundoc.equals(c)){
                            con = true;
                        }else{
                            System.out.println("\n\t ! Contraseña incorrecta, vuelva a intentar !");
                        }
    
                    }
    
                    System.out.print("\n Ingrese su apellido --> ");
                    String apellido = scan.next();
                    System.out.println();
    
                    
                    System.out.print("\n Ingrese su correo --> ");
                    String correo = scan.next();
                    System.out.println();
                    
                    
    
                    System.out.print("\n Ingrese su carrera --> ");
                    String prof = scan.next();
                    System.out.println();
    
                    int edad = 0;
                    boolean nu = false;
                    while(nu==false){
                        try{
                            System.out.print("\n Ingrese su edad -->");
                            edad = scan.nextInt();
                            System.out.println();
                            nu = true;
                        }catch(Exception e){
                            System.out.println("\n\t ! Ingrese valores numericos ! ");
                            scan.nextLine();
                        }
                        
                    }
                    
                    System.out.println("\n\n\n");
                    usuario = new usuario(n, c, apellido, correo, prof, edad);
                    almacen.registrar_usuario(usuario);
                }

                }else if(opcion_tipo == 2){

                    if(op == 1){
                        System.out.println("\n----------- INICIO DE SESION ------------\n");
                        System.out.print("\n Ingrese el nombre de la empresa --> ");
                        nombre = scan.next();
                        System.out.println();
                        System.out.print("\n Ingrese la contraseña --> ");
                        contra = scan.next();
                        System.out.println();

                        boolean existe = almacen.iniciar_sesion_e(nombre, contra);
                        if(existe == true){
                            salir = sesionIniciada("empresa",almacen);
                        }else{
                            System.out.println("\n Datos incorrectos! \n");
                        }

                    }else if(op == 2){
                        //registrarse.
                        System.out.println("\n-------------- REGISTRO ---------------\n");
                        System.out.print("\n Ingrese el nombre de la empresa --> ");
                        String n_empresa = scan.next();
                        System.out.println();
    
                        System.out.print("\n Ingrese su contraseña --> ");
                        String c = scan.next();
                        System.out.println();
    
                        boolean con = false;
                        while(con == false){
    
                            System.out.print("\n Repita su contraseña --> ");
                            String segundoc = scan.next();
                            System.out.println();
    
                            if(segundoc.equals(c)){
                                con = true;
                            }else{
                                System.out.println("\n\t ! Contraseña incorrecta, vuelva a intentar !");
                            }
    
                        }
    
                        System.out.print("\n Ingrese la descripcion de la empresa --> ");
                        String descripcion = scan.next();
                        System.out.println();
    
                        System.out.print("\n Ingrese su correo --> ");
                        String correo = scan.next();
                        System.out.println();
    
                        int telefono = 0;
                        boolean nu = false;
                        while(nu==false){
                            try{
                                System.out.print("\n Ingrese el telefono -->");
                                telefono = scan.nextInt();
                                System.out.println();
                                nu = true;
                            }catch(Exception e){
                                System.out.println("\n\t ! Ingrese valores numericos ! ");
                                scan.nextLine();
                            }
                            
                        }
                        
                        System.out.println("\n\n\n");
                        empresa = new empresa(n_empresa, c, descripcion, correo, telefono);
                        almacen.registrar_empresa(empresa);
                    }
                }
                    //iniciar sesion.
                    

                    
                

            }
            
            //quitar despues
            salir = true;
            
            
            
        }
    } 
