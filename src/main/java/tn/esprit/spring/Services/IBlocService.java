package tn.esprit.spring.Services;

import tn.esprit.spring.DAO.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> findByNomBloc(String nomBloc);
    List<Bloc> findByCapacityBloc(int capacity);
    List<Bloc> findByNomBlocAndCapacityBloc(String nomBloc , int capacity );
    List<Bloc> findByNomBlocIgn(String nomBloc);
    List<Bloc> findBlocByCapaciteBlocGreaterThan(int capacity);
    List<Bloc> findBlocByNomBlocContaining(String nomBloc);
    List<Bloc> findAllByOrderByNomBloc();
    Bloc addBloc(Bloc b);
    List<Bloc> addAllBlocs(List<Bloc> ls) ;
    Bloc editBloc(Bloc b) ;
    List<Bloc> findAll();
    Bloc findById(long id);
    void deleteByID(long id);
    void delete(Bloc b) ;

    Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) ;

    Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer) ;


}
