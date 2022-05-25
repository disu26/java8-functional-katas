package co.com.sofka.katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import co.com.sofka.model.MovieList;
import co.com.sofka.util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }
}
