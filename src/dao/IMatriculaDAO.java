package java.br.com.guikpp.dao;

import java.br.com.guikpp.domain.Curso;
import java.br.com.guikpp.domain.Matricula;
import java.util.List;

public interface IMatriculaDAO {
    Matricula cadastrar(Matricula mat);

    Matricula buscarPorCodigoCurso(String codigoCurso);

    Matricula buscarPorCurso(Curso curso);

    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

    Matricula buscarPorCursoCriteria(Curso curso);

    List<Matricula> buscarTodos();

    void excluir(Matricula matricula);
}
