package Logic;

import Logic.OkHttp.TmbdApiManagerOkHttps;
import Logic.Retrofit.TmbdApiManagerRetrofit;

public class ApiController {
    private static ApiController instance;
    private APIService apiService;

    private ApiController() {
         //apiService = TmbdApiManagerRetrofit.getInstance();
        apiService = TmbdApiManagerOkHttps.getInstance();
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
