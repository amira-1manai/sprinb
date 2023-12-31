package tn.esprit.spring.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Entities.Reservation;
import tn.esprit.spring.Services.IReservationService;

import java.util.List;
@RestController
@AllArgsConstructor
public class ReservationRestController {
    IReservationService iReservationService;

    @GetMapping("findAllReservation")
    List<Reservation> findAll(){
        return iReservationService.findAllReservations();
    }

    @GetMapping("findReservationByID/{id}")
    Reservation findbyIDReservation(@PathVariable("id") String id){
        return iReservationService.findByIdReservation(id);
    }

    @PostMapping("addReservation")
    Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }

    @PostMapping("addAllReservation")
    List<Reservation> addAllReservation(@RequestBody List<Reservation> ls){
        return  iReservationService.addAllReservation(ls);
    }

    @PutMapping("updateReservation")
    Reservation updateReservation(@RequestBody Reservation r){
        return iReservationService.editReservation(r);
    }

    @DeleteMapping("DeleteReservation/{id}")
    void DeleteReservationByID(@PathVariable("id") String id){
        iReservationService.deleteById(id);
    }

    @DeleteMapping("DeleteReservation")
    void DeleteReservation(@RequestBody Reservation r){
        iReservationService.deleteReservation(r);
    }

        @PostMapping("generateReservation/{numchamber}/{cin}")
    Reservation addReseravationavecChamber(@PathVariable("numchamber") int numero ,  @PathVariable("cin") long cin){
        return iReservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(numero, cin);
    }
}
