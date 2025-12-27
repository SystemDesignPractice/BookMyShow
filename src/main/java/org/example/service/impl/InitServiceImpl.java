package org.example.service.impl;

import org.example.model.*;
import org.example.model.constants.SeatStatus;
import org.example.model.constants.SeatType;
import org.example.repository.*;
import org.example.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class InitServiceImpl implements InitService {

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    AudiRepository audiRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize() {

        // Create seats
        Seat show1seat1 = new Seat();
        show1seat1.setSeatStatus(SeatStatus.AVAILABLE);
        show1seat1.setSeatType(SeatType.GOLD);
        show1seat1.setName("1A");

        Seat show1seat2 = new Seat();
        show1seat2.setSeatStatus(SeatStatus.AVAILABLE);
        show1seat2.setSeatType(SeatType.GOLD);
        show1seat2.setName("2A");

        Seat show2seat1 = new Seat();
        show2seat1.setSeatStatus(SeatStatus.AVAILABLE);
        show2seat1.setSeatType(SeatType.GOLD);
        show2seat1.setName("1B");

        Seat show2seat2 = new Seat();
        show2seat2.setSeatStatus(SeatStatus.AVAILABLE);
        show2seat2.setSeatType(SeatType.GOLD);
        show2seat2.setName("2B");

        seatRepository.saveAll(List.of(show1seat1,show1seat2,show2seat1,show2seat2));


        // Create Show seats
        ShowSeat showSeat1 = new ShowSeat();
        showSeat1.setSeatStatus(SeatStatus.AVAILABLE);
        showSeat1.setPrice(100);
        showSeat1.setSeat(show1seat1);

        ShowSeat showSeat2 = new ShowSeat();
        showSeat2.setSeatStatus(SeatStatus.AVAILABLE);
        showSeat2.setPrice(100);
        showSeat2.setSeat(show1seat2);

        ShowSeat showSeat3 = new ShowSeat();
        showSeat3.setSeatStatus(SeatStatus.AVAILABLE);
        showSeat3.setPrice(100);
        showSeat3.setSeat(show2seat1);

        ShowSeat showSeat4 = new ShowSeat();
        showSeat4.setSeatStatus(SeatStatus.AVAILABLE);
        showSeat4.setPrice(100);
        showSeat4.setSeat(show2seat2);


        // Create shows
        Show show1 = new Show();
        show1.setShowSeats(List.of(showSeat1,showSeat2));
        show1.setStartTime(LocalDateTime.of(2025,12,28,9,0,0));
        show1.setEndTime(LocalDateTime.of(2025,12,28,12,30,0));

        Show show2 = new Show();
        show2.setShowSeats(List.of(showSeat3,showSeat4));
        show2.setStartTime(LocalDateTime.of(2025,12,29,13,0,0));
        show2.setEndTime(LocalDateTime.of(2025,12,29,14,30,0));


        // Create Audi
        Audi audi1 = new Audi();
        audi1.setName("Audi1");
        audi1.setShows(List.of(show1,show2));
        audi1.setSeats(List.of(show1seat1,show1seat2,show2seat1,show2seat2));
        audiRepository.save(audi1);


        // Create Theatre
        Theatre theatre = new Theatre();
        theatre.setName("PVR");
        theatre.setAudis(List.of(audi1));
        theatre.setAddress("Whitefield");
        theatreRepository.save(theatre);


        // Create city
        City city = new City();
        city.setTheatres(List.of(theatre));
        city.setName("Bengaluru");
        cityRepository.save(city);

        // Create actors
        Actor actor = new Actor();
        actor.setName("SRK");

        Actor actor1 = new Actor();
        actor1.setName("Kajol");

        actorRepository.saveAll(List.of(actor1,actor));

        //Create movie
        Movie movie = new Movie();
        movie.setActors(List.of(actor1,actor));
        movie.setName("DDLJ");
        movie.setLanguage(List.of("Hindi"));
        movieRepository.saveAll(List.of(movie));


        show1.setMovie(movie);
        show1.setAudi(audi1);
        show2.setMovie(movie);
        show2.setAudi(audi1);
        showRepository.saveAll(List.of(show1,show2));

        showSeat1.setShow(show1);
        showSeat2.setShow(show1);
        showSeat3.setShow(show2);
        showSeat4.setShow(show2);
        showSeatRepository.saveAll(List.of(showSeat1,showSeat2,showSeat3,showSeat4));

        User user = new User();
        user.setName("Muskan");
        user.setEmail("muskan.agarwal@gmail.com");
        userRepository.save(user);


    }
}
