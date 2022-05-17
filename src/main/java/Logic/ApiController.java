package Logic;

public class ApiController {
    private static ApiController instance;
    private APIService apiService;

    private ApiController() {
         apiService = TmbdApiManager.getInstance();
    }


    public static ApiController getInstance() {
        if (instance == null) {
            instance = new ApiController();
        }

        return instance;
    }

    public APIService getApiService(){
        return apiService;
    }
}
