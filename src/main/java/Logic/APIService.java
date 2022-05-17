package Logic;

import data.Medias;

public interface APIService {
    void getAllMovies(ApiResult<Medias,Exception> callBack);

    void getTopRatedMovies(ApiResult<Medias,Exception> callBack);

    void getMovieByCategory(Long category,ApiResult<Medias,Exception> callBack);

    void getAllShows(ApiResult<Medias, Exception> callBack);


}
