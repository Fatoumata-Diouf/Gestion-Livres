package sn.isi.master2.mapper;



import sn.isi.master2.dto.MembreDTO;
import sn.isi.master2.entity.Membre;



public class MembreMapper {

    public static MembreDTO toDTO(Membre membre) {
        return MembreDTO.builder()
                .id(membre.getId())
                .name(membre.getName())
                .email(membre.getEmail())
                .build();
    }

    public static Membre toEntity(MembreDTO membreDTO) {
        return Membre.builder()
                .id(membreDTO.getId())
                .name(membreDTO.getName())
                .email(membreDTO.getEmail())
                .build();
    }
}
