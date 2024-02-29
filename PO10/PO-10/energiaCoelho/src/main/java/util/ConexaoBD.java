package util;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoBD {

    private static final String PERSISTENCE_UNIT_NAME = "unit_academico"; // Nome da unidade de persistência conforme o persistence.xml
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para fechar o EntityManagerFactory quando não for mais necessário
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
