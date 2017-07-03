package examen.eduardoyurencb.capitalsocial.login.presenter;


import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import examen.eduardoyurencb.capitalsocial.base.presenter.Presenter;
import examen.eduardoyurencb.capitalsocial.login.domain.model.response.LoginResponse;
import examen.eduardoyurencb.capitalsocial.login.view.LoginView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import examen.eduardoyurencb.capitalsocial.RestCliente.RestCliente;


/**
 * Created by eduardoyurencb on 6/14/17.
 */

public class LoginPresenter extends Presenter<LoginView> {

    public void login(String pass, String user) throws JSONException {
        getView().showLoadingView();
        RestCliente.ApiInterface service;
        service = RestCliente.getClient();

        JsonObject paramObject = new JsonObject();

        //password, Luis
        paramObject.addProperty("pass",pass);
        paramObject.addProperty("user",user);

        JsonObject paramObjectFinal = new JsonObject();
        paramObjectFinal.add("data", paramObject);

        Call<LoginResponse> responseCall = service.login(paramObjectFinal);

        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                getView().hideLoadingView();
                Log.d("masterkey", response.body().toString());

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                getView().hideLoadingView();
                Log.d("masterkey", t.getMessage());
            }
        });

    }
}
