package com.softultra.almamater.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 *
 * @author Jsilva
 */
@Entity
public class Career {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    
    @Transient
    @ManyToMany(mappedBy = "careers")
    Set<University> universities;

    @JsonIgnore
    @JsonProperty(value = "universities")
    public Set<University> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<University> universities) {
        this.universities = universities;
    }

    public Career() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Career [id=" + id + ", name=" + name + "]";
    }

    
    
}
