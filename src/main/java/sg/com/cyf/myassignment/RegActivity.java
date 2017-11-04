package sg.com.cyf.myassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegActivity extends AppCompatActivity {

    Button bregister;
    private EditText nameInput, emailInput, userInput, passwordInput;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        prefs= getSharedPreferences("MY_Assignment",MODE_PRIVATE);

        String name  =prefs.getString("MY_NAME","");
        String email =prefs.getString("MY_EMAIL","");
        String user =prefs.getString("MY_USER","");
        String password =prefs.getString("MY_PASSWORD","");

        nameInput = (EditText) findViewById(R.id.nameInput);
        emailInput = (EditText) findViewById(R.id.emailInput);
        userInput = (EditText) findViewById(R.id.userInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);

        nameInput.setText(name);
        emailInput.setText(email);
        userInput.setText(user);
        passwordInput.setText(password);



        bregister = (Button) findViewById(R.id.bregister);
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =nameInput.getText().toString();
                String email=emailInput.getText().toString();
                String user=userInput.getText().toString();
                String password=passwordInput.getText().toString();

                SharedPreferences.Editor editor=prefs.edit();
                editor.putString("MY_NAME",name);
                editor.putString("MY_EMAIL",email);
                editor.putString("MY_USER",user);
                editor.putString("MY_PASSWORD",password);
                editor.apply();


                Intent intent =new Intent(RegActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}