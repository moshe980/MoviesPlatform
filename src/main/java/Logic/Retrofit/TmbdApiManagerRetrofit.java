package Logic.Retrofit;

import Logic.APIService;
import Logic.ApiEmptyBodyException;
import Logic.ApiResult;
import data.Medias;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmbdApiManagerRetrofit implements APIService {
    private static TmbdApiManagerRetrofit instance;
    private String baseUrl;
    private Retrofit retrofit;
    private RetrofitApis retrofitApis;

    private TmbdApiManagerRetrofit() {
        baseUrl = "https://api.themoviedb.org/3/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitApis = retrofit.create(RetrofitApis.class);
    }

    public static TmbdApiManagerRetrofit getInstance() {
        if (instance == null) {
            instance = new TmbdApiManagerRetrofit();
        }
        return instance;

    }

    @Override
    public void getAllMovies(ApiResult<Medias, Exception> callBack) {
        retrofitApis.getAllMovies().enqueue(new Callback<Medias>() {
            @Override
            public void onResponse(Call<Medias> call, Response<Medias> response) {
                Medias data =response.body();
                callBack.onResult(data, null);

            }

            @Override
            public void onFailure(Call<Medias> call, Throwable t) {
                callBack.onResult(null, new ApiEmptyBodyException());

            }
        });
    }

    @Override
    public void getTopRatedMovies(ApiResult<Medias, Exception> callBack) {
        retrofitApis.getTopRatedMovies().enqueue(new Callback<Medias>() {
            @Override
            public void onResponse(Call<Medias> call, Response<Medias> response) {
                Medias data =response.body();
                callBack.onResult(data, null);

            }

            @Override
            public void onFailure(Call<Medias> call, Throwable t) {
                callBack.onResult(null, new ApiEmptyBodyException());

            }
        });
    }



    @Override
    public void getMovieByCategory(Long category, ApiResult<Medias, Exception> callBack) {
        retrofitApis.getMoviesByCategory(27L).enqueue(new Callback<Medias>() {
            @Override
            public void onResponse(Call<Medias> call, Response<Medias> response) {
                Medias data =response.body();
                callBack.onResult(data, null);

            }

            @Override
            public void onFailure(Call<Medias> call, Throwable t) {
                callBack.onResult(null, new ApiEmptyBodyException());

            }
        });
    }

    @Override
    public void getAllShows(ApiResult<Medias, Exception> callBack) {
        retrofitApis.getAllShows().enqueue(new Callback<Medias>() {
            @Override
            public void onResponse(Call<Medias> call, Response<Medias> response) {
                Medias data =response.body();
                callBack.onResult(data, null);

            }

            @Override
            public void onFailure(Call<Medias> call, Throwable t) {
                callBack.onResult(null, new ApiEmptyBodyException());

            }
        });

    }


}
