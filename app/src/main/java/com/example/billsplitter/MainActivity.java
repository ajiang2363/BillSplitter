package com.example.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button signIn;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        signIn = (Button)findViewById(R.id.SignInButton);
        signUp = (Button)findViewById(R.id.SignUpButton);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInPageLoad();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpPageLoad();
            }
        });
    }

    public void signInPageLoad(){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void signUpPageLoad(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }


}
