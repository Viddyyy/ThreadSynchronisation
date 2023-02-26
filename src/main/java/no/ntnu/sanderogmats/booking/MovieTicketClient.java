package no.ntnu.sanderogmats.booking;

import java.util.logging.Logger;

/* 
 * Client side of the movie ticket
 */

public class MovieTicketClient extends Thread{
    private final String customerName;
    private final int amountOfTickets;
    private final MovieTicketServer movieTicketServer;
    private static final Logger logger = Logger.getLogger(MovieTicketClient.class.getName());
    
    /* 
     * the movie ticket client
     * @param movieTicketServer the movie server the client want to book tickets from.
     * @param customerName the name of the customer.
     * @param numberOfTickets number of tickets the customer wants.
     * @throws IllegalArgumentException throws exception if a value is not valid.
     */
    
    public MovieTicketClient(MovieTicketServer movieTicketServer, String customerName, int amountOfTickets) throws IllegalArgumentException {
        try {
            stringChecker(customerName);
            numberChecker(amountOfTickets);
        } catch (IllegalArgumentException illegalArgumentException) {
            this.logger.warning("IllegalArgumentException caught :" + illegalArgumentException.getMessage());
        }
        this.customerName=customerName;
        this.amountOfTickets=amountOfTickets;
        this.movieTicketServer=movieTicketServer;
    }

    /* 
     * Responsible for running the booking of tickets
     */
    @Override
    public void run() {
        this.movieTicketServer.bookTicket(this.customerName, this.amountOfTickets);
    }

    /* 
     * Checks if a valid string is passed
     * When the string is null or empty, exception is thrown
     * @param string the string that is checked
     * @return the string
     */
    private String stringChecker(String string) {
        if(string.isEmpty()) {
            throw new IllegalArgumentException("String not valid as input");
        }
        return string;
    }


    /* 
     * Checks that the number given is not below the limit of 1.
     * @param n the number that is checked
     * @return the numbebr
     */
    private int numberChecker(int n) {
        if(n<1) {
            throw new IllegalArgumentException("input cannot be less than 1");
        }
        return n;
    }
}
