package testdemo.saicharan.myapplication.Network;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import retrofit2.adapter.rxjava.HttpException;
import testdemo.saicharan.myapplication.Models.Response;

import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;

/**
 * Created by sai on 27-02-2019.
 */

public class NetworkError extends Throwable {
    public static final String DEFAULT_ERROR = "Something went wrong! Please try again.";
    public static final String NETWORK_ERROR = "Unable to connect to the remote server!"+"\n"+"Please try again.";
    private static final String ERROR_MESSAGE = "Error-Message";
    private final Throwable error;
    public NetworkError(Throwable e) {
        super(e);
        this.error = e;
    }
    public String getMessage() {
        return error.getMessage();
    }
    public boolean isAuthFailure() {
        return error instanceof HttpException &&
                ((HttpException) error).code() == HTTP_UNAUTHORIZED;
    }
    public boolean isResponseNull() {
        return error instanceof HttpException && ((HttpException) error).response() == null;
    }
    public String getAppErrorMessage() {
        if (this.error instanceof IOException) return NETWORK_ERROR;
        if (!(this.error instanceof HttpException)) return DEFAULT_ERROR;
        retrofit2.Response<?> response = ((HttpException) this.error).response();
        if (response != null) {
            String status = getJsonStringFromResponse(response);
            if (!TextUtils.isEmpty(status)) return status;
            Map<String, List<String>> headers = response.headers().toMultimap();
            if (headers.containsKey(ERROR_MESSAGE))
                return headers.get(ERROR_MESSAGE).get(0);
        }
        return DEFAULT_ERROR;
    }
    protected String getJsonStringFromResponse(final retrofit2.Response<?> response) {
        try {
            String jsonString = response.errorBody().string();
            Response errorResponse = new Gson().fromJson(jsonString, Response.class);
            return errorResponse.getStatus();
        } catch (Exception e) {
            return null;
        }
    }
    public Throwable getError() {
        return error;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetworkError that = (NetworkError) o;
        return error != null ? error.equals(that.error) : that.error == null;
    }
    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
