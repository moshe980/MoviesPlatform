package logic;

import model.Medias;

public interface ApiResult {
    void onResult(Medias data, Exception exception);
}
