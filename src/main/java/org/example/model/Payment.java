package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.model.constants.PaymentMethod;
import org.example.model.constants.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "payment")
public class Payment extends BaseModel{
    LocalDateTime paymentTime;
    double amount;

    @OneToMany(mappedBy = "payment")
    List<Transaction> transactions;

    // Uni directional
    // many because there can be failed payments
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    Ticket ticket;

    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;
}
