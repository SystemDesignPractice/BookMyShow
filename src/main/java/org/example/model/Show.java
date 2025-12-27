package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "show")
public class Show extends BaseModel {
    LocalDateTime startTime;
    LocalDateTime endTime;

    @ManyToOne
    Audi audi;

    @OneToMany(mappedBy = "show")
    List<ShowSeat> showSeats;

    @ManyToOne
    Movie movie;
}
