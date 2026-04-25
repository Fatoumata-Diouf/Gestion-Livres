package sn.isi.master2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.master2.entity.Membre;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDTO {
    private Integer id;
    private String titre;
    private String auteur ;
    private Double price;
    private boolean disponible;
}
