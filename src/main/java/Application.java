import Logic.ApiController;
import Logic.ApiResult;

public class Application {

    public static void main(String[] args) {

        ApiController.getInstance().getApiService().getMovieByCategory(27, new ApiResult<String, Exception>() {
            @Override
            public void onResult(String data, Exception exception) {
                if(data != null)
                {
                    System.out.println(data);

                }else{
                    System.err.println(exception.getMessage());
                }
            }
        });
    }


}
