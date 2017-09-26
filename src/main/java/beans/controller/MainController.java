package beans.controller;

import beans.models.*;
import beans.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {

    AuditoriumService auditoriumService;

    UserService userService;

    EventService eventService;

    BookingService bookingService;

    @Autowired
    public MainController(@Qualifier("auditoriumServiceImpl") AuditoriumService auditoriumService,
                          @Qualifier("userServiceImpl") UserService userService,
                          @Qualifier("eventServiceImpl") EventService eventService,
                          @Qualifier("bookingServiceImpl") BookingService bookingService) {
        this.auditoriumService = auditoriumService;
        this.userService = userService;
        this.eventService = eventService;
        this.bookingService = bookingService;
    }

    @RequestMapping("/")
    public String homePageController(Model model) {
        return "home";
    }

    @RequestMapping("/add")
    public String addDataToBase(Model model) {

        String email = "dmitriy.vbabichev@gmail.com";
        String name = "Dmytro Babichev";
        String eventName = "The revenant";
        String auditoriumName = "Blue hall";
        Auditorium blueHall = auditoriumService.getByName(auditoriumName);
        Auditorium yellowHall = auditoriumService.getByName("Yellow hall");
        Auditorium redHall = auditoriumService.getByName("Red hall");
        LocalDateTime dateOfEvent = LocalDateTime.of(LocalDate.of(2016, 2, 5),
                LocalTime.of(15, 45, 0));

        User manager = new User(email, name, LocalDate.now());

        User simpleUser = new User("laory@yandex.ru", name, LocalDate.of(1992, 4, 29));
        User admin = new User("admin@admin.pl", "admin", LocalDate.of(1992, 4, 29));
        Set<UserProfile> profiles = new HashSet<>();
        profiles.add(new UserProfile(UsersRole.BOOKING_MANAGER.getRole()));
        admin.setProfile(profiles);


        userService.register(manager);

        System.out.println(manager.toString());
        userService.register(simpleUser);
        System.out.println(simpleUser.toString());

        userService.register(admin);

        Event event1 = eventService.create(
                new Event(eventName, Rate.HIGH, 60,
                        LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(9, 0, 0)),
                        blueHall));
        eventService.create(new Event(eventName, Rate.HIGH, 60, dateOfEvent, blueHall));
        Event event2 = eventService.create(
                new Event(eventName, Rate.HIGH, 60, LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(21, 18, 0)),
                        blueHall));
        eventService.create(
                new Event(eventName, Rate.HIGH, 90, LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(21, 18, 0)),
                        redHall));
        Event event = new Event(eventName, Rate.HIGH, 150,
                LocalDateTime.of(LocalDate.of(2016, 2, 5), LocalTime.of(21, 18, 0)), yellowHall);
        event = eventService.create(event);

        model.addAttribute("added", "Dodano uzytkownikow");
        return "file";
    }

}
