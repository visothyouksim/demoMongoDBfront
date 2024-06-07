package com.example.demoMongoDBfront.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClient;

import com.example.demoMongoDBfront.model.Movie;
import com.example.demoMongoDBfront.services.MovieService;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    RestClient.Builder restClientBuilder;

    @GetMapping("/allMovies")
    public String allMovies(Model model) {
        List<Movie> movie = movieService.getMovies("movies");
        model.addAttribute("movies", movie);
        return "movies";
    }

    @GetMapping("/addMovie")
    public String addMovieForm(Model model) {
        Movie newMovie = new Movie("", "");
        model.addAttribute("movie", newMovie);
        return "addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return "redirect:/allMovies";
    }

}
