package br.com.estudos.aws.proximavacina;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProximaVacinaResponse {
    private String nomeCrianca;
    private String nomeVacina;
    private String dia;
    private String mes;
    private String ano;
}
