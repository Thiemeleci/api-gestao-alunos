package api_gestao.alunos.repository;

import api_gestao.alunos.entitie.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
