package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.DAO.Entities.TypeChamber;
import tn.esprit.spring.DAO.Repositories.BlocRepository;
import tn.esprit.spring.DAO.Repositories.ChamberRepository;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ChamberService implements IChamberService{
    ChamberRepository chamberRepository;
    BlocRepository blocRepository;

    public void pourcentageChambreParTypeChambre(){
        String[] Typec =new String[3];

        int nbSimple = chamberRepository.countChamberByTypeC(TypeChamber.Simple);
        int nbDoube = chamberRepository.countChamberByTypeC(TypeChamber.Double);
        int nbTriple = chamberRepository.countChamberByTypeC(TypeChamber.Triple);
        long allChamber = chamberRepository.count();
        log.info("Nombre Total des chambers:"+allChamber);
        log.info("le prourcentage des chambres pour le type Simple est égale"+nbSimple/allChamber*100);
        log.info("le prourcentage des chambres pour le type Double est égale"+nbDoube/allChamber*100);
        log.info("le prourcentage des chambres pour le type Triple est égale"+nbTriple/allChamber*100);
    }
    public void listeChambreParBloc(){
        List<Bloc> blocs = blocRepository.findAll();
        blocs.forEach(bloc -> {
            log.info(" Bloc => "+ bloc.getNomBloc()+" ayant une capacite "+bloc.getCapaciteBloc());
            if(bloc.getChambers().isEmpty()){
                log.info("Pas de chamber disponible dans ce bloc");
            }else{
                bloc.getChambers().forEach(chamber -> {
                    log.info("NumChamber"+chamber.getNumerochamber()+" type : "+chamber.getTypeC());
                    log.info("la liste des Chambres pour ce bloc ");

                });
            }
            log.info("*******************************");
        });
    }
    @Override
    public Chamber findByNumerochamberAndTypeC(long numero, TypeChamber type) {
        return chamberRepository.findByNumerochamberAndTypeC(numero , type);
    }

    @Override
    public Chamber addChamber(Chamber c) {
        return chamberRepository.save(c) ;
    }

    @Override
    public List<Chamber> addAllChambers(List<Chamber> ls) {
        return chamberRepository.saveAll(ls);
    }

    @Override
    public Chamber editChamber(Chamber c) {
        return chamberRepository.save(c);
    }

    @Override
    public List<Chamber> findAll() {
        return chamberRepository.findAll();
    }

    @Override
    public Chamber findById(long id) {
        return chamberRepository.findById(id).orElse(Chamber.builder().idChamber(0).numerochamber(0).build());
    }

    @Override
    public void deleteByID(long id) {
        chamberRepository.deleteById(id);

    }

    @Override
    public void delete(Chamber c) {
        chamberRepository.delete(c);

    }
    @Override
    public List<Chamber> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepository.getBlocByNomBloc(nomBloc);
        return chamberRepository.findByBloc(b) ;
    }

    @Override
    public List<Chamber> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChamber type) {
        return chamberRepository.findChamberByBlocFoyerNomFoyerAndTypeCAndReservations_Empty(nomFoyer,type);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChamber type, long idBloc) {
        Bloc b = blocRepository.findById(idBloc).get();
        int c = chamberRepository.countChamberByTypeCAndBloc_IdBloc(type , idBloc);
        return c;
    }
}
