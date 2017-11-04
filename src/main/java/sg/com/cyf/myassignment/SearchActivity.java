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
    String[] country ={"Australia","Austria","Argentina","Belgium","Brazil","Brunei","China","Canada","Colombia","Cambodia","Denmark","Egypt","France","Germany","Greece","Hungary","Iceland","India","Indonesia","Italy","Iran","Japan",
            "Jordan","Kenya","Laos","Malaysia","Maldives","Mexico","Mongolia","Myanmar","Nepal","New Zealand","North Korea","Norway","Pakistan","Peru","Philippines","Portugal","Russia","Singapore","South Africa","South Korea",
            "Sri Lanka","Switzerland","Sweden","Taiwan","Thailand","Turkey","United Kingdom","United States of America ","Vietnam",};
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