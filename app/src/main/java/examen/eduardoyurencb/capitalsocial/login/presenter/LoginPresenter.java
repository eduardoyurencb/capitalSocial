package examen.eduardoyurencb.capitalsocial.login.presenter;


import android.util.Log;

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

    public void login() throws JSONException {

        RestCliente.ApiInterface service;
        service = RestCliente.getClient();

        String aux = "{\"data\":{\"pass\":\"password\",\"user\":\"Luis\"}}";
        JSONObject object = new JSONObject(aux);
        //JSONObject paramObject = new JSONObject();
        //paramObject.put("pass","password");
        //paramObject.put("user","Luis");

        //JSONObject paramObjectFinal = new JSONObject();
        //paramObjectFinal.put("data", paramObject);
        //Hacemos el objeto tipo llamada
        Call<LoginResponse> responseCall = service.login(aux);

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
