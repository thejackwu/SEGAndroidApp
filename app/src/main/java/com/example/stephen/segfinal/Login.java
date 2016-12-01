package com.example.stephen.segfinal;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        usernameEditText = (EditText) findViewById(R.id.editText_username);
        passwordEditText = (EditText) findViewById(R.id.editText_password);
    }


    public void goToNextPage(View view) {

        boolean valid = validateUsernameAndPassword();

        if (view.getId() == R.id.btn_login) {

            if(!valid) {
                showInvalidMessage();
            } else {
                Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
            }

        } else if (view.getId() == R.id.btn_sign_up) {

            if(!valid) {
                showInvalidMessage();
            } else {
                Toast.makeText(Login.this, "Sign Up successful!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean validateUsernameAndPassword() {
        boolean valid;

        if (usernameEditText.getText().length() == 0 || passwordEditText.getText().length() == 0) {
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }

    public void showInvalidMessage() {
        new AlertDialog.Builder(Login.this)
                .setTitle("Oops")
                .setMessage("You need to type in a username and a password")
                .setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

}

