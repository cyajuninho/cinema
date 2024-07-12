package br.com.cyatech.cinema.controller;

import br.com.cyatech.cinema.model.Movie;
import br.com.cyatech.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Salva um filme
     * @param movie    Filme a ser salvo
     * @return Movie com status 200
     */
    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    /**
     * Busca um filme pelo id
     * @param id    Id do filme
     * @return Movie com status 200
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable Long id) {
        Optional<Movie> movie = Optional.ofNullable(movieService.findMovieById(id));
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Atualiza um filme
     * @param movie    Filme a ser atualizado
     * @return Movie com status 200
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    /**
     * Deleta um filme pelo id
     * @param id    Id do filme
     * @return Movie com status 200
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok().build();
    }
}
