package org.example.contoller;

import org.example.dto.BookTicketRequestDto;
import org.example.dto.BookTicketResponseDto;
import org.example.exception.SeatNotAvailableException;
import org.example.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) throws SeatNotAvailableException {
        BookTicketResponseDto bookTicketResponseDto = ticketService.bookTicket(bookTicketRequestDto);
        return ResponseEntity.ok(bookTicketResponseDto);
    }
}
