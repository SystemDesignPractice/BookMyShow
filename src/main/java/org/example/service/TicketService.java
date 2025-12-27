package org.example.service;

import org.example.dto.BookTicketRequestDto;
import org.example.dto.BookTicketResponseDto;
import org.example.exception.SeatNotAvailableException;
import org.example.model.ShowSeat;
import org.example.model.Ticket;
import org.example.model.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) throws SeatNotAvailableException;
}
