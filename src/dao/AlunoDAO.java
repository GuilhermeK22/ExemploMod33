package java.br.com.guikpp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.br.com.guikpp.domain.Aluno;

public class AlunoDAO implements IAlunoDAO{
    @Override
    public Aluno cadastrar(Aluno aluno) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return aluno;
    }
}
