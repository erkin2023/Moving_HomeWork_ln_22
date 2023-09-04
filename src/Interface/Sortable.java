package Interface;

import model.Movie;

import java.util.List;

public interface Sortable {
    void sortByMovieName();
    void sortByMovieNameZA();

// 1)-from A to Z

// 2)- from Z to A

    void sortByYear();
    void sortByYear2();

// 1)- Ascending

// 2)- Descending

    void sortByDirector();
}
