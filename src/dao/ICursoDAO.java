package java.br.com.guikpp.dao;

import java.br.com.guikpp.domain.Curso;
import java.util.List;

public interface ICursoDAO {
    public Curso cadastrar(Curso curso);

    public void excluir(Curso cur);

    public List<Curso> buscarTodos();
}
