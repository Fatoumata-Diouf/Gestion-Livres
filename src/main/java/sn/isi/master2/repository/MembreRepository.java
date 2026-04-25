package sn.isi.master2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.master2.entity.Membre;

public interface MembreRepository extends JpaRepository<Membre,Integer> {

    boolean existsByEmail(String email);
}
