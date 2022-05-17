import Logic.ApiController;
import Logic.ApiResult;
import data.Medias;

public class Application {

    public static void main(String[] args) {

        ApiController.getInstance().getApiService().getMovieByCategory(27L,new ApiResult<Medias, Exception>() {
            @Override
            public void onResult(Medias data, Exception exception) {
                for (Object o:data.getResults()){
                    System.out.println(o.toString());
                }
            }
        });
    }


}
