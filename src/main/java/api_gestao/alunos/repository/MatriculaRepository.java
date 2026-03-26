package api_gestao.alunos.repository;

import api_gestao.alunos.entitie.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
