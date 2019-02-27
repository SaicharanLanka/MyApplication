package testdemo.saicharan.myapplication.Network;

import android.util.Log;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import testdemo.saicharan.myapplication.Models.Response;

/**
 * Created by sai on 27-02-2019.
 */

public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }



    public Subscription getBaseURL(final ResponseCallback<Response> responseCallback)
    {
        return networkService.getURL()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {
                    @Override
                    public void onCompleted() {
                        Log.e("Subscription ","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseCallback.onError(new NetworkError(e));
                    }

                    @Override
                    public void onNext(Response response) {
                        responseCallback.onSuccess(response);
                    }
                });
    }


    public abstract interface ResponseCallback<T> {
        void onSuccess(T response);

        void onError(NetworkError networkError);
    }


}
