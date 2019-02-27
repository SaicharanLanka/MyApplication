package testdemo.saicharan.myapplication.Network;




import retrofit2.http.GET;
import rx.Observable;
import testdemo.saicharan.myapplication.Models.Response;

/**
 * Created by sai on 27-02-2019.
 */

public interface NetworkService {


    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=o0f0iBNNzuAkWtZhZzxXKhNQRd4a6py4")
    Observable<Response> getURL();
}
