package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "movie")
public class Movie extends BaseModel {
    String name;
    //uni directional many to many requires no additional annotation
    @ManyToMany
    List<Actor> actors;
    List<String> language;
}
