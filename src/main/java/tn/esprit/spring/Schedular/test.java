package tn.esprit.spring.Schedular;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.DAO.Entities.Chamber;
import tn.esprit.spring.Services.ChamberService;
import tn.esprit.spring.Services.IChamberService;

@Component
@AllArgsConstructor
@Slf4j
public class test {
IChamberService iChamberService;    /*@Scheduled(fixedRate = 2000)
    void affiche(){
        log.info("sabalkhiir boss -_- ");
    }*/

    /*@Scheduled(fixedRate = 2000)
    void afficheQ(){
        iChamberService.listeChambreParBloc();
    }*/

    @Scheduled(fixedRate = 300000)
    void Display(){
        iChamberService.pourcentageChambreParTypeChambre();
    }
}
