package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Weather {
    private static final String API_KEY = "47wdLTq4GVps6HEhpQddLHLpHnRambo";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String LOCATION_KEY = "474212_PC";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http").host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(LOCATION_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();
        Request request = new Request.Builder()
                .addHeader("accept", "Application/Json")
                .url(url)
                .build();
        String JsR = client.newCall(request).execute().body().string();
    }
}

