package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "user_table")
@Data
public class User extends BaseModel {
    String email;
    String name;
    @OneToMany
    @JoinColumn(name = "user_id")
    List<Ticket> tickets;
    String phone;
}
