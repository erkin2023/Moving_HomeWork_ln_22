package model;

import java.util.List;

public class DateBase {
    private List<Movie> movieList;
    private List<Director> directorList;
    private List<Cast> castList;


    public DateBase(List<Movie> movieList, List<Director> directorList, List<Cast> castList ) {
        this.movieList = movieList;
        this.directorList = directorList;
        this.castList = castList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    public List<Cast> getCastList() {
        return castList;
    }

    public void setCastList(List<Cast> castList) {
        this.castList = castList;
    }

    @Override
    public String toString() {
        return "DateBase{" +
                "movieList=" + movieList +
                ", directorList=" + directorList +
                ", castList=" + castList +
                '}';
    }
}


