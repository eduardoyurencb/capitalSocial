package examen.eduardoyurencb.capitalsocial.RestCliente;

import org.json.JSONObject;

import java.io.IOException;

import examen.eduardoyurencb.capitalsocial.login.domain.model.response.LoginResponse;
import examen.eduardoyurencb.capitalsocial.utils.Constans;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import okhttp3.*;

/**
 * Created by eduardoyurencb on 6/30/17.
 */

public class RestCliente {
    private static ApiInterface ApiInterface ;
    private static String baseUrl = Constans.URL;

    public static ApiInterface getClient() {

        if (ApiInterface == null) {
            // Creamos nuestro interceptor

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

            //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // Seteamos el nivel de log deseado, aquí pueden elegir las distintas opciones que entrega
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Yo acostumbro a agregar los header en el client OkHtpp para no tener que escribirlos en los métodos
            OkHttpClient okClient = new OkHttpClient.Builder()
                    .addInterceptor(
                            new Interceptor() {
                                @Override
                                public Response intercept(Interceptor.Chain chain) throws IOException {
                                    Request.Builder requestBuilder = chain.request().newBuilder();
                                    requestBuilder.header("Content-Type", "application/json");
                                    requestBuilder.header("SO", "Android");
                                    requestBuilder.header("Version", "2.5.2");
                                    return chain.proceed(requestBuilder.build());
                                }
                            })
                    .addInterceptor(loggingInterceptor)
                    .build();
            // Agregamos nuestro loggin interceptor al cliente OkHtpp
            //okClient.interceptors().add(loggingInterceptor);

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    // Agregamos nuestro cliente OkHttp a nuestro cliente Retrofit
                    .client(okClient)
                    .build();
            ApiInterface = client.create(ApiInterface.class);
        }

        return ApiInterface;
    }

    public interface ApiInterface {
        @POST("login")
        Call<LoginResponse> login(@Body String loginRequest);
    }



}
