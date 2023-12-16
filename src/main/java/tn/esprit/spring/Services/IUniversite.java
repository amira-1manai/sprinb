package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Universite;

public interface IUniversite {
    Universite addUniversite(Universite u);
    void deleteUniversite(Universite u);


    Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite(long idUniversite);

}
