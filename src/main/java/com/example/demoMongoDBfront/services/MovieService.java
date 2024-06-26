package com.example.demoMongoDBfront.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoMongoDBfront.model.Movie;

@Service
public class MovieService {

    RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    public List<Movie> getMovies(String name) {
        Movie[] moviesArray = this.restTemplate.getForObject("http://localhost:8080/{name}", Movie[].class, name);

        return Arrays.asList(moviesArray);
    }

    public void addMovie(Movie movie) {
        try {
            this.restTemplate.postForObject("http://localhost:8080/addMovie", movie, Movie.class);
        } catch (Exception e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }

    public Movie getMovie(String id) {
        return this.restTemplate.getForObject("http://localhost:8080/movie/{id}", Movie.class, id);
    }
}
