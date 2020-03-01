package br.com.estudos.aws.salvarcrianca;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalvarCriancaRequest {
    private String nome;
    private String mes;
    private String ano;
    private String userId;
}
