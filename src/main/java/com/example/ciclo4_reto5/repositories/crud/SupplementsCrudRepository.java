package com.example.ciclo4_reto5.repositories.crud;


import com.example.ciclo4_reto5.models.Supplements;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SupplementsCrudRepository extends MongoRepository<Supplements,String> {

    public List<Supplements> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Supplements> findByDescriptionLike(String description);
}
