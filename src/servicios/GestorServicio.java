
package servicios;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class GestorServicio {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
    
    
    public void ingresarEntidad(Object objeto){
        
            EntityManager em = emf.createEntityManager();
        try {
            
            em.getTransaction().begin();
            em.persist(objeto); 
            em.flush(); // limpiar la conexion
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();//cerrar la conexion
    }
    
    public void actualizarEntidad(Object objeto){
        EntityManager em = emf.createEntityManager();
        try {
            
            em.getTransaction().begin();
            em.merge(objeto); 
            em.flush(); // limpiar la conexion
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();//cerrar la conexion
    }
    
    public void eliminarEntidad(Object objeto){
        EntityManager em = emf.createEntityManager();
        try {
            
            em.getTransaction().begin();
            em.remove(objeto); 
            em.flush(); // limpiar la conexion
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();//cerrar la conexion
    }
    
    public List listarEntidades(String string){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(string);
        List<Object> list = (List<Object>) query.getResultList();
        return list;
    }
    
    public Object listarEntidad(String string){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery(string);
        Object objeto = query.getSingleResult();
        return objeto;
    }

}
