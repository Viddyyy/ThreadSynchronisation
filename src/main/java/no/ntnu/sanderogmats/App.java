package no.ntnu.sanderogmats;

import no.ntnu.sanderogmats.booking.MovieTicketClient;
import no.ntnu.sanderogmats.booking.MovieTicketServer;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        MovieTicketServer movieTicketServer = new MovieTicketServer(
           "inception",
           5
        );

        // creating threads
        Thread thread1= new MovieTicketClient(movieTicketServer, "pål", 5);
        Thread thread2= new MovieTicketClient(movieTicketServer, "stefan", 2);
        Thread thread3= new MovieTicketClient(movieTicketServer, "knut", 3);
        Thread thread4= new MovieTicketClient(movieTicketServer, "jesus", 4);

        // starting up the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
