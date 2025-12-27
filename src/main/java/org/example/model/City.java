package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "city")
public class City extends BaseModel{
    String name;
    @OneToMany
    @JoinColumn(name = "city_id")
    List<Theatre> theatres;
}
