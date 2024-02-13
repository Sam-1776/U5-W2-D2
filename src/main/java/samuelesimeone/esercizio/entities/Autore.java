package samuelesimeone.esercizio.entities;


import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Autore {
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
}
