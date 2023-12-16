package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Universite;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
     //Foyer findByBlocs(Bloc bloc);
   // Foyer findFoyerByIdFoyerAndBlocs(int idFoyer , Bloc b);
    List<Foyer> findFoyerByCapaciteFoyer(long capacity);

    Foyer findFoyerByUniversite(Universite u);

    Foyer findFoyerByNomFoyer(String nomFoyer);
}
