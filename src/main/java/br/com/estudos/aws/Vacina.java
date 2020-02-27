package br.com.estudos.aws;

import lombok.*;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vacina {

    private String nome;
    private LocalDate quandoTomar;

    public String doenca;
    public String dose;
    public boolean tomou;
    public String oQueE;
    public String administracao;
    public String efeitosAdversosPossiveis;
    public long meses;


    public String resumo(LocalDate dataNascimento) {

        LocalDate quantoTomarVacina = dataNascimento.plusMonths(meses);

        return String.format("A vacina %s a partir de %s de %s <break time=\"0.5s\"",
                nome,
                quantoTomarVacina.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")),
                quantoTomarVacina.getYear() + "");
    }

}
