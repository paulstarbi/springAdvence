package beans.controller;

import beans.models.Ticket;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    private UserService userService;

    @Autowired
    public SearchController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/search")
    public String searchView() {
        return "search";
    }

    @RequestMapping("/usersByName")
    public String getUsersByName(@RequestParam String name, Model model) {

        model.addAttribute("userList", userService.getUsersByName(name));

        return "data/usersByName";
    }

    @RequestMapping("/usersByMail")
    public String getUsersByMail(@RequestParam String email, Model model) {

        model.addAttribute("user", userService.getUserByEmail(email));

        return "data/usersByMail";
    }


    @RequestMapping("/bookedTicket")
    public String getBookedTicket( Model model) {
        model.addAttribute("ticketList", userService.getBookedTickets());

        return "data/bookedTicket";
    }

    @RequestMapping(value = "pdf", method= RequestMethod.GET,
            produces= MediaType.APPLICATION_PDF_VALUE)
    public ModelAndView ticketsPdf() {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(new Ticket());
        return new ModelAndView("pdfView", "ticketList", ticketList );
    }
}
