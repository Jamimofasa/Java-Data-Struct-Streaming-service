public class Netflix {

    StreamingService netflix = new StreamingService();

    private int userInput;
    private boolean exit = true;

   // this method is will run the program
    public void run()
    {
      userInterface();
    }

    // This is the user interface to interact with the streaming service
    // you can display the movie list
    // Sort by year
    // Sort by run time
    // Sort by rating
    // Search a genre
    // Search for a specific movie
    // Add a new movie to the list
    // display the interface menu
    // Exit the program
    private void userInterface()
    {
        netflix.displayMenu();
        while (exit) {

            userInput = netflix.userInputInt("What would you like to do: ", 1, 9);
            switch (userInput) {
                case 1:
                    netflix.listMovies();
                    break;
                case 2:
                    netflix.sortYear();
                    netflix.listMovies();
                    break;
                case 3:
                    netflix.sortRunTime();
                    netflix.listMovies();
                    break;
                case 4:
                    netflix.sortRating();
                    netflix.listMovies();
                    break;
                case 5:
                    netflix.searchGenre(netflix.userInputString("What genre would you like: "));
                    break;
                case 6:
                    netflix.searchMovie(netflix.userInputString("What movie would you like to search for: "));
                    break;
                case 7:
                    netflix.addMovie();
                    break;
                case 8:
                    netflix.displayMenu();
                    break;
                case 9:
                    exit = false;
                    break;
            }
        }
    }
}