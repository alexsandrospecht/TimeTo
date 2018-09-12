package br.com.github.timeto.controller;

import br.com.github.timeto.model.TimeTo;
import br.com.github.timeto.service.TimeToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeToController {

    @Autowired
    private TimeToService locationService;

    @GetMapping(path = "/time-to")
    public String index(@RequestParam("message") String message,
                        @RequestParam("hour") Integer hour,
                        @RequestParam("minute") Integer minute,
                        @RequestParam(value = "zoneId", required = false) String zoneId,
                        Model map) {

        map.addAttribute("message", message);

        final TimeTo timeTo = locationService.timeTo(hour, minute, zoneId);
        map.addAttribute("object", timeTo);

        return "timeto";
    }

}
