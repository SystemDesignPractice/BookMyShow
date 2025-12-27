package org.example.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookTicketResponseDto {
    private double totalAmount;
    private LocalDateTime timeOfShow;
    private List<String> seatNumbers;
    private String movieName;
    private String auditoriumName;
}
