package Logic.Retrofit;

import data.Instance;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApis {
    @GET("discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
    Call<Instance> getAllMovies();

    @GET("discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1/popular")
    Call<Instance> getNewMovies();

    @GET("discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1&with_genres={category}")
    Call<Instance> getMovieByCategory(@Path("category") int category);

    @GET("tv/latest?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
    Call<Instance> getAllShows();
}
