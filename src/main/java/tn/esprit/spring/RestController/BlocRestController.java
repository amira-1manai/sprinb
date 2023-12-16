package tn.esprit.spring.RestController;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.Services.IBlocService;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("BlocRestController")
public class BlocRestController {
    IBlocService iBlocService ;

    @GetMapping("findByNameBloc/{name}")
    List<Bloc> findByBlocName(@PathVariable("name") String blocName){
        return iBlocService.findByNomBloc(blocName);
    }
    @GetMapping("findByCapacityBloc/{capacity}")
    List<Bloc> findByCapacityBloc(@PathVariable("capacity") int capacity){return iBlocService.findByCapacityBloc(capacity);}
    @GetMapping("findByNomBlocandCapacity/{nom}/{capacity}")
    List<Bloc> findByNomBlocandCapacity(@PathVariable("nom") String nom, @PathVariable("capacity") int capacity  ){
        return iBlocService.findByNomBlocAndCapacityBloc(nom ,capacity);
    }
    @GetMapping("findByNomBlocIgnCasse/{nom}")
    List<Bloc> findByNomBlocIgnCasse(@PathVariable("nom") String nom){
        return iBlocService.findByNomBlocIgn(nom);
    }
    @GetMapping("findByCapacityGt/{capacity}")
    List<Bloc> findBlocByCapaciteBlocGreaterThan(@PathVariable("capacity") int capacity){
        return iBlocService.findBlocByCapaciteBlocGreaterThan(capacity);
    }
    @GetMapping("findByNomBlocContaines/{nom}")
    List<Bloc> findBlocByNomBlocContaining(@PathVariable("nom") String nom){
        return iBlocService.findBlocByNomBlocContaining(nom);
    }


    @GetMapping("findAll")
    List<Bloc> findAll(){
        return iBlocService.findAll();
    }

    @PostMapping("addBloc")
    Bloc AddBloc(@RequestBody Bloc b ){

        return iBlocService.addBloc(b);
    }
    @PostMapping("addAllBlocs")
    List<Bloc> addAllBlocs(@RequestBody List<Bloc> b){
        return iBlocService.addAllBlocs(b);
    }

    @PutMapping("editBloc")
    Bloc editBloc(@RequestBody Bloc b){
        return iBlocService.editBloc(b);
    }

    @GetMapping("findById/{id}")
    Bloc findById(@PathVariable("id") long id){
        return iBlocService.findById(id);
    }

    @DeleteMapping("deleteByID/{id}")
    void deleteByID(@PathVariable("id") long id){
        iBlocService.deleteByID(id);
    }

    @DeleteMapping("delete")
    void delete(@RequestBody Bloc b){
        iBlocService.delete(b);
    }

/**********************************/
    @PutMapping("affecterChamberABloc/{nomBloc}")
    Bloc affecterChambresABloc(@RequestBody List<Integer> numeros , @PathVariable("nomBloc") String nomBloc){
        return iBlocService.affecterChambresABloc(numeros , nomBloc);
    }
/****************************/
    @PutMapping("affecterBlocFoyer/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable("nomFoyer") String nomFoyer ,
                            @PathVariable("nomBloc") String nomBloc ){
        return iBlocService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }
}
