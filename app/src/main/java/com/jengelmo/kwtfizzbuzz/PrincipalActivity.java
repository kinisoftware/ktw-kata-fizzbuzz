package com.jengelmo.kwtfizzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends Activity {

    SessionApiClient sessionApiClient;

    TextView tvUsername;
    TextView tvPassword;
    Button btLogin;
    Button btLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        sessionApiClient = new SessionApiClient();

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogout = (Button) findViewById(R.id.btLogout);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void login() {
        sessionApiClient.login(tvUsername.getText().toString(), tvPassword.getText().toString(), new SessionApiClient.LogInCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(), "LogIn Success!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "LogIn Error!!", Toast.LENGTH_SHORT).show();;
            }
        });
    }

    private void logout() {
        sessionApiClient.logout(new SessionApiClient.LogOutnCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(), "Logout Success!!", Toast.LENGTH_SHORT).show();;
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "Logout Error!!", Toast.LENGTH_SHORT).show();;
            }
        });
    }


}
