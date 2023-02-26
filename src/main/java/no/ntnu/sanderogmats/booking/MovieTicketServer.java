package no.ntnu.sanderogmats.booking;

import java.util.logging.Logger;

/* 
 * Represents the server part of the movie ticket system
 * handles the clients requests
 */
public class MovieTicketServer {
    private final String movieName;
    private int seats;
    private static final Logger logger = Logger.getLogger(MovieTicketServer.class.getName());

/*  
 * The server for the movie tickets
 * @param movieName name of the movie
 * @param seats number of seats that can be used
 * @throws IllegalArgumentException throws exception if a value is not within the valid range
 * 
*/
public MovieTicketServer(String movieName, int seats) throws IllegalArgumentException {
try {
    stringChecker(movieName);
    numberChecker(seats);
    }catch (IllegalArgumentException illegalArgumentException) {
        MovieTicketServer.logger.warning("IllegalArgumentException was caught");
    }
    this.movieName = movieName;
    this.seats = seats;
    }



/**
     * Order tickets for the movie.
     * The methods handle the order info and returns if there is ticket left or not.
     * @param customerName name of the customer.
     * @param numberOfSeats number of seats the customer wants to order.
     */
    public synchronized void bookTicket(String customerName, int numberOfSeats) {
        System.out.println("Hi," + customerName + " : " + seats + " : Seats available for " + movieName);
        if ((seats - numberOfSeats) < 0) {
            System.out.println("Hi," + customerName + " : Seats not available for " + movieName);
        }
        else {
            System.out.println("Hi," + customerName + " : " + numberOfSeats + " Seats booked successfully for " + movieName);
            decrementAvailableSears(numberOfSeats);
        }
    }

    /**
     * Checks that a given number is not below 0.
     * @param n the number that is checked.
     * @return the number
     */
    private int numberChecker(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Input cant be less then 0");
        }
        return n;
    }

    /**
     * Checks the String is valid.
     * If the string is empty or null, an Illegal Argument exception is thrown.
     * @param string the string that is being checked.
     * @return the string.
     */
    private String stringChecker(String string) {
        if(string.isEmpty()) {
            throw new IllegalArgumentException("Invalid string input");
        }
        return string;
    }

    /**
     * Decrease the number aof available seats in the
     * @param n number of seats that is taken away from the available seats.
     */
    private void decrementAvailableSears(int n) {
        try {
            numberChecker(n);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            logger.warning(illegalArgumentException.getMessage());
        }
        this.seats -= n;
    }}
