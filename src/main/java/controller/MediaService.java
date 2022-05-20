package controller;

import model.Medias;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MediaService {//remove api key
    @GET("discover/movie")
    Call<Medias> getAllMovies();

    @GET("movie/top_rated")
    Call<Medias> getTopRatedMovies();

    @GET("discover/movie")
    Call<Medias> getMoviesByGenerId(@Query("with_genres") int genre_id);

    @GET("tv/popular")
    Call<Medias> getAllShows();
}
