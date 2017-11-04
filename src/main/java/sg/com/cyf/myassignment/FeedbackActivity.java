package sg.com.cyf.myassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Button b = (Button) findViewById(R.id.ebutton);
        final EditText feedback =(EditText) findViewById(R.id.editText4) ;
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Toast.makeText(FeedbackActivity.this, "Thank You for your feedback", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.feedback, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.converter:
                Intent i = new Intent(FeedbackActivity.this, ConverterActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.search:
                Intent i = new Intent(FeedbackActivity.this, SearchActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.profile:
                Intent i = new Intent(FeedbackActivity.this, ProfileActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.login:
                Intent intent = new Intent(FeedbackActivity.this, LoginActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}