package org.example.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "actor")
public class Actor extends BaseModel{
    String name;
}
