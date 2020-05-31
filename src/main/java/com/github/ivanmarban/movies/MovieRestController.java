package com.github.ivanmarban.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieRestController {

    @Autowired
    private MovieRepository repo;

    @RequestMapping(value = "api/v1/movies", method = RequestMethod.GET)
    public List<Movie> getAll() {
        return repo.findAll();
    }

    @RequestMapping(value = "api/v1/movie/{id}", method = RequestMethod.GET)
    public Movie get(@PathVariable String id) {
        return repo.findOne(id);
    }

    @RequestMapping(value = "api/v1/movie", method = RequestMethod.POST)
    public Movie create(@RequestBody Movie movie) {
        return repo.save(movie);
    }

    @RequestMapping(value = "api/v1/movie/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }

    @RequestMapping(value = "api/v1/movie/{id}", method = RequestMethod.PUT)
    public Movie update(@PathVariable String id, @RequestBody Movie movie) {
        Movie update = repo.findOne(id);
        update.setDirector(movie.getDirector());
        update.setGenre(movie.getGenre());
        update.setRated(movie.getRated());
        update.setRuntime(movie.getRuntime());
        update.setTitle(movie.getTitle());
        update.setYear(movie.getYear());
        return repo.save(update);
    }

}
