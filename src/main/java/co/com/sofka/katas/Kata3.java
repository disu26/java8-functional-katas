package co.com.sofka.katas;

import co.com.sofka.model.Movie;
import co.com.sofka.model.MovieList;
import co.com.sofka.util.DataUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {

    private Kata3(){
        throw new IllegalStateException("Kata 3");
    }

    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().map(MovieList::getVideos)
                                    .flatMap(Collection::stream)
                                    .map(Movie::getId)
                                    .collect(Collectors.toList());
    }
}
