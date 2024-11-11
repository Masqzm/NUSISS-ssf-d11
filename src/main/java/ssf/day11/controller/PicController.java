package ssf.day11.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Request handler
@Controller
// Handles GET / or GET /index.html resource
@RequestMapping
public class PicController {
    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping(path = {"/", "/index.html"})
    public String getIndex(Model model) throws IOException {
        // Generate some data for view 
        String fileName = getPicOfTheDay();
    
        // Bind the data to the model (key, data)
        model.addAttribute("potdImg", fileName);

        return "index";
    }

    private String getPicOfTheDay() throws IOException {
        String fileName = "";

        Resource imgResource = resourceLoader.getResource("classpath:static/images");

        File imagesDir = Path.of(imgResource.getURI()).toFile();

        File[] listOfFiles = imagesDir.listFiles();

        if(listOfFiles.length > 0)
        {
            Random rand = new Random();
            int fileIndex = rand.nextInt(listOfFiles.length);

            fileName = listOfFiles[fileIndex].getAbsoluteFile().getName();

            //System.out.println(fileName);
        } 

        String prefix = "images" + File.separator;

        return prefix + fileName;
    }
}
