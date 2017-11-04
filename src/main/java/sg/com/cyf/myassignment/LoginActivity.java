package sg.com.cyf.myassignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity  {

    //declare variable
    private static final String TAG = "LoginActivity";

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private Button blogin;
    private EditText mName, mPassword;
    private CheckBox mCheckBox;
    Button bReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//declare edittext value
        mName = (EditText) findViewById(R.id.etName);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        blogin = (Button) findViewById(R.id.blogin);
        bReg =(Button) findViewById(R.id.bReg);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreferences();
//checkbox if checked will remenber the value if not will forgot
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mCheckBox.isChecked()){
                    //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox),"True");
                    mEditor.commit();
                    //save the name
                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();
                    //save the password
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit();

                }else {
                    //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox),"False");
                    mEditor.commit();
                        //Not save the name
                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();
                        //not save the password
                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit();

                }

                Toast.makeText(LoginActivity.this, "Welcome back to MyConvertor", Toast.LENGTH_SHORT).show();

            }
        });
        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RegActivity.class);
                startActivity(i);
            }
        });

    }


// link the key value/name and pull it form string.xml
    private void checkSharedPreferences(){
        //name and password and checkbox dafault value is empty as 1st open
        String name = mPreferences.getString(getString(R.string.name),"");
        String password = mPreferences.getString(getString(R.string.password),"");
        String checkbox = mPreferences.getString(getString(R.string.checkbox),"False");

        mName.setText(name);
        mPassword.setText(password);
//check and no uncheck value
        if (checkbox.equals("True")){
            mCheckBox.setChecked(true);

        }else{
            mCheckBox.setChecked(false);
        }

    }

    }



