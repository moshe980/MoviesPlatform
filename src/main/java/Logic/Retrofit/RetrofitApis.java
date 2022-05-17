package Logic.Retrofit;

import data.Medias;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApis {
    @GET("discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
    Call<Medias> getAllMovies();

    @GET("movie/top_rated?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
    Call<Medias> getTopRatedMovies();

    @GET("discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1&with_genres={category}")
    Call<Medias> getMoviesByCategory(@Path("category") Long category);

    @GET("tv/popular?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
    Call<Medias> getAllShows();
}
