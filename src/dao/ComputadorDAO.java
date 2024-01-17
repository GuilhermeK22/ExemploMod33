package java.br.com.guikpp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.br.com.guikpp.domain.Computador;

public class ComputadorDAO implements IComputadorDAO{
    @Override
    public Computador cadastrar(Computador computador) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(computador);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return computador;
    }
}
