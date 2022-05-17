package Logic.Retrofit;

import Logic.APIService;
import Logic.ApiResult;
import data.Instance;
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
        baseUrl="https://api.themoviedb.org/3/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitApis=retrofit.create(RetrofitApis.class);
    }

    public static TmbdApiManagerRetrofit getInstance() {
        if (instance == null) {
            instance = new TmbdApiManagerRetrofit();
        }
        return instance;

    }

    @Override
    public void getAllMovies(ApiResult<String, Exception> callBack) {
        retrofitApis.getAllMovies().enqueue(new Callback<Instance>() {
            @Override
            public void onResponse(Call<Instance> call, Response<Instance> response) {
                callBack.onResult(response.body().toString(),null);
            }

            @Override
            public void onFailure(Call<Instance> call, Throwable t) {
                callBack.onResult(null,new RuntimeException(t));
            }
        });
    }

    @Override
    public void getNewMovies(ApiResult<String, Exception> callBack) {
        retrofitApis.getNewMovies().enqueue(new Callback<Instance>() {
            @Override
            public void onResponse(Call<Instance> call, Response<Instance> response) {
                callBack.onResult(response.body().toString(),null);
            }

            @Override
            public void onFailure(Call<Instance> call, Throwable t) {
                callBack.onResult(null,new RuntimeException(t));
            }
        });
    }

    @Override
    public void getMovieByCategory(int category, ApiResult<String, Exception> callBack) {
        retrofitApis.getMovieByCategory(category).enqueue(new Callback<Instance>() {
            @Override
            public void onResponse(Call<Instance> call, Response<Instance> response) {
                callBack.onResult(response.body().toString(),null);
            }

            @Override
            public void onFailure(Call<Instance> call, Throwable t) {
                callBack.onResult(null,new RuntimeException(t));
            }
        });
    }

    @Override
    public void getAllShows(ApiResult<String, Exception> callBack) {
        retrofitApis.getAllShows().enqueue(new Callback<Instance>() {
            @Override
            public void onResponse(Call<Instance> call, Response<Instance> response) {
                callBack.onResult(response.body().toString(),null);
            }

            @Override
            public void onFailure(Call<Instance> call, Throwable t) {
                callBack.onResult(null,new RuntimeException(t));
            }
        });
    }
}
