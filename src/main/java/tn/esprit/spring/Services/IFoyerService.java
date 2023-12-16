package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer AddFoyer(Foyer f);
    List<Foyer> AddAllFoyer(List<Foyer> ls);
    Foyer editFoyer(Foyer f);
    List<Foyer> findAllFoyer();
    Foyer findByIDFoyer(long id);
    void DeleteByIDFoyer(long id);
    void deleteFoyer(Foyer f);

    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
