
package servicios;

import entidades.Editorial;
import java.util.List;
import java.util.Scanner;



public class EditorialServicio {
    GestorServicio gestor = new GestorServicio();
    Scanner sc = new Scanner(System.in);
    
    public void ingresarEditorial(){
         Editorial editorial = new Editorial();
        System.out.println("Ingrese el nombre de la Editorial:");
        editorial.setNombre(sc.nextLine());
        gestor.ingresarEntidad(editorial);
    }
    
    public void editarEditorial(){
        System.out.println("Seleccione la editorial a modificar:");
        listarEditorial();
        int opcion = sc.nextInt();sc.nextLine();
        Editorial editorial = buscarEditorialID(opcion);
        System.out.println("Ingrese el nuevo nombre de la editorial:");
        editorial.setNombre(sc.nextLine());
        gestor.actualizarEntidad(editorial);
    }
    public void eliminarEditorial(){
        System.out.println("Ingrese el numero de Id de la editorial a eliminar:");
        int isbn = sc.nextInt();
        String jpql = "Select a FROM Editorial a WHERE a.id="+isbn;
        Editorial editorial = (Editorial) gestor.listarEntidad(jpql);
        
        if (editorial == null) {
            System.out.println("No hay Editorial para eliminar");
        }else{
            editorial.setAlta(false);
            gestor.actualizarEntidad(editorial);
        }
    }
    
    public void listarEditorial() {
        String sql = "Select a FROM Editorial a";
        List<Editorial> list = gestor.listarEntidades(sql);

        if (list.isEmpty()) {
            System.out.println("No hay Editoriales para mostrar");
        }else{
            for (Editorial a : list) {
                System.out.println(+a.getId() + " ) Nombre: " + a.getNombre());
            }
        }

    }
    public Editorial buscarEditorialID(int id){
        
        String sql = "Select a FROM Editorial a WHERE a.id = "+id;
        Editorial editorial = (Editorial) gestor.listarEntidad(sql);
        return editorial;
    }

}
