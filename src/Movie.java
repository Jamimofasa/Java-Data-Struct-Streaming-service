/**
 *
 */
public class Movie
{
    private String name;       // variables for name
    private int year;          // year it came out( all different years)
    private int runningTime;   // movie running time
    private String genre;      // genre Comedy, Sci-Fi, Action, Documentary, Drama no more than 6 movies in one genre
    private double rating;        //Movie Rating [0.5 -1.0]

    //default Movie constructor
    public Movie( )
    {
        this.name = " ";
        this. year = 0;
        this.genre = " ";
        this.runningTime = 0;
        this.rating = 0;

    }

    //Movie constructor
    public Movie( String name, int year, String genre, int runningTime, double rating)
    {
        this.name = name;
        this. year = year;
        this.genre = genre;
        this.runningTime = runningTime;
        this.rating = rating;

    }

    //Getters
    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    // toString formatted with (name, year, running time, rating) with aligned spacing
    public String toString() {
      return   String.format("%7s %5d %12s %5d Mins  Rating:%4.1f" , name , year , genre , runningTime, rating);
    }
}
