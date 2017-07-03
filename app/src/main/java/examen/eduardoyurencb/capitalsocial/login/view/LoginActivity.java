package examen.eduardoyurencb.capitalsocial.login.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;

import examen.eduardoyurencb.capitalsocial.R;
import examen.eduardoyurencb.capitalsocial.login.presenter.LoginPresenter;
import examen.eduardoyurencb.capitalsocial.promotion.view.PromotionsActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private ProgressDialog progressDialog;
    private LoginPresenter loginPresenter;
    private EditText editTextPersonName, editTextPassword;
    private AlertDialog.Builder builder;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);

        editTextPersonName = (EditText)findViewById(R.id.editTextPersonName);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        loginPresenter = new LoginPresenter();
        loginPresenter.bindView(this);

        progressDialog = new ProgressDialog(this,ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Conectando ...");
        progressDialog.setCancelable(false);

        builder = new AlertDialog.Builder(this);
        builder.setTitle("Login");
        builder.setMessage("Las credenciales son incorrectas");
        builder.setPositiveButton("Aceptar",null);
        builder.create();

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton)findViewById(R.id.loginFaceBookButton);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                launchHome();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:
                try {
                    loginPresenter.login(editTextPassword.getText().toString(), editTextPersonName.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void showLoadingView() {
        progressDialog.show();
    }

    @Override
    public void hideLoadingView() {
        progressDialog.hide();
    }

    @Override
    public void showErrorMessage(Error error) {
        builder.show();
    }


    @Override
    public void launchHome() {
        Intent mainIntent = new Intent().setClass(LoginActivity.this, PromotionsActivity.class);
        startActivity(mainIntent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
