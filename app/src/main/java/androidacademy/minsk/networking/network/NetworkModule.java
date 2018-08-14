package androidacademy.minsk.networking.network;

import androidacademy.minsk.networking.StaticParams;
import androidacademy.minsk.networking.network.utils.EnvelopingConverter;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkModule {

    private final HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final String API_BASE_URL = "https://api.foursquare.com/v2/";

    private final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(new EnvelopingConverter())
            .addConverterFactory(GsonConverterFactory.create());

    private final Interceptor apiKeyInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request original = chain.request();
            final HttpUrl originalHttpUrl = original.url();

            final HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("client_id", StaticParams.CLIENT_ID)
                    .addQueryParameter("client_secret", StaticParams.CLIENT_SECRET)
                    .addQueryParameter("v", "20171122")
                    .addQueryParameter("ll", "32.070080,34.794145")
                    .build();

            final Request.Builder requestBuilder = original.newBuilder()
                    .url(url);
            final Request request = requestBuilder.build();

            return chain.proceed(request);
        }
    };

    private final Retrofit retrofit = builder.client(
            httpClient.addInterceptor(logging)
                    .addInterceptor(apiKeyInterceptor)
                    .build()

    ).build();

    public FoursquareService foursquareService = retrofit.create(FoursquareService.class);
}
