
package libreria_JPA;

import java.util.Scanner;
import servicios.AutorServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;


public class Main {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        int opcion = 0;
        LibroServicio libro = new LibroServicio();
        AutorServicio autor = new AutorServicio();
        EditorialServicio editorial = new EditorialServicio();
        while (salir) {
            System.out.println("\033[36m----------MENU PRINCIPAL----------");
            System.out.println("\033[36m1) Menu Libro\n\033[36m2) Menu Autor\n\033[36m3) Menu Editorial\n\033[36m4) Menu Busquedas \n\033[36m5) Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    boolean salirLibro = true;
                    while (salirLibro) {
                        System.out.println("-----MENU LIBRO-----");
                        System.out.println("1) Ingresar Libro\n2) Editar Libro\n3) Eliminar Libro\n4) Listar Libros\n5) Regresar al Menu Principal");
                        int opcionMenuLibro = sc.nextInt();
                        sc.nextLine();
                        switch (opcionMenuLibro) {
                            case 1:
                                libro.ingresarLibro();
                                break;
                            case 2:
                                libro.editarLibro();
                                break;
                            case 3:
                                libro.eliminarLibro();
                                break;
                            case 4:
                                libro.listarLibros();
                                break;
                            case 5:
                                salirLibro = false;
                                break;
                            default:
                                System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }

                    break;
                case 2:
                    boolean salirAutor = true;
                    while (salirAutor) {
                        System.out.println("-----MENU AUTOR-----");
                        System.out.println("1) Ingresar Autor\n2) Editar Autor\n3) Eliminar Autor\n4) Listar Autores\n5) Regresar al Menu Principal");
                        int opcionMenuAutor = sc.nextInt();
                        sc.nextLine();
                        switch (opcionMenuAutor) {
                            case 1:
                                autor.ingresarAutor();
                                break;
                            case 2:
                                autor.editarAutor();
                                break;
                            case 3:
                                autor.eliminarAutor();
                                break;
                            case 4:
                                autor.listarAutor();
                                break;
                            case 5:
                                salirAutor = false;
                                break;
                            default:
                                System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }

                    break;
                case 3:
                    boolean salirEditorial = true;
                    while (salirEditorial) {
                        System.out.println("-----MENU EDITORIAL-----");
                        System.out.println("1) Ingresar Editorial\n2) Editar Editorial\n3) Eliminar Editorial\n4) Listar Editoriales\n5) Regresar al Menu Principal");
                        int opcionMenuEditorial = sc.nextInt();sc.nextLine();
                        
                        switch (opcionMenuEditorial) {
                            case 1:
                                editorial.ingresarEditorial();
                                break;
                            case 2:
                                editorial.editarEditorial();
                                break;
                            case 3:
                                editorial.eliminarEditorial();
                                break;
                            case 4:
                                editorial.listarEditorial();
                                break;
                            case 5:
                                salirEditorial = false;
                                break;
                            default:
                                System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }

                    break;
                case 4:
                    boolean salirMenu = true;
                    while (salirMenu) {
                        System.out.println("-----MENU BUSQUEDAS-----");
                        System.out.println("1) Búsqueda de Autor por nombre\n2) Búsquda de Libro por ISBN\n3) Búsqueda de Libro por Título\n4) Búsqueda de Libro/s por Autor\n5) Búsqueda de Libro/s por Editorial\n6) Regresar al Menu Principal");
                        int opcionBusqueda = sc.nextInt();
                        sc.nextLine();
                        switch (opcionBusqueda) {
                            case 1:
                                autor.buscarAutorNombre();
                                break;
                            case 2:
                                libro.buscarLibroISBN();
                                break;
                            case 3:
                                libro.buscarLibroTitulo();
                                break;
                            case 4:
                                libro.buscarLibroAutor();
                                break;
                            case 5:
                                libro.buscarLibroEditorial();
                                break;
                            case 6:
                                salirMenu = false;
                                break;
                            default:
                                System.out.println("Ingrese una opción valida");
                                break;

                        }
                    }

                    break;
                case 5:
                    salir = false;
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
                    break;

            }

        }
       
      
    }

}
