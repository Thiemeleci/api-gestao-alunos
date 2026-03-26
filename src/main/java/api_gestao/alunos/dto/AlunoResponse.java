package api_gestao.alunos.dto;

import java.time.LocalDate;
import java.util.List;

public record AlunoResponse(
        Long id,
        String nome,
        String telefone,
        LocalDate dataDeNascimento,
        List<MatriculaDTO> matriculas
) {}