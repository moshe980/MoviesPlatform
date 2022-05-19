package model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Media implements Serializable {
    private int id;
    private String title;
    @SerializedName("vote_average")
    private double voteAverage;
    private String overview;
    private String releaseDate;
    private String posterPath;
    private String backdropPath;
    private String popularity;

    public Media(int id, String title, double voteAverage, String overview, String releaseDate, String posterPath, String backdropPath, String popularity){
        this.id = id;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
    }


    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", voteAverage=" + voteAverage +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", popularity='" + popularity + '\'' +
                '}';
    }
}
