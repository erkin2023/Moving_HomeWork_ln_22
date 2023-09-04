import model.Cast;
import model.DateBase;
import model.Director;
import model.Movie;
import server.MovieServer;
import model.Genre;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Создаем директоров
        Director director1 = new Director("Chris", "Columbus");
        Director director2 = new Director("Alfonso", "Cuarón");
        Director director3 = new Director("Mike", "Newell");
        Director director4 = new Director("David", "Yates");
        Director director5 = new Director("Jon", "Watts");
        Director director6 = new Director("Frank", "Darabont");
        Director director7 = new Director("Francis Ford", "Coppola");
        Director director8 = new Director("Christopher", "Nolan");
        Director director9 = new Director("Steven", "Spielberg");
        Director director10 = new Director("Peter", "Jackson");
        Director director11 = new Director("Peter", "Farrelly");
        Director director12 = new Director("David", "Fincher");

// Создаем актеров и их роли
        Cast cast1 = new Cast("Daniel Radcliffe", "Harry Potter");
        Cast cast2 = new Cast("Rupert Grint", "Ron Weasley");
        Cast cast3 = new Cast("Emma Watson", "Hermione Granger");
        Cast cast4 = new Cast("Tom Holland", "Peter Parker / Spider-Man");
        Cast cast5 = new Cast("Zendaya", "MJ");
        Cast cast6 = new Cast("Benedict Cumberbatch", "Doctor Strange");
        Cast cast7 = new Cast("Tim Robbins", "Andy Dufresne");
        Cast cast8 = new Cast("Morgan Freeman", "Ellis Boyd ‘Red’ Redding");
        Cast cast9 = new Cast("Marlon Brando", "Vito Corleone");
        Cast cast10 = new Cast("Al Pacino", "Michael Corleone");
        Cast cast11 = new Cast("James Caan", "Sonny Corleone");
        Cast cast12 = new Cast("Christian Bale", "Batman / Bruce Wayne");
        Cast cast13 = new Cast("Heath Ledger", "Joker");
        Cast cast14 = new Cast("Aaron Eckhart", "Harvey Dent");
        Cast cast15 = new Cast("Liam Neeson", "Oskar Schindler");
        Cast cast16 = new Cast("Ralph Fiennes", "Amon Goeth");
        Cast cast17 = new Cast("Ben Kingsley", "Itzhak Stern");
        Cast cast18 = new Cast("Elijah Wood", "Frodo Baggins");
        Cast cast19 = new Cast("Viggo Mortensen", "Aragorn");
        Cast cast20 = new Cast("Ian McKellen", "Gandalf");
        Cast cast21 = new Cast("Viggo Mortensen", "Tony Lip");
        Cast cast22 = new Cast("Mahershala Ali", "Dr. Don Shirley");
        Cast cast23 = new Cast("Linda Cardellini", "Dolores");
        Cast cast24 = new Cast("Brad Pitt", "Tyler Durden");
        Cast cast25 = new Cast("Edward Norton", "Narrator");
        Cast cast26 = new Cast("Meat Loaf", "Robert ‘Bob’ Paulson");

// Создаем фильмы
        Movie movie1 = new Movie("Harry Potter", 2001, "Fantasy", List.of(director1, director2, director3, director4), new ArrayList<>());
        movie1.getCast().addAll(List.of(cast1, cast2, cast3));

        Movie movie2 = new Movie("The Avengers", 2012, "Comedy", List.of(new Director("Joss", "Whedon")), new ArrayList<>());
        movie2.getCast().addAll(List.of(
                new Cast("Robert Downey Jr.", "(Tony Stark / Iron Man)"),
                new Cast("Chris Evans", "(Steve Rogers / Captain America)"),
                new Cast("Mark Ruffalo", "(Bruce Banner / Hulk)"),
                new Cast("Chris Hemsworth", "(Thor)"),
                new Cast("Scarlett Johansson", "(Natasha Romanoff / Black Widow)"),
                new Cast("Jeremy Renner", "(Clint Barton / Hawkeye)")
        ));

        Movie movie3 = new Movie("Spider-Man: No Way Home", 2021, "Action, Adventure, Sci-Fi", List.of(director5), new ArrayList<>());
        movie3.getCast().addAll(List.of(cast4, cast5, cast6));

        Movie movie4 = new Movie("The Shawshank Redemption", 1994, "Drama", List.of(director6), new ArrayList<>());
        movie4.getCast().addAll(List.of(cast7, cast8));

        Movie movie5 = new Movie("The Godfather", 1972, "Crime, Drama", List.of(director7), new ArrayList<>());
        movie5.getCast().addAll(List.of(cast9, cast10, cast11));

        Movie movie6 = new Movie("The Dark Knight", 2008, "Action, Crime, Drama", List.of(director8), new ArrayList<>());
        movie6.getCast().addAll(List.of(cast12, cast13, cast14));

        Movie movie7 = new Movie("Schindler’s List", 1993, "Biography, Drama, History", List.of(director9), new ArrayList<>());
        movie7.getCast().addAll(List.of(cast15, cast16, cast17));

        Movie movie8 = new Movie("The Lord of the Rings: The Return of the King", 2003, "Action, Adventure, Drama", List.of(director10), new ArrayList<>());
        movie8.getCast().addAll(List.of(cast18, cast19, cast20));

        Movie movie9 = new Movie("Green Book", 2018, "Biography, Comedy, Drama", List.of(director11), new ArrayList<>());
        movie9.getCast().addAll(List.of(cast21, cast22, cast23));

        Movie movie10 = new Movie("Fight Club", 1999, "Drama", List.of(director12), new ArrayList<>());
        movie10.getCast().addAll(List.of(cast24, cast25, cast26));

