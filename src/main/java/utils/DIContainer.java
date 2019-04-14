package utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import http.RaidenService;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class DIContainer {

  private static final Retrofit.Builder RETROFIT_BUILDER_INSTANCE = new Builder();

  private DIContainer() {
    Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    RETROFIT_BUILDER_INSTANCE
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
  }

  public static RaidenService raidenService(String baseUrl) {
    return RETROFIT_BUILDER_INSTANCE
        .baseUrl(baseUrl)
        .build()
        .create(RaidenService.class);
  }
}
