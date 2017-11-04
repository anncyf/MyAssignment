package sg.com.cyf.myassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    Button blogout;
    String Name;
    String Email;
    String User;
    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Name = getIntent().getExtras().getString("Name");
        Email = getIntent().getExtras().getString("Email Address");
        User = getIntent().getExtras().getString("Username");
        Password = getIntent().getExtras().getString("Password");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Name:" + " " + Name + '\n' + "Email Address:" + " " + Email + '\n' + "Username" + " " + User + '\n' + "Password:" + " " + Password);


        blogout = (Button) findViewById(R.id.blogout);
        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }
}

