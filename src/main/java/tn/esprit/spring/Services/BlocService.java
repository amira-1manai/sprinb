package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Repositories.BlocRepository;
import tn.esprit.spring.DAO.Repositories.ChamberRepository;
import tn.esprit.spring.DAO.Repositories.FoyerRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class BlocService implements IBlocService{
    BlocRepository blocRepository ;
    public List<Bloc> findByNomBloc(String nomBloc){
        return blocRepository.findByNomBloc(nomBloc);
    }

    @Override
    public List<Bloc> findByCapacityBloc(int capacity) {
        return blocRepository.findByCapaciteBloc(capacity);
    }

    @Override
    public List<Bloc> findByNomBlocAndCapacityBloc( String nomBloc , int capacity ) {
        return blocRepository.findBlocByNomBlocAndCapaciteBloc(nomBloc ,capacity );
    }

    @Override
    public List<Bloc> findByNomBlocIgn(String nomBloc) {
        return blocRepository.findBlocByNomBlocIgnoreCase(nomBloc);
    }

    @Override
    public List<Bloc> findBlocByCapaciteBlocGreaterThan(int capacity) {
        return blocRepository.findBlocByCapaciteBlocGreaterThan(capacity);
    }

    @Override
    public List<Bloc> findBlocByNomBlocContaining(String nomBloc) {
        return blocRepository.findBlocByNomBlocContaining(nomBloc);
    }

    @Override
    public List<Bloc> findAllByOrderByNomBloc() {
        return blocRepository.findAllByOrderByNomBloc();
    }

    ChamberRepository chamberRepository ;
    @Override
    public Bloc addBloc(Bloc b) {
        Set<Chamber> ch = b.getChambers();
        Bloc bloc = blocRepository.save(b);
        ch.forEach(chamber -> {
            chamber.setBloc(bloc);
            chamberRepository.save(chamber);
        });
      // List<Chamber> chs = chamberRepository.saveAll(ch);

        return bloc ;
    }

    @Override
    public List<Bloc> addAllBlocs(List<Bloc> ls) {
        return blocRepository.saveAll(ls);
    }

    @Override
    public Bloc editBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(long id) {
        //return blocRepository.findById(id);
        return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0).nomBloc("No Bloc Founded").build());

    }

    @Override
    public void deleteByID(long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public void delete(Bloc b) {
        Set<Chamber> chs = b.getChambers();
        blocRepository.delete(b);
        //chamberRepository.deleteAll(b.getChambers());
        chs.forEach(chamber -> {
            chamberRepository.delete(chamber);
        });

    }

    @Override
    public Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) {
       Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
       numChambre.forEach(numero ->{
           Chamber c = chamberRepository.findByNumerochamber(numero);
           c.setBloc(b);
           chamberRepository.save(c);

       });
       return b ;
    }

    FoyerRepository foyerRepository ;
    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        Foyer f = foyerRepository.findFoyerByNomFoyer(nomFoyer);
        ////////////// PARENT HOWA BLOC
        b.setFoyer(f);
        return blocRepository.save(b);
    }
}
