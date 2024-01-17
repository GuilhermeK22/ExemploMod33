package java.br.com.testes;

import dao.*;
import org.junit.After;
import org.junit.Test;

import java.br.com.guikpp.dao.*;
import domain.Aluno;
import domain.Computador;
import domain.Curso;
import domain.Matricula;
import java.time.Instant;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MatriculaTest {
    private IMatriculaDAO matriculaDAO;

    private ICursoDAO cursoDAO;
    private IAlunoDAO alunoDAO;
    private IComputadorDAO computadorDAO;

    public MatriculaTest() {
        matriculaDAO = new MatriculaDAO();
        cursoDAO = new CursoDAO();
        alunoDAO = new AlunoDAO();
        computadorDAO = new ComputadorDAO();
    }
    @After
    public void end() {
        List<Matricula> list = matriculaDAO.buscarTodos();
        list.forEach(mat -> matriculaDAO.excluir(mat));

        List<Curso> listCursos = cursoDAO.buscarTodos();
        listCursos.forEach(cur -> cursoDAO.excluir(cur));
    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("A1");
        Aluno aluno = criarAluno("A1");
        Computador comp = criarComputador("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat.setAluno(aluno);
        aluno.setMatricula(mat);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());
    }

    private Computador criarComputador(String codigo) {
        Computador comp = new Computador();
        comp.setCodigo(codigo);
        comp.setDescricao("Comp 1");
        return comp;
        //return computadorDAO.cadastrar(comp);
    }

    private Aluno criarAluno(String codigo) {
        Computador comp = criarComputador("A1");
        Computador comp2 = criarComputador("A2");
        Aluno aluno = new Aluno();
        aluno.setCodigo(codigo);
        aluno.setNome("Guilherme");
        aluno.add(comp);
        aluno.add(comp2);
        //comp.add(aluno);
        //comp2.add(aluno);
        return alunoDAO.cadastrar(aluno);
    }

    @Test
    public void pesquisarPorCurso() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCurso(curso);
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    @Test
    public void pesquisarPorCodigoCurso() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCodigoCurso(curso.getCodigo());
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    @Test
    public void pesquisarPorCodigoCursoCriteria() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCodigoCursoCriteria(curso.getCodigo());
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    @Test
    public void pesquisarPorCursoCriteria() {
        Curso curso = criarCurso("A1");
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("ATIVA");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat = matriculaDAO.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());

        Matricula matricBD = matriculaDAO.buscarPorCursoCriteria(curso);
        assertNotNull(matricBD);
        assertEquals(mat.getId(), matricBD.getId());
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        return cursoDAO.cadastrar(curso);
    }
}
