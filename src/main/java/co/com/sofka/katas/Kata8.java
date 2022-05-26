package co.com.sofka.katas;

import com.codepoetics.protonpack.StreamUtils;
import co.com.sofka.model.Bookmark;
import co.com.sofka.model.Movie;
import co.com.sofka.util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {

    private Kata8(){
        throw new IllegalStateException("Kata 8");
    }

    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

        Stream<Movie> streamMovies = movies.stream();
        Stream<Bookmark> streamBookmarks = bookMarks.stream();

        return StreamUtils.zip(streamMovies, streamBookmarks, (m, b) -> Map.of("videoId", m.getId(), "bookmarkId", b.getId()))
                            .collect(Collectors.toUnmodifiableList());
    }
}
