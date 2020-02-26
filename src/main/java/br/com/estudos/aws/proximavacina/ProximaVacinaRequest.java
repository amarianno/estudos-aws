package br.com.estudos.aws.proximavacina;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProximaVacinaRequest {
    private String nomeCrianca;
}
