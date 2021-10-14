
package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;



public class AutorServicio {
    GestorServicio gestor = new GestorServicio();
    Scanner sc = new Scanner(System.in);
    
    public void ingresarAutor(){
        Autor autor = new Autor();
        System.out.println("Ingrese el nombre del autor:");
        autor.setNombre(sc.nextLine());
        gestor.ingresarEntidad(autor);
    }
    
    public void editarAutor(){
        System.out.println("Seleccione el autor a modificar");
        listarAutor();
        int opcion = sc.nextInt();sc.nextLine();
        Autor autor = buscarAutorID(opcion);
        System.out.println("Escriba el nuevo nombre del autor:");
        autor.setNombre(sc.nextLine());
        gestor.actualizarEntidad(autor);
    }
    
    public void eliminarAutor(){
        System.out.println("Ingrese el numero de Id del Autor a eliminar:");
        int isbn = sc.nextInt();
        String jpql = "Select a FROM Autor a WHERE a.id="+isbn;
        Autor autor = (Autor) gestor.listarEntidad(jpql);
        
        if (autor == null) {
            System.out.println("No hay Autor para eliminar");
        }else{
            autor.setAlta(false);
            gestor.actualizarEntidad(autor);
        }
        
    }
    public void listarAutor() {
        String jpql = "Select a FROM Autor a";
        List<Autor> list = gestor.listarEntidades(jpql);

        if (list.isEmpty()) {
            System.out.println("No hay autores para mostrar");
        }else{
            for (Autor a : list) {
                System.out.println(+a.getId() + " ) Nombre: " + a.getNombre());
            }
        }

    }
    
    public Autor buscarAutorID(int id){
        
        String jpql = "Select a FROM Autor a WHERE a.id = "+id;
        Autor autor = (Autor) gestor.listarEntidad(jpql);
        return autor;
    }
    
    public void buscarAutorNombre(){
        System.out.println("Indique el nombre completo del autor");
        String nombre = sc.nextLine();
        String jpql = "Select a FROM Autor a WHERE a.nombre IN ('"+nombre+"')";
        List<Autor> list =  gestor.listarEntidades(jpql);
        
        if (list.isEmpty()) {
            System.out.println("No hay autores para mostrar");
        }else{
            for (Autor a : list) {
                System.out.println("Id: "+a.getId() + " Nombre: " + a.getNombre());
            }
        }
        
        
    }

}
