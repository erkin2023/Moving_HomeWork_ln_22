package Interface;

import model.Movie;

import java.util.List;

public interface Findable {
    List<Movie>getAllMovies();

    void findMovieByFullNameOrPartName(String movieName);

    void findMovieByActorName(String ActorName);

    void findMovieByYear(int years);

    void findMovieByDirector(String directorName);
    void findMovieByGenre(String genre);

    void findMovieByRole(String role);
}
