package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Etudiant;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Etudiant findByNomEtAndPrenomEt(String nom , String prenom);
    Etudiant findByCin(long cin);
    List<Etudiant> findByDateNaissance(LocalDate date);


}
