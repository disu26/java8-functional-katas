package co.com.sofka.katas;

import co.com.sofka.util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
    private Kata10(){
        throw new IllegalStateException("Kata 10");
    }

    public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();

        return lists.stream().map(l -> Map.of("name", l.get("name"), "videos",
                                            videos.stream().filter(v -> v.get("listId").equals(l.get("id")))
                                                    .map(v -> Map.of("id", v.get("id"), "title", v.get("title")))
                                                    .collect(Collectors.toUnmodifiableList())))
                            .collect(Collectors.toUnmodifiableList());
    }
}
