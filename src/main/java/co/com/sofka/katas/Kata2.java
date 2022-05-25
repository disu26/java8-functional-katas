package co.com.sofka.katas;

import co.com.sofka.model.Movie;
import co.com.sofka.util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {

    private Kata2(){
        throw new IllegalStateException("Kata 2");
    }

    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().filter(p -> p.getRating().equals(5.0))
                                            .map(Movie::getId)
                                            .collect(Collectors.toUnmodifiableList());
    }
}
