package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca {
            
            static class NodoLibro{
            String id;
            String nombre;
            String autor;
            NodoLibro izquierdo, derecho;
            
public NodoLibro(String id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.izquierdo = this.derecho = null;
    }
}
  static class NodoUsuario{
            int cedula;
            String nombre;
            String apellido;
            NodoUsuario izquierdo, derecho;

    public NodoUsuario(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.izquierdo = this.derecho = null;
    }

}

    public static void main(String[] args) {

            NodoLibro raizLibro = null;
            NodoUsuario raizUsuarios = null;
            ArrayList<NodoLibro> librosPrestados = new ArrayList<>();
            Scanner entrada = new Scanner(System.in);
            int opcion;
            
            do{
                System.out.println("----Estudiante: Javier Shtiven Chaparro Hernandez----");
                System.out.println("---Estructuras de Datos -- Doc. Carmen Rubio---");
                System.out.println("==== Sistema de Gestion de Biblioteca ====");
                System.out.println("1. Menu de Libros");
                System.out.println("2. Menu de Usuarios");
                System.out.println("3. Prestar Libro");
                System.out.println("4. Devolver Libro");
                System.out.println("5. Listar Libros Prestados");
                System.out.println("6. Listar Libros Disponibles");
                System.out.println("7. Salir");
                opcion = entrada.nextInt();
                
                switch(opcion){
                         case 1:
                         int opcionLibros;
                         do {
                         System.out.println("===Menu de Libros===");
                         System.out.println("1. Agregar Libro");
                         System.out.println("2. Eliminar Libro");
                         System.out.println("3. Listar Libros");
                         System.out.println("4. Volver al menu principal");
                         System.out.println("Selecciona una opcion");
                         opcionLibros = entrada.nextInt();
                         entrada.nextLine();
                                if (opcionLibros ==1) {
                                System.out.println("Ingresar Id del libro: ");
                                String id= entrada.nextLine();
                                if(buscarLibro(raizLibro, id)){
                                System.out.println("El libro con Id "+id+" ya existe");
                                }else  {
                                     System.out.println("Ingrese el nombre del Libro: ");
                                     String nombre = entrada.nextLine();
                                     System.out.println("Ingrese el autor del Libro: ");
                                     String autor = entrada.nextLine();
                                     NodoLibro nuevoLibro = new NodoLibro(id, nombre, autor);
                                     raizLibro = agregarLibro(raizLibro, nuevoLibro);
                                     System.out.println("Libro agregado exitosamente!!!");
                                       }
                                }else if (opcionLibros ==2 ){
                                //Eliminar libro
                                System.out.println("Ingresa el Id del libro a Eliminar: ");
                                String idEliminar = entrada.nextLine();
                                       if(buscarLibro (raizLibro, idEliminar)){
                                       raizLibro = eliminarLibro (raizLibro, idEliminar);
                                       System.out.println("Libro Eliminado Exitosamente");
                                       }else{
                                            System.out.println("El libro con el Id "+idEliminar + " No se puede Eliminar");
                                         }
                                       }else if(opcionLibros ==3){
                                        //Listar Libros
                                        System.out.println("Libros en la biblioteca");
                                        System.out.printf("%-10s %-20s %-20s%n ", "ID", "nombre","Autor");
                                        listarLibros(raizLibro);
                                        }
                            } while (opcionLibros !=4);
                                 break;
                        case 2:
                         int opcionUsuario;
                          do{
                                               System.out.println("===Menu de Usuarios===");
                                               System.out.println("1. Agregar Usuario");
                                               System.out.println("2. Eliminar Usuario");
                                               System.out.println("3. Listar Usuario");
                                               System.out.println("4. Volver al menu principal");
                                               System.out.println("Selecciona una opcion");
                                               opcionUsuario = entrada.nextInt();
                                               entrada.nextLine();
                                               if (opcionUsuario ==1) {
                                                   //Agregar Usuarios
                                                        System.out.println("Ingresar numero de cedula: ");
                                                        int cedula = entrada.nextInt();
                                                        entrada.nextLine();
                                                        if(buscarUsuario(raizUsuarios, cedula)){
                                                        System.out.println("El Usuario con numero de cedula "+cedula+" ya existe");
                                               }else  {
                                                   System.out.println("Ingrese el nombre del Usuario: ");
                                                   String nombre = entrada.nextLine();
                                                   System.out.println("Ingrese el apellido del Usuario: ");
                                                   String apellido = entrada.nextLine();
                                                   NodoUsuario nuevoUsuario = new NodoUsuario(cedula, nombre, apellido);
                                                            if (raizUsuarios == null) {
                                                                raizUsuarios = nuevoUsuario;
                                                                    }else {
                                                                        NodoUsuario actual = raizUsuarios;
                                                                        while(true){
                                                                        if(cedula<actual.cedula){
                                                                        if(actual.izquierdo == null){
                                                                                actual.izquierdo = nuevoUsuario;
                                                                        break;
                                                                                }
                                                                        actual = actual.izquierdo;
                                                                        }else{
                                                                                if (actual.derecho == null) {
                                                                                actual.derecho = nuevoUsuario;
                                                                        break;
                                                                                }
                                                                        actual = actual.derecho;
                                                                        }
                                                                    }
                                                            }
                                                   System.out.println("Usuario agregado exitosamente!!!");
                                               }
                                            }else if (opcionUsuario ==2 ){
                                                //Eliminar Usuario
                                                   System.out.println("Ingresa el numero de cedula del usuario a Eliminar: ");
                                                   int cedulaEliminar = entrada.nextInt();
                                                   entrada.nextLine();
                                                   if(buscarUsuario (raizUsuarios, cedulaEliminar)){
                                                       raizUsuarios = eliminarUsuario (raizUsuarios, cedulaEliminar);
                                                       System.out.println("Usuario Eliminado Exitosamente");
                                                   }else{
                                                       System.out.println("El usuario con numero de cedula "+cedulaEliminar + " No se puede eliminar");
                                                   }
                                            }else if(opcionUsuario ==3){
                                                //Listar Usuarios
                                                   System.out.println("Usuarios registrados");
                                                   System.out.printf("%-10s %-15s %-20s%n ", "cedula", "nombre","apellido");
                                                   listarUsuarios(raizUsuarios);
                                            }
                                        } while (opcionUsuario !=4);
                                            break;
                                    case 3:
                                        System.out.println("Ingresa el Id del Libro: ");
                                        String idPrestar = entrada.next();
                                        System.out.println("Ingresa el numero de Cedula del Usiario: ");
                                        int cedulaPrestar = entrada.nextInt();
                                        entrada.nextLine();
                                        
                                        if (buscarLibro(raizLibro, idPrestar)&& buscarUsuario(raizUsuarios, cedulaPrestar)) {
                                            NodoLibro libroPrestado = obtenerLibro(raizLibro, idPrestar);
                                            if (libroPrestado !=null) {
                                                librosPrestados.add(libroPrestado);
                                                raizLibro = eliminarLibro(raizLibro, idPrestar);
                                                System.out.println(String.format("Libro %s prestado exitosamente al Usuario con numero de cedula %d", idPrestar, cedulaPrestar));
                                        }else{
                                                System.out.println("Error No se encontro el Libro a Prestar");
                                            }
                                        }else{System.out.println("No se puede prestar el Libro: Verifica que el Libro y Uusario este registrado");
                                         
                                        }
                                            break;
                                    case 4:
                                        System.out.println("Ingresa el Id del Libro a devolver: ");
                                        String idDevolver = entrada.next();
                                        NodoLibro libroDevolver = null;
                                        for(NodoLibro libro : librosPrestados){
                                            if (libro.id.equals(idDevolver)) {
                                                libroDevolver = libro;
                                                break;
                                            }
                                        }
                                        if (libroDevolver !=null) {
                                            raizLibro = agregarLibro(raizLibro, libroDevolver);
                                            librosPrestados.remove(libroDevolver);
                                            System.out.println(String.format("Libro %s (%s) devolvuelto exitosamente", libroDevolver.id, libroDevolver.nombre));
                                            }else {
                                            System.out.println("El libro no se encuentra en la base de datos de Libros a Devolver");
                                        }
                                            break;
                                    case 5:
                                        if (librosPrestados.isEmpty()) {
                                            System.out.println("No hay Libros Prestados Actualmente");
                                            }else {
                                            System.out.println("Libros Prestado: ");
                                            System.out.printf("%-10s %-20s %-20s%n", "Id", "Nombre", "Autor");
                                            for(NodoLibro libro: librosPrestados){
                                                System.out.printf("%-10s %-20s %-20s%n",libro.id, libro.nombre, libro.autor);
                                            }
                                        }
                                            break;
                                    case 6:
                                        System.out.println("Libros Disponibles para prestar ");
                                        System.out.printf("%-10s %-20s %-20s%n", "Id", "Nombre", "Autor");
                                        listarLibros(raizLibro);
                                            break;
                                    case 7:
                                        System.out.println("Gracias por usar nuestra plataforma, Vuelva Pronto!!!");
                                            break;
                                    default:
                                        System.out.println("Opcion no valida. Intente nuevamente");
                }
                
            }while  (opcion !=7);
    }

            public static boolean buscarLibro(NodoLibro nodo, String id){
                if (nodo ==null) return false;
                if (id.equals(nodo.id)) return true;
                return id.compareTo(nodo.id)< 0 ? buscarLibro(nodo.izquierdo, id): buscarLibro(nodo.derecho, id);
                  
            }
            
              public static NodoLibro agregarLibro(NodoLibro raiz, NodoLibro nuevo){
              if(raiz == null)return nuevo;
              if( nuevo.id.compareTo(raiz.id)< 0) raiz.izquierdo = agregarLibro(raiz.izquierdo, nuevo);
              else raiz.derecho = agregarLibro(raiz.derecho, nuevo);
              return raiz;
              }
             
              
              
              public static NodoLibro eliminarLibro(NodoLibro nodo, String id){
                  if (nodo == null) return null;
                  if(id.compareTo(nodo.id)<0) nodo.izquierdo = eliminarLibro(nodo.izquierdo, id);
                  else if (id.compareTo(nodo.id)>0) nodo.derecho = eliminarLibro (nodo.derecho, id);
                  else{
                      if(nodo.izquierdo == null) return nodo.derecho;
                      if(nodo.derecho == null) return nodo.izquierdo;
                  }
                  return nodo;
              }
              
              public static void listarLibros(NodoLibro nodo){
                  if(nodo != null){
                      listarLibros (nodo.izquierdo);
                      System.out.printf("%-10s %-20s %-20s%n", nodo.id, nodo.nombre, nodo.autor);
                      listarLibros (nodo.derecho);
                  }
              } 
               public static boolean buscarUsuario(NodoUsuario nodo, int cedula){
                if (nodo ==null) return false;
                if (cedula == nodo.cedula) return true;
                return cedula< nodo.cedula ? buscarUsuario(nodo.izquierdo, cedula): buscarUsuario(nodo.derecho, cedula);
                  
            }
             public static NodoUsuario eliminarUsuario(NodoUsuario nodo, int cedula){
                  if (nodo == null) return null;
                  if(cedula<nodo.cedula) nodo.izquierdo = eliminarUsuario(nodo.izquierdo, cedula);
                  else if (cedula>nodo.cedula) nodo.derecho = eliminarUsuario (nodo.derecho, cedula);
                  else{
                      if(nodo.izquierdo == null) return nodo.derecho;
                      if(nodo.derecho == null) return nodo.izquierdo;
                  }
                    return nodo;
              }
                public static void listarUsuarios(NodoUsuario nodo){
                    if(nodo != null){
                        listarUsuarios (nodo.izquierdo);
                        System.out.printf("%-10s %-20s %-20s%n", nodo.cedula, nodo.nombre, nodo.apellido);
                        listarUsuarios (nodo.derecho);
                    }
                } 
                
                public static NodoLibro obtenerLibro(NodoLibro nodo, String id){
                    if(nodo == null) return null;
                    if (id.equals(nodo.id)) return nodo;
                    return id.compareTo(nodo.id)<0 ? obtenerLibro(nodo.izquierdo, id): obtenerLibro(nodo.derecho, id);

                    }
                    
}
