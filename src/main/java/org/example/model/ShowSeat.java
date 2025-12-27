package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.model.constants.SeatStatus;

@Data
@Entity(name = "showseat")
public class ShowSeat extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "seat_id")
    Seat seat;

    @ManyToOne
    Show show;

    @Enumerated(EnumType.STRING)
    SeatStatus seatStatus;
    double price;
}
