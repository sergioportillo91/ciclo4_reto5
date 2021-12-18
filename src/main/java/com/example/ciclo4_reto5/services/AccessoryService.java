package com.example.ciclo4_reto5.services;



import com.example.ciclo4_reto5.models.Accessory;
import com.example.ciclo4_reto5.repositories.AccesoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author desaextremo
 */
@Service
public class AccessoryService {

    @Autowired
    private AccesoryRepository accesoryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Accessory> getAll() {
        return accesoryRepository.getAll();
    }

    public Optional<Accessory> getAccesory(String reference) {
        return accesoryRepository.getAccesory(reference);
    }

    public Accessory create(Accessory accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return accesoryRepository.create(accesory);
        }
    }

    public Accessory update(Accessory accesory) {

        if (accesory.getReference() != null) {
            Optional<Accessory> accesoryDb = accesoryRepository.getAccesory(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getObjetivo() != null) {
                    accesoryDb.get().setObjetivo(accesory.getObjetivo());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                accesoryRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getAccesory(reference).map(accesory -> {
            accesoryRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
