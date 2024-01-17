package java.br.com.testes;

import org.junit.Test;

import dao.CursoDAO;
import dao.ICursoDAO;
import domain.Curso;

import static org.junit.Assert.assertNotNull;

public class CursoTest {
    private ICursoDAO cursoDAO;

    public CursoTest() {
            cursoDAO = new CursoDAO();
    }
        @Test
        public void cadastrar() {
            Curso curso = new Curso();
            curso.setCodigo("A1");
            curso.setDescricao("CURSO TESTE");
            curso.setNome("Curso de Java Backend");
            curso = cursoDAO.cadastrar(curso);

            assertNotNull(curso);
            assertNotNull(curso.getId());
        }
}
