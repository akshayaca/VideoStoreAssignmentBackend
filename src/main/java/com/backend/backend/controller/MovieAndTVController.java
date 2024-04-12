package com.backend.backend.controller;

import com.backend.backend.model.MovieAndTV;
import com.backend.backend.service.MovieAndTVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movieAndTV")
public class MovieAndTVController {
    @Autowired
    private MovieAndTVService movieAndTVService;


    @GetMapping("/all")
    public ResponseEntity<List<MovieAndTV>> getAllMovieAndTVs() {
        List<MovieAndTV> movieAndTVs = movieAndTVService.findAll();
        if (movieAndTVs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(movieAndTVs);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addMovieAndTV(@RequestBody MovieAndTV movieAndTV) {
        // Manual validation
        if (movieAndTV.getType() == null || movieAndTV.getType().trim().isEmpty() ||
                movieAndTV.getTitle() == null || movieAndTV.getTitle().trim().isEmpty() ||
                movieAndTV.getSynopsis() == null || movieAndTV.getSynopsis().trim().isEmpty() ||
                movieAndTV.getSmallPoster() == null || movieAndTV.getSmallPoster().trim().isEmpty() ||
                movieAndTV.getLargePoster() == null || movieAndTV.getLargePoster().trim().isEmpty() ||
                movieAndTV.getRentPrice() < 0 || movieAndTV.getPurchasePrice() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing or invalid fields. Please check your submission.");
        }

        MovieAndTV savedMovieAndTV = movieAndTVService.saveMovieAndTV(movieAndTV);
        if (savedMovieAndTV != null) {
            return ResponseEntity.ok("Movie posted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error posting movie/TV show");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieAndTV>> getMoviesByTitle(@RequestParam String title) {
        List<MovieAndTV> movies = movieAndTVService.findMoviesByTitle(title);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}/{type}")
    public ResponseEntity<MovieAndTV> getMovieOrTvByIdAndType(@PathVariable String id, @PathVariable String type) {
        return movieAndTVService.findByIdAndType(id, type)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/type/{type}")
    public ResponseEntity<List<MovieAndTV>> getMoviesOrTvByType(@PathVariable String type) {
        return ResponseEntity.ok(movieAndTVService.findByType(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMovieById(@PathVariable String id) {
        return movieAndTVService.findById(id)
                .map(movie -> ResponseEntity.ok((Object) movie))
                .orElse(ResponseEntity.badRequest().body((Object) "Invalid movie ID or movie does not exist."));
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Object> updateMovieAndTV(@PathVariable String id, @RequestBody MovieAndTV updateInfo) {
        return movieAndTVService.updateMovieAndTV(id, updateInfo)
                .map(updatedMovie -> ResponseEntity.ok((Object) updatedMovie))
                .orElse(ResponseEntity.badRequest().body((Object) "Invalid movie ID or missing data."));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovieAndTV(@PathVariable String id) {
        return movieAndTVService.deleteMovieAndTV(id) ?
                ResponseEntity.ok().body("Movie/TV show deleted successfully.") :
                ResponseEntity.badRequest().body("Invalid movie ID.");
    }
}
