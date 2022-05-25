package co.com.sofka.katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import co.com.sofka.model.BoxArt;
import co.com.sofka.model.MovieList;
import co.com.sofka.util.DataUtil;

import java.util.List;
import java.util.Map;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
    }
}
