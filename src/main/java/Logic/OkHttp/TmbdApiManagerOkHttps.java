package Logic.OkHttp;

import Logic.APIService;
import Logic.ApiEmptyBodyException;
import Logic.ApiResult;
import com.google.gson.Gson;
import data.Medias;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class TmbdApiManagerOkHttps implements APIService {
    private OkHttpClient client;
    private Request request;
    private static TmbdApiManagerOkHttps instance;
    private String baseUrl;

    private TmbdApiManagerOkHttps() {
        baseUrl = "https://api.themoviedb.org/3";
        client = new OkHttpClient();
    }

    public static TmbdApiManagerOkHttps getInstance() {
        if (instance == null) {
            instance = new TmbdApiManagerOkHttps();
        }
        return instance;

    }

    @Override
    public void getAllMovies(ApiResult<Medias, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl + "/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onResult(null, e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody responseBody = response.body();

                if (responseBody != null) {
                    Medias data = new Gson().fromJson(response.body().string(), Medias.class);
                    callBack.onResult(data, null);

                } else {
                    callBack.onResult(null, new ApiEmptyBodyException());

                }
            }
        });
    }

    @Override
    public void getTopRatedMovies(ApiResult<Medias, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl + "/movie/top_rated?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    Medias data = new Gson().fromJson(response.body().string(), Medias.class);
                    callBack.onResult(data, null);

                } else {
                    callBack.onResult(null, new ApiEmptyBodyException());

                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onResult(null, e);

            }

        });

    }



    @Override
    public void getMovieByCategory(Long category, ApiResult<Medias, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl + "/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1&with_genres=" + category)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    Medias data = new Gson().fromJson(response.body().string(), Medias.class);
                    callBack.onResult(data, null);

                } else {
                    callBack.onResult(null, new ApiEmptyBodyException());

                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onResult(null, e);

            }

        });
    }

    @Override
    public void getAllShows(ApiResult<Medias, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl + "/tv/popular?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callBack.onResult(null, e);

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response != null) {
                    Medias data = new Gson().fromJson(response.body().string(), Medias.class);
                    callBack.onResult(data, null);

                } else {
                    callBack.onResult(null, new ApiEmptyBodyException());

                }
            }
            }

);
    }


}
