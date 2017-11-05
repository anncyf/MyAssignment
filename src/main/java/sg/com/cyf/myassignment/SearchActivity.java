package sg.com.cyf.myassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity  {
//declare variable and string value
    Toolbar toolbar;
    ListView lst;
    //rate are base on 4/11/2017 exchange rate form online
    String[] country ={"Australia:0.957","Argentina:12.919","Brazil:2.427","Brunei:1.0","China:4.86",
            "Canada:0.934","Colombia:2223.8","Cambodia:2958.54","Euro:0.63","Hungary:196.8","Iceland:77.92","HongKong:5.71",
            "India:47.3","Indonesia:9890.3","Italy:1259.88","Iran:25618.44","Japan:83.56","Kenya:75.97","Laos:6078.49","Malaysia:3.10",
            "Maldives:11.28","Mexico:14.07","Mongolia:1798.40","Myanmar:991.80","Nepal:76.09","New Zealand:1.06","North Korea:659.29","Pakistan:77.199",
            "Peru:2.38","Philippines:37.58","Russia:43.26","South Africa:10.42","South Korea:817.01","Switzerland:0.73",
            "Sweden:6.18","Taiwan:22.10","Thailand:24.27","Turkey:2.85","United Kingdom:0.56","United States of America:0.732 ","Vietnam:16637.98",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

 //assign value to listview and toolbar that created in layout
        lst=(ListView) findViewById(R.id.listvw);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);


// create array to pull the string value
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country);
        lst.setAdapter(arrayAdapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){

//create intent is to link you to the second page.
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(SearchActivity.this,ConverterActivity.class);
        intent.putExtra("CountryName", lst.getItemAtPosition(position).toString());
        startActivity(intent);

//once you click on the select list it will display a msg to let user know what you selected.
        TextView tv=(TextView)view;
        Toast.makeText(SearchActivity.this,tv.getText()+" "+position,Toast.LENGTH_SHORT).show();

    }
        });

        lst.setAdapter(arrayAdapter);
    }

//action bar drop down selection
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
                Intent i = new Intent(SearchActivity.this, ConverterActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.profile:
                Intent i = new Intent(SearchActivity.this, ProfileActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.login:
                Intent i = new Intent(SearchActivity.this, LoginActivity.class);
                startActivity(i);
        }

        switch (item.getItemId()) {
            case R.id.feedback:
                Intent intent = new Intent(SearchActivity.this, FeedbackActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}