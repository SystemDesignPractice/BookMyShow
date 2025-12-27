package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "theatre")
public class Theatre extends BaseModel{
    String name;

    // Bidirectional mapping between theatres and audis
    @OneToMany(mappedBy = "theatre")
    List<Audi> audis;
    String address;
}
