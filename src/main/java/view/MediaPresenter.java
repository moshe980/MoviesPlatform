package view;

import controller.MediaProvider;
import model.Media;

public class MediaPresenter  {
    private MediaProvider mediaProvider;
    private static MediaPresenter instance;

    private MediaPresenter() {
        mediaProvider = new MediaProvider((data, exception) -> {
            if (data != null) {
                for (Media o : data.getResults()) {
                    System.out.println(o.toString());
                }
            } else {
                System.err.println(exception.getMessage());
            }
        });
    }

    public static MediaPresenter init() {
        if (instance == null) {
            instance = new MediaPresenter();
        }
        return instance;
    }


    public void present() {
        mediaProvider.getMedia();


    }


}
