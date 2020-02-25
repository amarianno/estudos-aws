package br.com.estudos.aws;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriancaRequest {
    private String nome;
}
