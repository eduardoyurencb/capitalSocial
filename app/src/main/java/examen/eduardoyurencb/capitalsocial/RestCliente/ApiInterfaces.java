package examen.eduardoyurencb.capitalsocial.RestCliente;

import org.json.JSONObject;

import examen.eduardoyurencb.capitalsocial.login.domain.model.request.LoginRequest;
import examen.eduardoyurencb.capitalsocial.login.domain.model.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by eduardoyurencb on 6/14/17.
 */

public interface ApiInterfaces {

    @Headers({

            "SO: Android",
            "Version: 2.5.2"
    })
    @POST("login")
    Call<LoginResponse> login(@Body  JSONObject loginRequest);

}
