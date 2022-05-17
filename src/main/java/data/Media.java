package data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Media {
    private String name;
    private List<Integer> genreIds = new ArrayList<>();
    private long id;
    private String overview;
    private String firstAirDate;


    public Media(String name, List<Integer> genreIds, long id, String overview, String firstAirDate) {
        this.name = name;
        this.genreIds = genreIds;
        this.id = id;
        this.overview = overview;
        this.firstAirDate = firstAirDate;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public long getId() {
        return id;
    }

    public String getOverview() {
        return overview;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "name='" + name + '\'' +
                ", genreIds=" + genreIds +
                ", id=" + id +
                ", overview='" + overview + '\'' +
                ", firstAirDate='" + firstAirDate + '\'' +
                '}';
    }

}
