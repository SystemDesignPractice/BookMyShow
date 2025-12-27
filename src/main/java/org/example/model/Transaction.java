package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "transaction")
public class Transaction extends BaseModel{
    LocalDateTime transactionTime;
    @ManyToOne
    Payment payment;
}
