package com.example.ciclo4_reto5.services;


import com.example.ciclo4_reto5.models.Supplements;
import com.example.ciclo4_reto5.repositories.SupplementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplementsService {
    @Autowired
    private SupplementsRepository supplementsRepository;

    public List<Supplements> getAll() {
        return supplementsRepository.getAll();
    }

    public Optional<Supplements> getReference(String reference){
        return supplementsRepository.getReference(reference);

    }

    public Supplements registrar(Supplements s) {
        if (s.getReference() == null) {
            return s;
        } else {
            return supplementsRepository.save(s);
        }
    }

    public Supplements update(Supplements u){
        if(u.getReference()!=null){
            Optional<Supplements> g= supplementsRepository.getReference(u.getReference());
            if(!g.isEmpty()){
                if(u.getBrand()!=null){
                    g.get().setBrand(u.getBrand());
                }if(u.getCategory()!=null){
                    g.get().setCategory(u.getCategory());
                }if(u.getDescription()!=null){
                    g.get().setDescription(u.getDescription());
                }if(u.getPhotography()!=null){
                    g.get().setPhotography(u.getPhotography());
                }
                return supplementsRepository.save(g.get());
            }
        }
        return u;
    }

    public boolean delete(String id){
        Optional<Supplements> c=getReference(id);
        if(!c.isEmpty()){
            supplementsRepository.delete(c.get());
            return true;
        }
        return false;

    }

    public List<Supplements> productByPrice(double precio) {
        return supplementsRepository.productByPrice(precio);
    }


    public List<Supplements> findByDescriptionLike(String description) {
        return supplementsRepository.findByDescriptionLike(description);
    }



}

