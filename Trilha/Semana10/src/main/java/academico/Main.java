package academico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
	Estudante e1 = new Estudante(null,"Renata","renatachom.@gmail.com", "1234");
	Estudante e2 = new Estudante(null,"Sam","sam@gmail.com", "456");
	Estudante e3 = new Estudante(null,"Biel","biel@gmail.com", "789");
	
	EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("com.renatachom.aula");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	em.persist(e1);
	em.persist(e2);
	em.persist(e3);
	em.getTransaction().commit();
	em.close();
	emf.close();
	}
}
