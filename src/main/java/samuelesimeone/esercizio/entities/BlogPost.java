package samuelesimeone.esercizio.entities;


import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
    private long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private double tempoDiLettura;
}
