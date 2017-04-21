package com.jengelmo.kwtfizzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends Activity {

    SessionApiClient sessionApiClient;

    TextView tvUsername;
    TextView tvPassword;
    EditText etUsername;
    EditText etPassword;
    Button btLogin;
    Button btLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        sessionApiClient = new SessionApiClient(new SessionApiClient.FakeExecutor());

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogout = (Button) findViewById(R.id.btLogout);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

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
        sessionApiClient.login(etUsername.getText().toString(), etPassword.getText().toString(), new SessionApiClient.LogInCallback() {
            @Override
            public void onSuccess() {
                tvUsername.setVisibility(View.INVISIBLE);
                etUsername.setVisibility(View.INVISIBLE);
                tvPassword.setVisibility(View.INVISIBLE);
                etPassword.setVisibility(View.INVISIBLE);
                btLogin.setVisibility(View.INVISIBLE);
                btLogout.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "LogIn Success!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "LogIn Error!!", Toast.LENGTH_SHORT).show();
                ;
            }
        });
    }

    private void logout() {
        sessionApiClient.logout(new SessionApiClient.LogOutnCallback() {
            @Override
            public void onSuccess() {
                tvUsername.setVisibility(View.VISIBLE);
                etUsername.setVisibility(View.VISIBLE);
                tvPassword.setVisibility(View.VISIBLE);
                etPassword.setVisibility(View.VISIBLE);
                btLogin.setVisibility(View.VISIBLE);
                btLogout.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Logout Success!!", Toast.LENGTH_SHORT).show();
                ;
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "Logout Error!!", Toast.LENGTH_SHORT).show();
                ;
            }
        });
    }


}
