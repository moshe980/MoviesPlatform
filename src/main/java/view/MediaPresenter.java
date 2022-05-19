package view;

import logic.MediaProvider;
import model.Media;

public class MediaPresenter {

    private MediaPresenter() {
    }

    public static void present(MediaProvider mediaProvider) {
        mediaProvider.getMedias((data, exception) -> {
            if (data != null) {
                for (Media o : data.getResults()) {
                    System.out.println(o.toString());
                }
            } else {
                System.err.println(exception.getMessage());
            }
        });


    }


}
