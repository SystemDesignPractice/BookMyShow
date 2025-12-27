package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.model.constants.SeatStatus;
import org.example.model.constants.SeatType;

@Data
@Entity(name = "seat")
public class Seat extends BaseModel {
    String name;
    @Enumerated(EnumType.STRING)
    SeatType seatType;
    @Enumerated(EnumType.STRING)
    SeatStatus seatStatus;
}