// Создаем базу данных и добавляем все фильмы, директоров и актеров
        List<Movie> allMovies = new ArrayList<>(List.of(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10));
        List<Director> allDirectors = new ArrayList<>(List.of(director1, director2, director3, director4, director5, director6, director7, director8, director9, director10, director11, director12));
        List<Cast> allCasts = new ArrayList<>(List.of(cast1, cast2, cast3, cast4, cast5, cast6, cast7, cast8, cast9, cast10, cast11, cast12, cast13, cast14, cast15, cast16, cast17, cast18, cast19, cast20, cast21, cast22, cast23, cast24, cast25, cast26));

        DateBase dateBase = new DateBase(allMovies, allDirectors, allCasts);



        //servers
        MovieServer movieServer = new MovieServer(dateBase);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести все фильмы");
            System.out.println("2. Найти фильм по названию или его части");
            System.out.println("3. Найти фильм по имени актера");
            System.out.println("4. Найти фильм по году выпуска");
            System.out.println("5. Найти фильм по имени режиссера");
            System.out.println("6. Найти фильм по жанру");
            System.out.println("7. Найти фильм по роли актера");
            System.out.println("8. Сортировать фильмы по имени (A-Z)");
            System.out.println("9. Сортировать фильмы по имени (Z-A)");
            System.out.println("10. Сортировать фильмы по году выпуска (по возрастанию)");
            System.out.println("11. Сортировать фильмы по году выпуска (по убыванию)");
            System.out.println("12. Сортировать фильмы по режиссерам");
            System.out.println("13. Выйти из программы");
            System.out.print("Введите номер выбранного действия: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Чтение перевода строки после ввода числа

            switch (choice) {
                case 1:
                    System.out.println(movieServer.getAllMovies());
                    break;
                case 2:
                    System.out.print("Введите название фильма или его часть: ");
                    String titleSearch = scanner.nextLine();
                    movieServer.findMovieByFullNameOrPartName(titleSearch);
                    break;
                case 3:
                    System.out.print("Введите имя актера: ");
                    String actorName = scanner.nextLine();
                    movieServer.findMovieByActorName(actorName);
                    break;
                case 4:
                    System.out.print("Введите год выпуска фильма: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Чтение перевода строки после ввода числа
                    movieServer.findMovieByYear(year);
                    break;
                case 5:
                    System.out.print("Введите имя режиссера: ");
                    String directorName = scanner.nextLine();
                    movieServer.findMovieByDirector(directorName);
                    break;
                case 6:
                    System.out.print("Введите жанр фильма: ");
                    String genre = scanner.nextLine();
                    movieServer.findMovieByGenre(genre);
                    break;
                case 7:
                    System.out.print("Введите роль актера: ");
                    String role = scanner.nextLine();
                    movieServer.findMovieByRole(role);
                    break;
                case 8:
                    movieServer.sortByMovieName();
                    break;
                case 9:
                    movieServer.sortByMovieNameZA();
                    break;
                case 10:
                    movieServer.sortByYear();
                    break;
                case 11:
                    movieServer.sortByYear2();
                    break;
                case 12:
                    movieServer.sortByDirector();
                    break;
                case 13:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        }
    }
}