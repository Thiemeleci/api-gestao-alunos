package api_gestao.alunos.mapper;


import api_gestao.alunos.dto.AlunoRequest;
import api_gestao.alunos.dto.AlunoResponse;
import api_gestao.alunos.dto.MatriculaDTO;
import api_gestao.alunos.entitie.Aluno;
import api_gestao.alunos.entitie.Matricula;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AlunoMapper {

    public Aluno toEntity(AlunoRequest request) {
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setDataDeNascimento(request.dataDeNascimento());
        aluno.setTelefone(request.telefone());

        List<Matricula> matriculas = request.matriculas().stream().map(m -> {

            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(m.codigoMatricula());
            matricula.setDataInicio(m.dataInicio());
            matricula.setNomeCurso(m.nomeCurso());
            matricula.setAluno(aluno);

            return matricula;

        }).toList();
        aluno.setMatriculas(matriculas);
        return aluno;
    }

    public AlunoResponse toResponse(Aluno aluno) {
        List<MatriculaDTO> matriculaDTOS = aluno.getMatriculas().stream().map( m ->
                new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getTelefone(), aluno.getDataDeNascimento(), matriculaDTOS);
    }
}
