# IDATA2305_Assignments

## How to run the code

To run the code you run <code>App.main()</code> and the results will be printed to the terminal.


## Observations

We noticed some problems when running the application:
* The server handled the request in an odd order.
* The amount of available tickets were not up to date.


### Solution

For the synchronization issue, we made bookTicket a <i>synchronized</i> method. This allows us to make sure that the method is executed consecutively. This ensures that each client will be serviced in the order that they contacted the server, as well as each client receiving up to date information on the amount of available tickets.
