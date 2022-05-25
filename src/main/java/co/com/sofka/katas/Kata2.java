package co.com.sofka.katas;

import com.google.common.collect.ImmutableList;
import co.com.sofka.model.Movie;
import co.com.sofka.util.DataUtil;

import java.util.List;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return ImmutableList.of(1, 2, 3);
    }
}
