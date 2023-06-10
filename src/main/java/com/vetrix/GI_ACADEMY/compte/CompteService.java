package com.vetrix.GI_ACADEMY.compte;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompteService implements UserDetailsService {
    private final CompteRepository repository;

    public CompteService(CompteRepository repository) {
        this.repository = repository;
    }

    public Compte createCompte(Compte compte){
        return repository.save(compte);
    }


    public List<Compte> getAllEnseignant(){
        return repository.findAllByRole(Role.ENSEIGNANT);
    }
    public List<Compte> getAllStudent(){
        return repository.findAllByRole(Role.ETUDIANT);
    }
    public Compte getAdmin(){
        return repository.findAllByRole(Role.ADMIN).get(0);
    }
    public Compte getCompteById(UUID id){
        return repository.findById(id).get();
    }



    public Compte updateUser(UUID id, Compte compte){
        repository.findById(id).map(ens ->{
            ens.setLastName(compte.getLastName());
            ens.setFirstName(compte.getFirstName());
            ens.setPhone(compte.getPhone());
            ens.setEmail(compte.getEmail());
            ens.setAdresse(compte.getAdresse());
            ens.setNiveau(compte.getNiveau());
            return repository.save(ens);
        });
        return compte;
    }
    public void modifiesPassword(UUID id, Compte compte){
        repository.findById(id).map(ens ->{
            ens.setPassword(compte.getPassword());
            return repository.save(ens);
        });
    }
    public Compte getCompteByEmail(String email){
        return repository.findByEmail(email);
    }
    public void deleteCompte(UUID id){
        repository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Compte compte = repository.findByEmail(email);
        return new User(compte.getEmail(), compte.getPassword(), new ArrayList<>());
    }
}
