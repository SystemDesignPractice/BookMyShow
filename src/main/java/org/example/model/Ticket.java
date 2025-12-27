package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.model.constants.TicketStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "ticket")
@Data
public class Ticket extends BaseModel {
    double amount;
    LocalDateTime bookingTime;

    @Enumerated(EnumType.STRING)
    TicketStatus ticketStatus;

    //show is the owning side.
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    Show show;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    List<ShowSeat> showSeats;
}
