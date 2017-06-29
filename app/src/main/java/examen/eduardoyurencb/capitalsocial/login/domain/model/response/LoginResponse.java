package examen.eduardoyurencb.capitalsocial.login.domain.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eduardoyurencb on 6/14/17.
 */

public class LoginResponse {
    @SerializedName("agente")
    private String agente;

    @SerializedName("error")
    private String error;

    @SerializedName("id_user")
    private String idUser;

}
