package sg.com.cyf.myassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConverterActivity extends AppCompatActivity {
//conversion part
    public void converter(View view) {

        EditText dollarsign = (EditText) findViewById(R.id.dollarsign);
        //using double to display the decimal amount
        Double dollarAmount = Double.parseDouble(dollarsign.getText().toString());
        Double Amount = dollarAmount * 3.10;
        // once click on convert will display the amount that coverted
        Toast.makeText(getApplicationContext(), "$" + Amount.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Intent i = new Intent(ConverterActivity.this, SearchActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.profile:
                Intent i = new Intent(ConverterActivity.this, ProfileActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.login:
                Intent i = new Intent(ConverterActivity.this, LoginActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.feedback:
                Intent intent = new Intent(ConverterActivity.this, FeedbackActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}