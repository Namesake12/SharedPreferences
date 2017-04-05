package shared_preferences.com.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Writing into Shared Preference
        SharedPreferences data = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor dataEditor = data.edit();
        dataEditor.putString("msg","Hello World");
        dataEditor.commit();

        String value = data.getString("msg","Not Found");
        TextView t1 = (TextView) findViewById(R.id.msg);
        t1.setText(value);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 15){
            TextView t1 = (TextView) findViewById(R.id.msg);
            t1.setText("From Activity One");
        }
        else if(requestCode == 25){
            TextView t1 = (TextView) findViewById(R.id.msg);
            t1.setText("From Activity Two");
        }
        else if(requestCode == 35){
            TextView t1 = (TextView) findViewById(R.id.msg);
            t1.setText("From Activity Three");
        }
        else{
            TextView t1 = (TextView) findViewById(R.id.msg);
            t1.setText("Unknown");
        }
    }

    public void startOne(View v){
        Intent i1 = new Intent(MainActivity.this, ActivityOne.class);
        startActivityForResult(i1, 15);
    }

    public void startTwo(View v){
        Intent i1 = new Intent(MainActivity.this, ActivityOne.class);
        startActivityForResult(i1, 35);
    }


}
