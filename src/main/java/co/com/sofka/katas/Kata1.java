package co.com.sofka.katas;

import co.com.sofka.model.Movie;
import co.com.sofka.util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    private Kata1(){
        throw new IllegalStateException("Kata 1");
    }

    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream().map(p -> Map.of("id", p.getId(), "title", p.getTitle()))
                .collect(Collectors.toList());
    }
}
