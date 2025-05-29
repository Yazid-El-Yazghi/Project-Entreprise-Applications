package be.ehb.ngo.controller;

import be.ehb.ngo.model.Event;
import be.ehb.ngo.model.Location;
import be.ehb.ngo.repository.EventRepository;
import be.ehb.ngo.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", eventRepository.findTop10ByOrderByTijdstipDesc());
        return "index";
    }

    @GetMapping("/new")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("locations", locationRepository.findAll());
        return "new";
    }

    @PostMapping("/new")
    public String createEvent(@ModelAttribute("event") @Valid Event event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("locations", locationRepository.findAll());
            model.addAttribute("error", "Vul alle velden correct in.");
            return "new";
        }
        eventRepository.save(event);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "details";
        }
        return "redirect:/";
    }
}
