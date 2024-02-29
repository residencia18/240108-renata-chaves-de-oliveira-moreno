package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import energiaCoelho.Cliente;
import util.ConexaoBD;

public class ClienteDAO {
    
    private EntityManager entityManager;
    
    public ClienteDAO() {
        this.entityManager = ConexaoBD.getEntityManager(); // Obtém o EntityManager a partir de uma fábrica
    }

    public void inserirCliente(Cliente cliente) {
        EntityTransaction transaction = entityManager.getTransaction();
        
        try {
            transaction.begin();
            
            entityManager.persist(cliente); // Insere o cliente no banco de dados
            
            transaction.commit();
            
            System.out.println("Cliente inserido com sucesso no banco de dados.");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Falha ao inserir cliente no banco de dados: " + e.getMessage());
        }
    }

    
}
