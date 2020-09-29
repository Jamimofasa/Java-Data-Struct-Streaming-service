import java.util.Random;
import java.util.Scanner;

/**
 *
 */
public class StreamingService
{
    private Scanner input = new Scanner(System.in); //Scanner for User Input
    private Arraylist<Movie> movies; // Arraylist of Movies
    private Random random = new Random(); // Random class for random generated numbers
    private static final int INITIAL_CAPACITY = 30;

    public StreamingService()
    {
        movies = new Arraylist<>(INITIAL_CAPACITY);
        this.createMovies();
    }

    // Randomly generated
    private void createMovies()
    {
        // Create counters for making sure there's no more than six of each genre
        int countAction = 0;
        int countDrama = 0;
        int countSciFi = 0;
        int countDocumentary = 0;
        int countComedy = 0;

        for( int i =1; i <= 30; i++)
        {
            String name = "Movie" + i;
            //makes a random year and checks array to make sure there are no duplicates
            int year = getRandomInt(1920, 2017);
            if (i != 1) {
                for (int j = 0; j < movies.getSize(); j++) // Loop through each Movie year to make sure no year is the same
                {
                    if (movies.get(j).getYear() == year) {
                        year = getRandomInt(1920, 2017);
                    }
                }
            }
            // makes a random running time
            int runningTime = getRandomInt(60, 200);
            // makes a random rating from .1 to 10
            double rating = (10 * random.nextDouble() + .1);
            // makes a random genre Action , Comedy, Documentary, Drama, Sci-Fi no more than six randomly generated
            String genre;
            while (true) {
                int pickGenre = getRandomInt(1, 6);

                // This will make sure that when randomly created no genre will be listed more than six times
                if (pickGenre == 1) {
                    if (countAction < 6) {
                        genre = "Action";
                        countAction++;
                        break;
                    }
                }
                if (pickGenre == 2) {
                    if (countComedy < 6) {
                        genre = "Comedy";
                        countComedy++;
                        break;
                    }
                }
                if (pickGenre == 3) {
                    if (countDocumentary < 6) {
                        genre = "Documentary";
                        countDocumentary++;
                        break;
                    }
                }
                if (pickGenre == 4) {
                    if (countDrama < 6) {
                        genre = "Drama";
                        countDrama++;
                        break;
                    }
                }
                if (pickGenre == 5) {
                    if (countSciFi < 6) {
                        genre = "Sci-Fi";
                        countSciFi++;
                        break;
                    }
                }
            }
            //Creates new movie and adds to list
            Movie movie = new Movie(name, year, genre, runningTime, rating);
            movies.add(movie);
        }
    }



    // list and Display all the movies
    public void listMovies()
    {
        // Iterate through arraylist
        for (int i = 0; i < movies.getSize();i++)
        {
            //print out
            System.out.println(movies.get(i).toString());
        }


    }

    // Search through arraylist to find all similar genres searched
    public void searchGenre(String genre)
    {
        for (int i =0 ; i < movies.getSize(); i++)
        {
            if (genre.equalsIgnoreCase(movies.get(i).getGenre()))
            {
                System.out.println(movies.get(i).toString());
            }
        }
    }

    // This will search the arraylist for a specific Movie title
    public void searchMovie(String name)
    {
        String nameSearch="";
        for (int i = 0; i < movies.getSize(); i++)
        {

            if (movies.get(i).getName().equals(name))
            {
                nameSearch = movies.get(i).toString();
                System.out.println(nameSearch);
            }
        }
        if (nameSearch.equals(""))
        {
            System.out.println("That movie doesn't exist.");
        }
    }

