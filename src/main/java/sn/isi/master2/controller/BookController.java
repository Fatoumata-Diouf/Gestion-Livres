package sn.isi.master2.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.master2.dto.BookDTO;
import sn.isi.master2.service.impl.BookService;

import java.util.List;

@Tag(name = "Book", description = "API de gestion des livres")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;


    @Operation(summary = "Créer un livre")
    @PostMapping
    ResponseEntity<BookDTO> save(@RequestBody BookDTO book){
        log.info("Start create book controller {}",book);
       return ResponseEntity.status(HttpStatus.CREATED).body(this.bookService.save(book)) ;
    }

    @Operation(summary = "Modifier un livre")
    @PutMapping("/{id}")
    BookDTO update(@PathVariable int id,@RequestBody BookDTO book){
        return this.bookService.update(id,book);
    }

    @Operation(summary = "Supprimer un livre")
    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        this.bookService.delete(id);
    }

    @Operation(summary = "Récupérer un livre par id")
    @GetMapping("/{id}")
    BookDTO getById(@PathVariable int id){
       return  this.bookService.getById(id);
    }

    @Operation(summary = "Récupérer la liste des livres")
    @GetMapping
    List<BookDTO> getAll(){
        return this.bookService.getAll();
    }



}
