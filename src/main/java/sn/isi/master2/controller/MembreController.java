package sn.isi.master2.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.master2.dto.MembreDTO;
import sn.isi.master2.service.impl.MembreService;

import java.util.List;

@Tag(name = "Membre", description = "API de gestion des membres")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/membre")
public class MembreController {

    private final MembreService membreService;

    @Operation(summary = "Créer un membre")
    @PostMapping
    ResponseEntity<MembreDTO> save(@RequestBody MembreDTO membre) {
        log.info("Debut de creation d'un membre");
        return ResponseEntity.status(HttpStatus.CREATED).body(this.membreService.save(membre));
    }

    @Operation(summary = "Modifier un membre")
    @PutMapping("/{id}")
    ResponseEntity<MembreDTO> update(@PathVariable int id, @RequestBody MembreDTO membre) {
        log.info("Debut de la modification d'un membre");
        return ResponseEntity.ok(this.membreService.update(id, membre));
    }

    @Operation(summary = "Supprimer un membre")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable int id) {
        log.info("Debut de la suppression du membre {}", id);
        this.membreService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Récupérer un membre par id")
    @GetMapping("/{id}")
    ResponseEntity<MembreDTO> getById(@PathVariable int id) {
        log.info("Debut de la Recherche d'un membre specefique");
        return ResponseEntity.ok(this.membreService.getById(id));
    }

    @Operation(summary = "Récupérer la liste des membres")
    @GetMapping
    ResponseEntity<List<MembreDTO>> getAll() {
        log.info("Liste de tous les membres");
        return ResponseEntity.ok(this.membreService.getAll());
    }


}
