package server;

import Interface.Findable;
import Interface.Sortable;
import model.*;

import java.sql.SQLOutput;
import java.util.*;

public class MovieServer implements Findable , Sortable{
    private DateBase dateBase;

    public MovieServer(DateBase dateBase) {
        this.dateBase = dateBase;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movieList = dateBase.getMovieList();
        Iterator<Movie> movieIterator = movieList.iterator();
        while (movieIterator.hasNext()) {
            Movie movie = movieIterator.next();
        }
        return movieList;
    }

    @Override
    public void findMovieByFullNameOrPartName(String movieName) {
        List<Movie> movieList = dateBase.getMovieList();
        boolean found = false;

        for (Movie b : movieList) {
            if (b.getName().contains(movieName)) {
                System.out.println(b);
                found = true; // Фильм был найден
            }
        }

        if (!found) {
            System.out.println("По такому имени фильм не найден: " + movieName);
        }
    }

    @Override
    public void findMovieByActorName(String ActorName) {
        List<Movie> movies = dateBase.getMovieList();
        List<Cast> casts = dateBase.getCastList();
        boolean found = false;
        for (Cast cast : casts) {
            if (cast.getActorFullName().contains(ActorName)) {
                for (Movie movie : movies) {
                    if (movie.getCast().contains(cast)) {
                        System.out.println(movie); // Выводим фильм, в котором найден актер
                        found = true;
                        break; // Мы нашли фильм с актером, нет необходимости продолжать поиск по другим фильмам
                    }
                }
            }
        }

        if (!found) {
            System.out.println("По имени актера '" + ActorName + "' ничего не найдено.");
        }
    }

    @Override
    public void findMovieByYear(int years) {
        List<Movie> movieList = dateBase.getMovieList();
        boolean found = false;
        for (Movie b : movieList) {
            if (b.getYear() == years) {
                System.out.println(b);
                found = true; // Фильм был найден
            }
            if (!found) {
                System.out.println("По такому году фильм не найден : " + years);
            }
        }
    }


    @Override
    public void findMovieByDirector(String directorName) {
        List<Movie> movieList = dateBase.getMovieList();
        List<Director> directorList = dateBase.getDirectorList();
        boolean found = false;
        for (Director director : directorList) {
            if (director.getName().equals(directorName) || director.getLastName().equals(directorName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Фильмы, связанные с режиссером: " + directorName);
            for (Movie movie : movieList) {
                System.out.println(movie);
                break;
            }
        } else {
            System.out.println("Режиссер с именем или фамилией '" + directorName + "' не найден.");
        }
    }


    @Override
    public void findMovieByGenre(String genre) {
        List<Movie> movieList = dateBase.getMovieList();
        boolean found = false;
        for (Movie c : movieList) {
            if (c.getGenre().contains(genre)) {
                System.out.println("фильм с жанром " + genre + "\n" + c);
                found = true;
                break; // Если нашли совпадение, выходим из цикла

            }
        }

        if (!found) {
            System.out.println("К сожадению нет совпадение такого жанра фильмов :" + genre);
        }

    }

    @Override
    public void findMovieByRole(String role) {
        List<Cast> casts = dateBase.getCastList();
        boolean found = false;
        for (Cast c : casts) {
            if (c.getRole().contains(role)) {
                System.out.println("роль с таким фильмом :" + role + "\n" + c);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("К сожадению нет совпадение такого роля фильмов :" + role);
        }

    }
    @Override
    public void sortByMovieName() {
        List<Movie> movies =dateBase.getMovieList();
        Collections.sort(movies,SortByName);
        System.out.println("Сортировка фильма по Алфавиту");
        for(Movie b:movies){
            System.out.println(b);
        }
    }

    @Override
    public void sortByMovieNameZA() {
        List<Movie> movies =dateBase.getMovieList();

        Collections.sort(movies,SortByNameZA);
        System.out.println("Сортировка фильма по Алфавиту в обратном порядке");
        for(Movie b:movies){
            System.out.println(b);
        }
    }

    @Override
    public void sortByYear() {
        List<Movie> movies =dateBase.getMovieList();
        Collections.sort(movies,SortByYears);
        System.out.println("Сортировка фильма по году релизу");
        for (Movie b:movies){
            System.out.println(b);
        }
    }

    @Override
    public void sortByYear2() {
        List<Movie> movies =dateBase.getMovieList();
        Collections.sort(movies,SortByYears2);
        System.out.println("Сортировка фильма по году релизу в обратном порядке");
        for (Movie b:movies){
            System.out.println(b);
        }
    }

    @Override
    public void sortByDirector() {
        List<Movie> movies =dateBase.getMovieList();
        Collections.sort(movies,SortByYears);
        System.out.println("Сортировка фильма по режисеру ");
        for (Movie b:movies){
            System.out.println(b);
        }

    }
    private  static Comparator<Movie> SortByYears = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getYear()- o2.getYear();
        }

    };
    private static Comparator<Movie> SortByYears2 = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return  o2.getYear()-o1.getYear();
        }

    };
    private static Comparator<Movie> SortByName = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    private static Comparator<Movie> SortByNameZA = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
    private static Comparator<Director>SortDirectory=new Comparator<Director>() {
        @Override
        public int compare(Director o1, Director o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };





}
