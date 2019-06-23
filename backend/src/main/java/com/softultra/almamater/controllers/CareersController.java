package com.softultra.almamater.controllers;

import com.softultra.almamater.models.Career;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.softultra.almamater.repositories.CareerRepository;
import java.util.List;

/**
 *
 * @author Freakzoid
 */
@RestController
@RequestMapping("/careers")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET})
public class CareersController {

    @Autowired
    private CareerRepository careerRepository;
    
    @RequestMapping(method = GET, value = "")
    public @ResponseBody List<Career> all() {
        return careerRepository.findAllByOrderByIdAsc();
    }
}
