package examen.eduardoyurencb.capitalsocial.login.domain.model.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("agente")
    private String agente;

    @SerializedName("error")
    private String error;

    @SerializedName("id_user")
    private String idUser;

}
