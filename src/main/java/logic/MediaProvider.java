package logic;

import model.Medias;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MediaProvider {
    private MediaService mediaService;

    public MediaProvider(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    public void getMedias(ApiResult apiResult) {

        mediaService.getMoviesByCategory(28).enqueue(new Callback<Medias>() {
            @Override
            public void onResponse(@NotNull Call<Medias> call, @NotNull Response<Medias> response) {
                Medias data = response.body();
                if (data != null) {
                    apiResult.onResult(data, null);

                } else {
                    apiResult.onResult(null, new ApiEmptyBodyException());

                }

            }

            @Override
            public void onFailure(@NotNull Call<Medias> call, @NotNull Throwable t) {
                apiResult.onResult(null, new RuntimeException(t.getLocalizedMessage()));

            }
        });

    }
}
