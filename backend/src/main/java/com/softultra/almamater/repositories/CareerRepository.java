/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softultra.almamater.repositories;

import com.softultra.almamater.models.Career;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Freakzoid
 */
public interface CareerRepository extends CrudRepository<Career, Integer>{
    public List<Career> findAllByOrderByIdAsc();
}
