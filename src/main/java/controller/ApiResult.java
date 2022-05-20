package controller;

import model.Medias;

public interface ApiResult {
    void onResult(Medias data, Exception exception);
}
