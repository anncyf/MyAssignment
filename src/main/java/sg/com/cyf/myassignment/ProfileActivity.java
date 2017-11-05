package sg.com.cyf.myassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    Button blogout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        SharedPreferences prefs= getSharedPreferences("MY_Assignment",MODE_PRIVATE);

        String name =prefs.getString("MY_NAME","no name");
        String email =prefs.getString("MY_EMAIL","no email");
        String user =prefs.getString("MY_USER","no user");
        String password =prefs.getString("MY_PASSWORD","no password");

        ((TextView)findViewById(R.id.nameLabel)).setText(name);
        ((TextView)findViewById(R.id.emailLabel)).setText(email);
        ((TextView)findViewById(R.id.userLabel)).setText(user);
        ((TextView)findViewById(R.id.passwordLabel)).setText(password);

        blogout = (Button) findViewById(R.id.blogout);
        blogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.converter:
                Intent i = new Intent(ProfileActivity.this, ConverterActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.search:
                Intent i = new Intent(ProfileActivity.this, SearchActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.login:
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.feedback:
                Intent intent = new Intent(ProfileActivity.this, FeedbackActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}