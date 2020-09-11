//importando la clase Scnanner
import java.util.Scanner;


public class WorkHub { 


    public static void sesionIniciada(String x){
        if(x.equals("usuario")){
            System.out.println("usuario");
        }else if(x.equals("empresa")){
            System.out.println("empresa");
        }
    }
    public static void main(String []args){ // creando el meotodo main para interactuar con el usuario

        //instanciando las clases
        Scanner scan = new Scanner(System.in);
        usuario usuario;
        empresa empresa;
        almacen almacen = new almacen();
 
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
    
                    boolean existe = almacen.iniciar_sesion(nombre, contra);
                    if(existe == true){
                        sesionIniciada("usuario");
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

                        boolean existe = almacen.iniciar_sesion(nombre, contra);
                        if(existe == true){
                            sesionIniciada("empresa");
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
