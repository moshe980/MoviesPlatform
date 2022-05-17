package Logic;

public interface APIService {
    void getAllMovies(ApiResult<String,Exception> callBack);

    void getNewMovies(ApiResult<String,Exception> callBack);

    void getMovieByCategory(int category,ApiResult<String,Exception> callBack);

    void getAllShows(ApiResult<String,Exception> callBack);


}
