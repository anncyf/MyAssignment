package sg.com.cyf.myassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegActivity extends AppCompatActivity {

    Button bregister;
    EditText Name, Email, User, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        Name = (EditText) findViewById(R.id.etName);
        Email = (EditText) findViewById(R.id.etEmail);
        User = (EditText) findViewById(R.id.etUser);
        Password = (EditText) findViewById(R.id.etPassword);

        bregister = (Button) findViewById(R.id.bregister);
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etName = Name.getText().toString();
                String etEmail= Email.getText().toString();
                String etUser= User.getText().toString();
                String etPassword=Password.getText().toString();

                Intent intent =new Intent(RegActivity.this,ProfileActivity.class);
                intent.putExtra("Name",etName);
                intent.putExtra("Email Address",etEmail);
                intent.putExtra("Username",etUser);
                intent.putExtra("Password",etPassword);
                startActivity(intent);
            }
        });


    }
}