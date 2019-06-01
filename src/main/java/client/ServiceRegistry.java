package client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

final class ServiceRegistry {

  private static final Retrofit.Builder RETROFIT_BUILDER = initializeRetrofitBuilder();

  private ServiceRegistry() {
  }

  private static Retrofit.Builder initializeRetrofitBuilder() {
    Gson gson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
        .connectTimeout(2, TimeUnit.HOURS)
        .readTimeout(2, TimeUnit.HOURS)
        .writeTimeout(2, TimeUnit.HOURS)
        .build();

    return new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient);
  }

  static RaidenService raidenService(String baseUrl) {
    return RETROFIT_BUILDER
        .baseUrl(baseUrl)
        .build()
        .create(RaidenService.class);
  }
}
