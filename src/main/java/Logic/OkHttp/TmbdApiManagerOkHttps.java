package Logic.OkHttp;

import Logic.APIService;
import Logic.ApiEmptyBodyException;
import Logic.ApiResult;
import com.squareup.okhttp.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TmbdApiManagerOkHttps implements APIService {
    private OkHttpClient client;
    private Request request;
    private static TmbdApiManagerOkHttps instance;
    private String baseUrl;

    private TmbdApiManagerOkHttps() {
        baseUrl="https://api.themoviedb.org/3";
        client = new OkHttpClient();

    }

    public static TmbdApiManagerOkHttps getInstance() {
        if (instance == null) {
            instance = new TmbdApiManagerOkHttps();
        }
        return instance;

    }

    @Override
    public void getAllMovies(ApiResult<String, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl+"/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callBack.onResult(null,e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseBody responseBody = response.body();

                if(responseBody != null){
                    callBack.onResult(responseBody.string(),null);

                }else {
                    callBack.onResult(null,new ApiEmptyBodyException());

                }

            }
        });
    }

    @Override
    public void getNewMovies(ApiResult<String, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl+"/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1/popular")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callBack.onResult(null,e);

            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if(responseBody != null){
                    callBack.onResult(responseBody.string(),null);

                }else {
                    callBack.onResult(null,new ApiEmptyBodyException());

                }            }
        });
    }

    @Override
    public void getMovieByCategory(int category, ApiResult<String, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl+"/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1&with_genres="+category)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callBack.onResult(null,e);

            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if(responseBody != null){
                    callBack.onResult(responseBody.string(),null);

                }else {
                    callBack.onResult(null,new ApiEmptyBodyException());

                }            }
        });
    }

    @Override
    public void getAllShows(ApiResult<String, Exception> callBack) {
        request = new Request.Builder()
                .url(baseUrl+"/tv/latest?api_key=96624ea86553cd7a4caed4ecbdc35ec1")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callBack.onResult(null,e);

            }

            @Override
            public void onResponse(Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if(responseBody != null){
                    callBack.onResult(responseBody.string(),null);

                }else {
                    callBack.onResult(null,new ApiEmptyBodyException());

                }            }
        });
    }
}