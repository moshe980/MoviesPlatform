package controller;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServiceBuilder {
    private MediaService mediaService;

    public ServiceBuilder()  {
        //Read from local.properties:
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/local.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Add interceptor as query to the url:
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(chain -> {
            Request original =chain.request();
            HttpUrl originalHttpUrl = original.url();
            HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", prop.getProperty("api_key"))
                    .build();

            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);

            Request request = requestBuilder.build();
            return chain.proceed(request );
        });
        //Build retrofit:
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(prop.getProperty("baseUrl"))
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mediaService = retrofit.create(MediaService.class);
    }

    public MediaService getMediaService() {

        return mediaService;
    }


}
