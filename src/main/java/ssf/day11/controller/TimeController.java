package ssf.day11.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Request handler
@Controller
// Handles /time resource
@RequestMapping(path = "/time")
public class TimeController {
    
    @GetMapping("/gmt")
    public String getTimeGMT(Model model) {
        // Generate some data for view 
        String currentTime = (new Date()).toString();
        // Convert to GMT

        // Bind the data to the model (key, data)
        model.addAttribute("time", currentTime);

        // Display the template/view
        return "time";
    }

    // Mtd to handle GET /time
    // Inject the model into the handler
    @GetMapping()
    public String getTime(Model model) {
        // Generate some data for view 
        String currentTime = (new Date()).toString();

        // Bind the data to the model (key, data)
        model.addAttribute("time", currentTime);

        // Display the template/view
        return "time";
    }
}
