package com.api.groupquiz.controleur;

import com.api.groupquiz.entity.Utilisateur;
import com.api.groupquiz.service.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/utilisateur")
@AllArgsConstructor
public class UtilisateurControleur {
    private final UtilisateurService utilisateurService;
    @PostMapping("/create")
    public Utilisateur create (@RequestBody Utilisateur utilisateur){
        return utilisateurService.create(utilisateur);
    }
    @GetMapping("/read")
    public List<Utilisateur> read(){
        return utilisateurService.read();
    }
    @PutMapping("/update/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.update(id,utilisateur);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return utilisateurService.delete(id);
    }
    @GetMapping("/read/{id}")
    public Optional<Utilisateur> readById(@PathVariable Long id){
        return utilisateurService.readById(id);
    }

}
