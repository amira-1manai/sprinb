package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation r);
    List<Reservation> addAllReservation(List<Reservation> ls);
    Reservation editReservation(Reservation r);

    List<Reservation> findAllReservations();

    Reservation findByIdReservation(String id);
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (int numChambre, long cin) ;
    Reservation annulerReservation (long cinEtudiant) ;
    void deleteById(String id);
    void deleteReservation(Reservation r);
}