    // Add a movie to the list
    public void addMovie()
    {
        if (movies.getSize() >= 35){
            System.out.println("You have reached the maximum number of movies added. ");
            return;
        }
         // Prompt user for movie title, year, genre, running Time, and rating
        String name = userInputString("Enter the movie name: ");
        // check to make sure the movie year is between 1920 and 2017
        int year = userInputInt("Enter the year it came out from 1920 to 2017: ", 1920,2017);
        String genre;
        // check to make sure genre is only Comedy, Sci-Fi, Action, Documentary, or Drama
        genre = userInputString("Enter the genre Comedy, Sci-Fi, Action, Documentary, or Drama: ");
        while (true)
        {
            if (genre.equalsIgnoreCase("Comedy")  || genre.equalsIgnoreCase("Action")
                    || genre.equalsIgnoreCase("Drama") || genre.equalsIgnoreCase("Documentary")
                    || genre .equalsIgnoreCase("Sci-Fi"))
            {
                break;
            }

            genre = userInputString("ERROR! Please Enter Comedy, Sci-Fi, Action, Documentary, or Drama: ");
        }
        int runningTime = userInputInt("Enter the running time from 60 to 200 minuets: ", 60,200);
        double rating = userInputDouble("Enter the movie rating from 0.1 to 10.0: ", 0.1,10.0);

        //New Movie object and add it to the arraylist
        Movie movie = new Movie(name, year, genre, runningTime, rating); //Create new movie
        movies.add(movie); // Insert without issues
        System.out.println("Added : "+ movie.toString() );
    }

    // Display a menu for user interface
    public void displayMenu()
    {
        System.out.printf("1.) To list all Movies." +
                "%n2.) Display Movies by year." +
                "%n3.) Display Movies by running Time." +
                "%n4.) Display Movies by ratings." +
                "%n5.) Display by specific genre." +
                "%n6.) Search for Movie." +
                "%n7.) Add New Movie." +
                "%n8.) Display menu" +
                "%n9.) Exit.%n");
    }
    // Create method for random integers for multiple use
    public int getRandomInt(int startRange,int  endRange)
    {
        return random.nextInt(endRange - startRange)+ startRange;
    }

    // display a message for user when prompted
    private void message(String prompt)
    {
        System.out.print(prompt);
    }

    // have bounds on the input for integer
    public int userInputInt(String prompt, int lowerBound, int upperBound)
    {
        message(prompt);
        int number;
        while (true)
        {
            number = input.nextInt();
            //check to make sure if integer is in bound
            if (lowerBound <= number && number <= upperBound)
            {
                return number;
            }
            message("Please insert a number between " + lowerBound + " and " + upperBound);
        }
    }

    // have bounds on the input for double
    public double userInputDouble( String prompt, double lowerBound, double upperBound )
    {
        message(prompt);
        double number;
        while(true){
            number = input.nextDouble();
            //check to make sure if double is in bound
            if (lowerBound <= number && number <= upperBound)
            {
                return number;
            }
            message("Please insert a number between " + lowerBound + " and " + upperBound);
        }
    }

    public String userInputString(String prompt)
    {
        message(prompt);
        return input.next() ;
    }

    // Bubble sort by Year
    public void sortYear()
    {
        for (int i = 0; i < movies.getSize()-1; i++)
            for (int j = 0; j < movies.getSize()-i-1; j++)
                if (movies.get(j).getYear() > movies.get(j+1).getYear())
                {
                    swap(j);
                }
    }

    //Bubble sort by Rating
    public void sortRating()
    {
        for (int i = 0; i < movies.getSize()-1; i++)
            for (int j = 0; j < movies.getSize()-i-1; j++)
                if (movies.get(j).getRating() > movies.get(j+1).getRating())
                {
                    swap(j);
                }
    }

    //Bubble sort by Run Time
    public void sortRunTime()
    {
        for (int i = 0; i < movies.getSize()-1; i++)
            for (int j = 0; j < movies.getSize()-i-1; j++)
                if (movies.get(j).getRunningTime() > movies.get(j+1).getRunningTime())
                {
                    swap(j);
                }
    }

    //Swap
    private void swap(int j)
    {
       // Swap spots with previous
        Movie temp = movies.get(j);
        movies.set(movies.get(j+1), j);
        movies.set(temp, j+1);
    }

}
