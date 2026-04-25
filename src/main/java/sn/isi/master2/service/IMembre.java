package sn.isi.master2.service;

import sn.isi.master2.dto.MembreDTO;

import java.util.List;

public interface IMembre {

    MembreDTO save(MembreDTO membre);
    MembreDTO update(int id,MembreDTO membre);
    void  delete(int id);
    MembreDTO getById(int id);
    List<MembreDTO> getAll();
}
