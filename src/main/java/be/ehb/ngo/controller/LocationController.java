package be.ehb.ngo.controller;

import be.ehb.ngo.model.Location;
import be.ehb.ngo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;
}