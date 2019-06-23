/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softultra.almamater.repositories;

import com.softultra.almamater.models.University;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Freakzoid
 */
public interface UniversityRepository extends CrudRepository<University, Integer>{
    public List<University> findAllByOrderByIdAsc();
    
    Optional<University> findById(int id);
}
