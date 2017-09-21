package beans.controller;

import beans.models.Auditorium;
import beans.models.Event;
import beans.models.Ticket;
import beans.models.User;
import beans.services.BookingService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping("booking")
    public String bookingPage(@RequestParam (value = "price", defaultValue = "")String price,
                              Model model) {

        model.addAttribute("price", price);

        return "booking";
    }


    @RequestMapping(value = "booking/{user}/{ticket}", method = RequestMethod.POST)
    public String bookedTicket(@PathVariable User user, @PathVariable Ticket ticket) {

        bookingService.bookTicket(user, ticket);

        return "booking";
    }

    @RequestMapping(value = "booking/eventTicket", method = RequestMethod.POST)
    public String bookedTicket(@RequestParam String event,
                               @RequestParam String auditorium,
                               @RequestParam LocalDateTime localDateTime,
                               @RequestParam List<Integer> seats,
                               @RequestParam User user) {

        bookingService.getTicketPrice(event, auditorium, localDateTime, seats, user);

        return "booking";
    }

    @RequestMapping(value = "booking/ticketList", method = RequestMethod.POST)
    public String bookedTicket(@RequestParam String event,
                               @RequestParam String auditorium,
                               @RequestParam LocalDateTime localDateTime,
                               Model model) {

        model.addAttribute("ticketList",
                bookingService.getTicketsForEvent(event, auditorium, localDateTime));

        return "data/bookedTicket";
    }



}
