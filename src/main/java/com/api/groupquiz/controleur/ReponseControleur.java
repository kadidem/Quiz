package com.api.groupquiz.controleur;

import com.api.groupquiz.entity.Reponse;
import com.api.groupquiz.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reponse")
@AllArgsConstructor
public class ReponseControleur {
    private final UtilisateurRepository.ReponseService reponseService;
    @PostMapping("/create")
    public Reponse create (@RequestBody Reponse reponse){
        return reponseService.create(reponse);
    }
    @GetMapping
    public List<Reponse> read(){
        return reponseService.read();
    }
    @PutMapping("/update/{id}")
    public Reponse update(@PathVariable Long id, @RequestBody Reponse reponse){
        return reponseService.update(id,reponse);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return reponseService.delete(id);
    }
    @GetMapping("/{id}")
    public Optional<Reponse> readById(@PathVariable Long id){
        return reponseService.readById(id);
    }
}
