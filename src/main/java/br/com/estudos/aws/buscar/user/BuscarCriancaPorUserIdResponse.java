package br.com.estudos.aws.buscar.user;

import br.com.estudos.aws.Crianca;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarCriancaPorUserIdResponse {

    private long id;
    private String nome;

    public static BuscarCriancaPorUserIdResponse parse(Crianca crianca) {
        return BuscarCriancaPorUserIdResponse
                .builder()
                .id(crianca.getId())
                .nome(crianca.getNome())
                .build();
    }


}
