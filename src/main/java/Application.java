import logic.MediaProvider;
import logic.ServiceBuilder;
import view.MediaPresenter;

public class Application {

    public static void main(String[] args) {
        MediaPresenter.present(new MediaProvider(new ServiceBuilder().getMediaService()));

    }


}
