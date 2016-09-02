package com.hello_world.vikas.primeornot;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class cheat_activity extends AppCompatActivity{
    boolean flag = true,flag1=false;
    int number=0;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat_activity);
        if(savedInstanceState!=null)
        {
            flag1=savedInstanceState.getBoolean( "flag1",flag1 );
            flag=savedInstanceState.getBoolean( "flag",flag );
            number=savedInstanceState.getInt( "number",number );
            if(flag1)
            {
                Button btn = (Button) findViewById(R.id.cheat);
                btn.setEnabled(false);
                btn.setBackgroundColor(Color.GRAY);
                btn.setTextColor(Color.BLACK);
                for (int i = 2; i < number; i++) {
                    if (number % i == 0) {
                        flag = false;
                        break;
                    }
                }
                TextView t1 = (TextView) findViewById(R.id.textView2);
                TextView t2 = (TextView) findViewById(R.id.textView1);
                t2.setText("");
                if (flag) {
                    //str = ;
                    t1.setText(Integer.toString(number) + " is a prime number");
                } else {
                   // str = Integer.toString(var) + " is not a prime number";
                    t1.setText( Integer.toString(number) + " is not a prime number");
                }
            }
            else
            {


            }

        }
        else
        {
            extras = getIntent().getExtras();
            String str = extras.getString("var");
            int var = Integer.parseInt(str);
            number = var;
            Log.i("TAG",number+"");
        }


    }


    public void OnClickcheat(View view) {
        flag1=true;
        TextView t2 = (TextView) findViewById(R.id.textView1);
        t2.setText("");
        Button btn = (Button) findViewById(R.id.cheat);
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.GRAY);
        btn.setTextColor(Color.BLACK);
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }
        TextView t1 = (TextView) findViewById(R.id.textView2);
        if (flag) {
            String str = Integer.toString(number) + " is a prime number";
            t1.setText(str);
        } else {
            String str = Integer.toString(number) + " is not a prime number";
            t1.setText(str);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putBoolean( "flag1",flag1 );
        savedInstanceState.putBoolean( "flag",flag );
        savedInstanceState.putInt( "number",number );
        super.onSaveInstanceState(savedInstanceState);
        Log.i("tAG","Saving Instance");
    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent();
        intent.putExtra("flag1",flag1);
        intent.putExtra("flag",flag);
        setResult(2,intent);
        finish();
    }
}