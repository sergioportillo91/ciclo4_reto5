package com.example.ciclo4_reto5.repositories;
import java.util.List;
import java.util.Optional;


import com.example.ciclo4_reto5.models.Accessory;
import com.example.ciclo4_reto5.repositories.crud.AccessoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author desaextremo
 */
@Repository
public class AccesoryRepository {
    @Autowired
    private AccessoryCrudRepository accesoryCrudRepository;

    public List<Accessory> getAll() {
        return accesoryCrudRepository.findAll();
    }

    public Optional<Accessory> getAccesory(String reference) {
        return accesoryCrudRepository.findById(reference);
    }
    
    public Accessory create(Accessory accesory) {
        return accesoryCrudRepository.save(accesory);
    }

    public void update(Accessory accesory) {
        accesoryCrudRepository.save(accesory);
    }
    
    public void delete(Accessory accesory) {
        accesoryCrudRepository.delete(accesory);
    }
}
