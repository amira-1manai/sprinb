package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.DAO.Entities.TypeChamber;

import java.util.List;

public interface IChamberService {
    Chamber findByNumerochamberAndTypeC(long numero , TypeChamber type);
    Chamber addChamber(Chamber c);
    List<Chamber> addAllChambers(List<Chamber> ls);
    Chamber editChamber(Chamber c);
    List<Chamber> findAll() ;
    Chamber findById(long id);
    void deleteByID(long id);
    void delete(Chamber c);

    List<Chamber> getChambresParNomBloc( String nomBloc) ;
    void listeChambreParBloc();
    void pourcentageChambreParTypeChambre();
    List<Chamber> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChamber type) ;
    long nbChambreParTypeEtBloc( TypeChamber type, long idBloc) ;
}
