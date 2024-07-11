package br.com.cyatech.cinema.service;

import br.com.cyatech.cinema.model.Movie;
import br.com.cyatech.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Salva um filme
     * @param movie     Filme a ser salvo
     * @return Movie
     */
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Busca um filme pelo id
     * @param id        Id do filme
     * @return Movie
     */
    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    /**
     * Deleta um filme pelo id
     * @param id        Id do filme
     */
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    /**
     * Atualiza um filme
     * @param movie     Filme a ser atualizado
     * @return Movie
     */
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
