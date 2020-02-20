package br.com.estudos.aws;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Crianca {
    private long id;
    private String nome;
    private String dataNascimento;
}
