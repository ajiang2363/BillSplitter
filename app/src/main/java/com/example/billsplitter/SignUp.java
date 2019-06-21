package com.example.billsplitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity {

    private userServices userServices;
    private String newUsername;
    private String password;
    private String confirmPassword;
    private Button attemptSignUp;
    private EditText getUsername;
    private EditText getPassword;
    private EditText getConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        attemptSignUp = (Button)findViewById(R.id.submitNewUser);
        attemptSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    public void signUp(){
        getUsername = (EditText)findViewById(R.id.newUsername);
        getPassword = (EditText)findViewById(R.id.newPassword);
        getConfirm = (EditText)findViewById(R.id.confirmPassword);
        newUsername = getUsername.getText().toString();
        password = getPassword.getText().toString();
        confirmPassword = getConfirm.getText().toString();

        if (newUsername.equals("") || password.equals("") || confirmPassword.equals("")){
            reloadPage("Please enter a value for all boxes.");
        }
        else if(!(validateUser(newUsername, password, confirmPassword))){
            reloadPage("Username already exists or password does not match.");
        }
        else{
            redirectToSignIn();
        }
    }

    public boolean validateUser(String username, String password1, String password2){
        if(!password1.equals(password2)){
            return false;
        }
        return true;
    }

    public void redirectToSignIn(){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void reloadPage(String MSG){
        TextView error = (TextView)findViewById(R.id.ErrorMSG);
        error.setText(MSG);
        error.setVisibility(View.VISIBLE);
        getUsername.setText("");
        getPassword.setText("");
        getConfirm.setText("");
    }

}
