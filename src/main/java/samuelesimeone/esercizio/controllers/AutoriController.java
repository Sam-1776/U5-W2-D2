package samuelesimeone.esercizio.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import samuelesimeone.esercizio.entities.Autore;
import samuelesimeone.esercizio.services.AutoriService;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoriController {

    @Autowired
    AutoriService autoriService;

    @GetMapping
    public List<Autore> getAll(){
        return this.autoriService.getAll();
    }

    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable long id){
        return this.autoriService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autore save(@RequestBody Autore autore){
        return this.autoriService.save(autore);
    }

    @PutMapping("/{id}")
    public Autore update(@PathVariable long id, @RequestBody Autore autoreUp){
        return this.autoriService.update(id, autoreUp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        this.autoriService.delete(id);
    }
}
