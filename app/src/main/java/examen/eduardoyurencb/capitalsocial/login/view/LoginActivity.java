package examen.eduardoyurencb.capitalsocial.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

import examen.eduardoyurencb.capitalsocial.R;
import examen.eduardoyurencb.capitalsocial.login.presenter.LoginPresenter;
import examen.eduardoyurencb.capitalsocial.promotion.view.PromotionsActivity;

/**
 * Created by eduardoyurencb on 6/14/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin:

                LoginPresenter loginPresenter = new LoginPresenter();
                try {
                    loginPresenter.login();
                    Intent mainIntent = new Intent().setClass(LoginActivity.this, PromotionsActivity.class);
                    startActivity(mainIntent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
