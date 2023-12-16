package tn.esprit.spring.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Universite;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    List<Bloc> findByNomBloc(String nomBloc);
    List<Bloc> findByCapaciteBloc(int capacity);
    List<Bloc> findBlocByNomBlocAndCapaciteBloc(String nomBloc , int capacity );
    List<Bloc> findBlocByNomBlocIgnoreCase(String nomBloc);
    List<Bloc> findBlocByCapaciteBlocGreaterThan(int capacity);
    List<Bloc> findBlocByNomBlocContaining(String nomBloc);
    List<Bloc> findAllByOrderByNomBloc();
    List<Bloc> findBlocByNomBlocOrCapaciteBloc(String nomBloc , int capacity);
    List<Bloc> findByFoyer(Foyer f);
  //  List<Bloc> findByFoyerIdFoyer(long idF);
    List<Bloc> findBlocByFoyer_Universite(Universite u);
    List<Bloc> findBlocByFoyer_UniversiteIdUniversite(long idU);
//    List<Bloc> getByNomBloc(String nomBloc);

    Bloc getBlocByNomBloc(String nombloc);

}
