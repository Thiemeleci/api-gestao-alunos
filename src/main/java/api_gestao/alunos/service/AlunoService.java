package api_gestao.alunos.service;

import api_gestao.alunos.dto.AlunoRequest;
import api_gestao.alunos.dto.AlunoResponse;
import api_gestao.alunos.dto.MatriculaDTO;
import api_gestao.alunos.entitie.Aluno;
import api_gestao.alunos.entitie.Matricula;
import api_gestao.alunos.mapper.AlunoMapper;
import api_gestao.alunos.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoResponse salvar(AlunoRequest request) {
        Aluno aluno = alunoMapper.toEntity(request);
        aluno = alunoRepository.save(aluno);
        return alunoMapper.toResponse(aluno);
    }

    public List<AlunoResponse> listarTodos() {
        return alunoRepository.findAll().stream().map(alunoMapper::toResponse).toList();
    }

    public List<MatriculaDTO> listarMatriculas(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        return aluno.getMatriculas().stream().map(m -> new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();
    }

    public void remover(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new EntityNotFoundException("Id do aluno não encontrado");
        }
        alunoRepository.deleteById(id);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno a = alunoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        a.setNome(request.nome());
        a.setTelefone(request.telefone());
        a.setDataDeNascimento(request.dataDeNascimento());

        for (MatriculaDTO m: request.matriculas()) {
            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(m.codigoMatricula());
            matricula.setDataInicio(m.dataInicio());
            matricula.setNomeCurso(m.nomeCurso());
            a.getMatriculas().add((matricula));
        }
        return alunoMapper.toResponse(alunoRepository.save(a));
    }
}
