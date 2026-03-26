package api_gestao.alunos.dto;

import java.time.LocalDate;

public record MatriculaDTO(double codigoMatricula, String nomeCurso, LocalDate dataInicio) {
}
