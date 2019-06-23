package com.softultra.almamater.controllers;

import java.util.List;
import com.softultra.almamater.models.University;
import com.softultra.almamater.repositories.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.softultra.almamater.exceptions.NotFoundException;

/**
 *
 * @author Freakzoid
 */
@RestController
@RequestMapping("/universities")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class UniversityController {
    
    @Autowired
    private UniversityRepository universityRepository;

    @RequestMapping(method = GET, value = "")
    public @ResponseBody List<University> getAllUniversities() {
        return universityRepository.findAllByOrderByIdAsc();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public @ResponseBody University getUniversityById(@PathVariable("id") int id) {
        return universityRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("University %d not found", id)));
    }
}
