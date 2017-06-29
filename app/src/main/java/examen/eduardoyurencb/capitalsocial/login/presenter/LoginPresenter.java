package examen.eduardoyurencb.capitalsocial.login.presenter;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import examen.eduardoyurencb.capitalsocial.RestCliente.ApiInterfaces;
import examen.eduardoyurencb.capitalsocial.base.presenter.Presenter;
import examen.eduardoyurencb.capitalsocial.login.domain.model.request.LoginRequest;
import examen.eduardoyurencb.capitalsocial.login.domain.model.response.LoginResponse;
import examen.eduardoyurencb.capitalsocial.login.view.LoginView;
import examen.eduardoyurencb.capitalsocial.utils.Constans;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eduardoyurencb on 6/14/17.
 */

public class LoginPresenter extends Presenter<LoginView> {

    public void login() throws JSONException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Declaramos y llenamos nuestro objeto Request
        LoginRequest requestPost = new LoginRequest();

        //Declaramos la interfaz y dejamos que retrofit la instancie
        ApiInterfaces interfaces = retrofit.create(ApiInterfaces.class);

        JSONObject paramObject = new JSONObject();
        paramObject.put("pass","password");
        paramObject.put("user","Luis");

        JSONObject paramObjectFinal = new JSONObject();
        paramObjectFinal.put("data", paramObject);
        //Hacemos el objeto tipo llamada
        Call<LoginResponse> responseCall = interfaces.login(paramObjectFinal);

        //Hacemos la llamada asíncrona. En este caso declaré el callback dentro
        //del mismo método. En lo personal me gusta crear una clase aparte
        //o implementar la interfaz en la clase
        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                //Log.d("masterkey", response.body().toString());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                //Log.d("masterkey", t.getMessage());
            }
        });

    }
}
