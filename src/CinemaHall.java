import java.util.ArrayList;
import java.util.List;

/**
 * Represents a cinema hall with seating arrangements and films.
 */
public class CinemaHall {
    private int hallNumber;
    private int rowCount;
    private int seatsPerRow;
    private List<Film> films;
    private boolean is3DSupported;

    public CinemaHall(int hallNumber, int rowCount, int seatsPerRow, boolean is3DSupported) {
        this.hallNumber = hallNumber;
        this.rowCount = rowCount;
        this.seatsPerRow = seatsPerRow;
        this.is3DSupported = is3DSupported;
        this.films = new ArrayList<>();
    }

    /**
     * Get the hall number.
     *
     * @return The hall number.
     */
    public int getHallNumber() {
        return hallNumber;
    }

    /**
     * Get the number of rows in the cinema hall.
     *
     * @return The number of rows.
     */
    public int getRowCount() {
        return rowCount;
    }

    /**
     * Get the number of seats per row in the cinema hall.
     *
     * @return The number of seats per row.
     */
    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    /**
     * Check if 3D movies are supported in this cinema hall.
     *
     * @return True if 3D is supported, false otherwise.
     */
    public boolean is3DSupported() {
        return is3DSupported;
    }

    /**
     * Get the list of films currently playing in the cinema hall.
     *
     * @return A list of films.
     */
    public List<Film> getFilms() {
        return films;
    }

    /**
     * Add a film to the list of films playing in the cinema hall.
     *
     * @param film The film to add.
     */
    public void addFilm(Film film) {
        films.add(film);
    }

    /**
     * Display the seating arrangement for the cinema hall.
     */
    public void drawSeatingArrangement() {
        System.out.println("Rozložení křesel pro sál č. " + hallNumber + ":");
        for (int row = 1; row <= rowCount; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                char seatLetter = (char) ('A' + seat - 1);
                System.out.print(seatLetter + String.format("%02d", row) + " ");
            }
            System.out.println();
        }
    }
}
