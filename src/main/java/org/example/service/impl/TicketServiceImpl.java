package org.example.service.impl;

import org.example.dto.BookTicketRequestDto;
import org.example.dto.BookTicketResponseDto;
import org.example.exception.SeatNotAvailableException;
import org.example.model.Show;
import org.example.model.ShowSeat;
import org.example.model.Ticket;
import org.example.model.User;
import org.example.model.constants.SeatStatus;
import org.example.model.constants.TicketStatus;
import org.example.repository.ShowSeatRepository;
import org.example.repository.TicketRepository;
import org.example.repository.UserRepository;
import org.example.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) throws SeatNotAvailableException {

        List<Integer> showSeatIds = bookTicketRequestDto.getSeatIds();
        User user = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        // First check seats are available..
        for(int id:showSeatIds){
            ShowSeat seat = showSeatRepository.findById(id).get();
            if(seat.getSeatStatus() != SeatStatus.AVAILABLE){
                throw new SeatNotAvailableException("Seat not available");
            }
        }

        List<ShowSeat> showSeats = new ArrayList<>();
        List<String> seatNumbers = new ArrayList<>();
        Show show = new Show();
        int totalAmount = 0;
        // Lock the seat
        for(int id:showSeatIds){
            ShowSeat seat = showSeatRepository.findById(id).get();
            seat.setSeatStatus(SeatStatus.LOCKED);
            totalAmount += seat.getPrice();
            showSeats.add(seat);
            seatNumbers.add(seat.getSeat().getName());
            show = seat.getShow();
            showSeatRepository.save(seat);
        }

        // Generate Ticket
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        ticket.setBookingTime(LocalDateTime.now());
        ticket.setAmount(totalAmount);
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        Ticket bookedTicket = ticketRepository.save(ticket);

        // Add booking for the user
        List<Ticket> bookedTickets = user.getTickets();
        bookedTickets.add(bookedTicket);
        user.setTickets(bookedTickets);
        userRepository.save(user);

        // Pay for the seat

        BookTicketResponseDto responseDto = new BookTicketResponseDto();
        responseDto.setSeatNumbers(seatNumbers);
        responseDto.setTotalAmount(totalAmount);
        responseDto.setAuditoriumName(show.getAudi().getName());
        responseDto.setTimeOfShow(show.getStartTime());
        responseDto.setMovieName(show.getMovie().getName());

        return responseDto;
    }
}
