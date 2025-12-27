package org.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDto {
    private List<Integer> seatIds;
    private int userId;
}