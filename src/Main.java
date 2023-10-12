import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The main class that simulates a cinema booking system.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("Pulp Fiction", "90%", "Quentin Tarantino", true));
        filmList.add(new Film("The Shawshank Redemption", "95%", "Frank Darabont", false));
        filmList.add(new Film("The Godfather", "98%", "Francis Ford Coppola", true));
        filmList.add(new Film("The Dark Knight", "88%", "Christopher Nolan", true));
        filmList.add(new Film("Forrest Gump", "83%", "Robert Zemeckis", false));
        filmList.add(new Film("The Matrix", "87%", "Lana Wachowski", true));
        filmList.add(new Film("Schindler's List", "94%", "Steven Spielberg", false));
        filmList.add(new Film("Inception", "91%", "Christopher Nolan", true));
        filmList.add(new Film("Gladiator", "84%", "Ridley Scott", true));
        filmList.add(new Film("The Social Network", "86%", "David Fincher", true));
        filmList.add(new Film("Interstellar", "89%", "Christopher Nolan", false));
        filmList.add(new Film("Titanic", "75%", "James Cameron", true));
        filmList.add(new Film("The Silence of the Lambs", "93%", "Jonathan Demme", false));
        filmList.add(new Film("Jurassic Park", "81%", "Steven Spielberg", true));
        filmList.add(new Film("Inglourious Basterds", "88%", "Quentin Tarantino", true));

        List<CinemaHall> cinemaHalls = new ArrayList<>();
        CinemaHall hall1 = new CinemaHall(1, 10, 20, true);
        CinemaHall hall2 = new CinemaHall(2, 8, 18, false);
        CinemaHall hall3 = new CinemaHall(3, 4, 10, false);
        CinemaHall hall4 = new CinemaHall(4, 5, 10, false);

        for (int i = 0; i < 15; i++) {
            hall1.addFilm(filmList.get(random.nextInt(filmList.size())));
            hall2.addFilm(filmList.get(random.nextInt(filmList.size())));
            hall3.addFilm(filmList.get(random.nextInt(filmList.size())));
            hall4.addFilm(filmList.get(random.nextInt(filmList.size())));
        }

        cinemaHalls.add(hall1);
        cinemaHalls.add(hall2);
        cinemaHalls.add(hall3);
        cinemaHalls.add(hall4);

        try {
            System.out.println("Dostupné filmy:");
            for (int i = 0; i < filmList.size(); i++) {
                System.out.println((i + 1) + ". " + filmList.get(i).getName());
            }
            System.out.print("Vyberte film podle čísla: ");
            int selectedMovieNumber = Integer.parseInt(sc.nextLine());

            if (selectedMovieNumber < 1 || selectedMovieNumber > filmList.size()) {
                throw new InvalidMovieSelectionException("Vybraný film není k dispozici.");
            }

            Film chosenFilm = filmList.get(selectedMovieNumber - 1);

            System.out.println("Dostupné sály pro " + chosenFilm.getName() + ":");
            List<CinemaHall> hallsForMovie = new ArrayList<>();
            for (CinemaHall hall : cinemaHalls) {
                if (hall.getFilms().contains(chosenFilm)) {
                    System.out.println("Sál č. " + hall.getHallNumber());
                    hallsForMovie.add(hall);
                }
            }
            System.out.print("Vyberte sál: ");
            int selectedHallNumber = Integer.parseInt(sc.nextLine());

            CinemaHall chosenHall = null;
            for (CinemaHall hall : hallsForMovie) {
                if (hall.getHallNumber() == selectedHallNumber) {
                    chosenHall = hall;
                    break;
                }
            }

            if (chosenHall == null) {
                throw new InvalidHallSelectionException("Vybraný sál není k dispozici pro tento film.");
            }

            chosenHall.drawSeatingArrangement();

            System.out.print("Vyberte křeslo (např. A3): ");
            String selectedSeat = sc.nextLine();

            System.out.println("Rezervace pro film " + chosenFilm.getName() + " v sále č. " + chosenHall.getHallNumber() + " na křeslo " + selectedSeat + " byla potvrzena.");
        } catch (NumberFormatException e) {
            System.out.println("Chyba: Zadejte platné číslo pro výběr filmu.");
        } catch (InvalidMovieSelectionException | InvalidHallSelectionException e) {
            System.out.println("Chyba: " + e.getMessage());
        }

    }
}

/**
 * Custom exception class for invalid movie selections.
 */
class InvalidMovieSelectionException extends Exception {
    /**
     * Constructs a new InvalidMovieSelectionException with the specified error message.
     *
     * @param message The error message.
     */
    public InvalidMovieSelectionException(String message) {
        super(message);
    }
}

/**
 * Custom exception class for invalid hall selections.
 */
class InvalidHallSelectionException extends Exception {
    /**
     * Constructs a new InvalidHallSelectionException with the specified error message.
     *
     * @param message The error message.
     */
    public InvalidHallSelectionException(String message) {
        super(message);
    }
}
