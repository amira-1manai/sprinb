package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Entities.Universite;
import tn.esprit.spring.DAO.Repositories.FoyerRepository;
import tn.esprit.spring.DAO.Repositories.UniversiteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class FoyerService implements IFoyerService {
    FoyerRepository foyerRepository;

    @Override
    public Foyer AddFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> AddAllFoyer(List<Foyer> ls) {
        return foyerRepository.saveAll(ls);
    }

    @Override
    public Foyer editFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> findAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findByIDFoyer(long id) {
        return foyerRepository.findById(id).orElse(Foyer.builder().build());
    }

    @Override
    public void DeleteByIDFoyer(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void deleteFoyer(Foyer f) {
        foyerRepository.delete(f);

    }

    UniversiteRepository universiteRepository;
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).get();
        foyerRepository.save(foyer);
        u.setFoyer(foyer);
        universiteRepository.save(u);
        return foyer;
    }
}
