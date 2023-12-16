package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.DAO.Entities.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

  //  List<Reservation> findByEstValide();
   // List<Reservation> findByEtu(Etudiant e);

    //List<Reservation> findByAnneeReservationAndEstValide(int annee , Boolean valide);

}
