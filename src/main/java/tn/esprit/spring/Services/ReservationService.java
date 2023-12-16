package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.DAO.Entities.Etudiant;
import tn.esprit.spring.DAO.Entities.Reservation;
import tn.esprit.spring.DAO.Entities.TypeChamber;
import tn.esprit.spring.DAO.Repositories.ChamberRepository;
import tn.esprit.spring.DAO.Repositories.EtudiantRepository;
import tn.esprit.spring.DAO.Repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ReservationService implements IReservationService {
    ReservationRepository reservationRepository ;

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> addAllReservation(List<Reservation> ls) {
        return reservationRepository.saveAll(ls);
    }

    @Override
    public Reservation editReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findByIdReservation(String id) {
        return reservationRepository.findById(id).orElse(Reservation.builder().build());
    }



    ChamberRepository chamberRepository ;
    EtudiantRepository etudiantRepository ;
    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(int numChambre, long cin) {
        int  i;
        int numReservation;
        Etudiant e = etudiantRepository.findByCin(cin);
        System.out.println(e.getNomEt());
        Chamber c = new Chamber() ;
        boolean test = false ;
        //---------------------------------
        LocalDate dateDebutAU;
        LocalDate dateFinAU;
        int year = LocalDate.now().getYear() % 100;
        if (LocalDate.now().getMonthValue() <= 7) {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + (year - 1)), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + year), 6, 30);
        } else {
            dateDebutAU = LocalDate.of(Integer.parseInt("20" + year), 9, 15);
            dateFinAU = LocalDate.of(Integer.parseInt("20" + (year + 1)), 6, 30);
        }
        //---------------------------------
        if(e != null){
            c = chamberRepository.findByNumerochamber(numChambre);

            Set<Reservation> reservations = c.getReservations() ;
            i = (int) reservations.stream().filter(Reservation::getEstValide).count();
            if(c.getTypeC().equals(TypeChamber.Simple)&&i==0){
                test = true ;
            }else if (c.getTypeC().equals(TypeChamber.Double) && i<=1){
                test = true ;
            }else if (c.getTypeC().equals(TypeChamber.Triple) && i<=2){
                test = true ;
            }

        }
        if(!test){
            return new Reservation();
        }else{
            System.out.println("creation Reservation");
            Reservation r = new Reservation();
            r.setIdReservation(dateDebutAU.getYear()+"/"+dateFinAU.getYear()+"-"+c.getBloc().getNomBloc()
                            +"-"+c.getNumerochamber()+"-"+e.getCin());
            r.setAnneeReservation(new Date());
            r.setEstValide(true);

            //chamber hwa il parent
            c.getReservations().add(r);
            chamberRepository.save(c);
            // reservation heya il parent w etudiant how child
            r.getEtudiants().add(e);

            return reservationRepository.save(r);
        }



    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant e = etudiantRepository.findByCin(cinEtudiant);

        return null;
    }

    @Override
    public void deleteById(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void deleteReservation(Reservation r) {
        reservationRepository.delete(r);

    }
}
