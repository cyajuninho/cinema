package br.com.cyatech.cinema.service;

import br.com.cyatech.cinema.model.Movie;
import br.com.cyatech.cinema.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
     * @param id        Id do filme
     * @param movie     Filme a ser atualizado
     * @return Movie
     */
    public Movie updateMovie(Long id, Movie movie) {
        Optional<Movie> existingMovie = movieRepository.findById(id);
        if (existingMovie.isPresent()) {
            Movie movieToUpdate = existingMovie.get();
            movieToUpdate.setTitle(movie.getTitle());
            movieToUpdate.setDescription(movie.getDescription());
            movieToUpdate.setDuration(movie.getDuration());
            movieToUpdate.setReleaseDate(movie.getReleaseDate());
            return movieRepository.save(movie);
        }
        throw new IllegalArgumentException("Filme não encontrado");
    }
}
