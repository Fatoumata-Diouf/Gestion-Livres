package sn.isi.master2.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.isi.master2.dto.MembreDTO;
import sn.isi.master2.entity.Membre;
import sn.isi.master2.exception.AlreadyExistException;
import sn.isi.master2.exception.NotfoundBookException;
import sn.isi.master2.mapper.BookMapper;
import sn.isi.master2.mapper.MembreMapper;
import sn.isi.master2.repository.MembreRepository;
import sn.isi.master2.service.IMembre;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MembreService implements IMembre {

    private final MembreRepository membreRepository;

    @Override
    public MembreDTO save(MembreDTO membre) {
        log.info("Sauvegarde du membre : {}", membre.getName());

        if (membreRepository.existsByEmail(membre.getEmail())) {
            throw new AlreadyExistException("Un membre avec l'email " + membre.getEmail() + " existe déjà !");
        }

        return MembreMapper.toDTO(membreRepository.save(MembreMapper.toEntity(membre)));
    }

    @Override
    public MembreDTO update(int id, MembreDTO membre) {
        log.info("Modification du membre : {}", membre.getName());
        if(getById(id)!=null){
            membre.setId(id);
        }
        return MembreMapper.toDTO(membreRepository.save(MembreMapper.toEntity(membre)));
    }

    @Override
    public void delete(int id) {
        log.info("Suppression du membre : {}", id);
        getById(id);
        membreRepository.deleteById(id);
        log.info("Suppression reussi");
    }

    @Override
    public MembreDTO getById(int id) {
        log.info("Recherche d'un membre specefifique");
        Membre membre = membreRepository.findById(id)
                .orElseThrow(() -> new NotfoundBookException("id n'existe pas"));

        return MembreMapper.toDTO(membre);
    }

    @Override
    public List<MembreDTO> getAll() {
        log.info("Liste de tous les membres");
        return membreRepository.findAll().stream().map(MembreMapper::toDTO).toList();
    }
}
