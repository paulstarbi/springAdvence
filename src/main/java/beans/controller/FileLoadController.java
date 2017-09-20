package beans.controller;


import beans.models.Event;
import beans.models.User;
import beans.services.EventService;
import beans.services.UserService;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class FileLoadController {

    private UserService userService;
    private EventService eventService;

    @Autowired
    public FileLoadController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @RequestMapping(value = "file", method = RequestMethod.GET)
    public String fileView(@RequestParam (value = "added", defaultValue = "Add users or event from file")String added
            ,Model model) {
        model.addAttribute("added", added);
        return "file";
    }

    @RequestMapping(value = "addFile", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            parseFile(file.getOriginalFilename(), file);
            String message = "Adding file " + file.getOriginalFilename() + " goes correctly";
            return "redirect:/file?added=" + message;
        }
        return "redirect:/exception";
    }

    private void parseFile(String name, MultipartFile file) throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new InputStreamReader(file.getInputStream()));

        if (name.equalsIgnoreCase("user"))
            userService.register(gson.fromJson(reader, User.class));

        else if (name.equalsIgnoreCase("event"))
            eventService.create(gson.fromJson(reader, Event.class));
    }
}
