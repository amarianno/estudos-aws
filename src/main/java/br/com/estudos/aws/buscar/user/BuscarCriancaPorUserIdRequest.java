package br.com.estudos.aws.buscar.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarCriancaPorUserIdRequest {
    private String userId;
}
