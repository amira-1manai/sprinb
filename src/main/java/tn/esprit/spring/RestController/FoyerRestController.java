package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.Services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerRestController {
    IFoyerService iFoyerService;

    @GetMapping("findAllFoyer")
    List<Foyer> findAll(){
        return iFoyerService.findAllFoyer();
    }

    @GetMapping("findByIdFoyer/{id}")
    Foyer findbyIdFoyer(@PathVariable("id") long id){
        return iFoyerService.findByIDFoyer(id);
    }

    @PostMapping("AddFoyer")
    Foyer AddFoyer(@RequestBody Foyer f){
        return iFoyerService.AddFoyer(f);
    }

    @PostMapping("AddAllFoyer")
    List<Foyer> AddAllFoyer(@RequestBody List<Foyer> ls){
        return iFoyerService.AddAllFoyer(ls);
    }

    @PutMapping("UpdateFoyer")
    Foyer updateFoyer(@RequestBody Foyer f){
        return iFoyerService.editFoyer(f);
    }

    @DeleteMapping("DeleteFoyerByID/{id}")
    void DeleteFoyerByID(@PathVariable("id") long id){
        iFoyerService.DeleteByIDFoyer(id);
    }

    @DeleteMapping("DeleteFoyer")
    void DeleteFoyer(@RequestBody Foyer f){
        iFoyerService.deleteFoyer(f);
    }

    @PostMapping("ajouterFoyerEtAffecterAUniversite/{id}")
    Foyer ajouterFoyerEtAffecterAUniversite(@PathVariable("id") long id , @RequestBody Foyer foyer){
        return  iFoyerService.ajouterFoyerEtAffecterAUniversite(foyer , id);
    }
}
