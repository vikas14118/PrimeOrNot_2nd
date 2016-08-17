//Author VIKAS GODARA 2014118

package com.hello_world.vikas.primeornot;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random var1 = new Random();
    public int var,count=0,ACcount=0,flag=0,flag1=0;
    private static final String TAG = "PrimeOrNot";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"Inside OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null)
        {
            var=var1.nextInt(999)+1;
            count=0;
            ACcount=0;
        }
        else
        {
            super.onRestoreInstanceState(savedInstanceState);
            var=savedInstanceState.getInt("var");
            count=savedInstanceState.getInt("count");
            ACcount=savedInstanceState.getInt("ACcount");
            flag=savedInstanceState.getInt("flag");
            flag1=savedInstanceState.getInt("flag1");
        }
        if(flag==1)
        {
            if(flag1==1)
            {
                Button btn3 = (Button) findViewById(R.id.yes);
                btn3.setEnabled(false);
                btn3.setBackgroundColor(Color.GREEN);
                btn3.setTextColor(Color.WHITE);
                Button btn4 = (Button) findViewById(R.id.no);
                btn4.setEnabled(false);
                btn4.setBackgroundColor(Color.GRAY);
                btn4.setTextColor(Color.BLACK);
                Button btn5 = (Button) findViewById(R.id.next);
                btn5.setEnabled(true);
                btn5.setBackgroundColor(Color.BLACK);
                btn5.setTextColor(Color.WHITE);


            }
            else
            {
                Button btn3 = (Button) findViewById(R.id.yes);
                btn3.setEnabled(false);
                btn3.setBackgroundColor(Color.RED);
                btn3.setTextColor(Color.WHITE);
                Button btn4 = (Button) findViewById(R.id.no);
                btn4.setEnabled(false);
                btn4.setBackgroundColor(Color.GRAY);
                btn4.setTextColor(Color.BLACK);
                Button btn5 = (Button) findViewById(R.id.next);
                btn5.setEnabled(true);
                btn5.setBackgroundColor(Color.BLACK);
                btn5.setTextColor(Color.WHITE);

            }
        }
        else if(flag==2)
        {
            if(flag1==1)
            {
                Button btn3 = (Button) findViewById(R.id.no);
                btn3.setEnabled(false);
                btn3.setBackgroundColor(Color.GREEN);
                btn3.setTextColor(Color.WHITE);
                Button btn4 = (Button) findViewById(R.id.yes);
                btn4.setEnabled(false);
                btn4.setBackgroundColor(Color.GRAY);
                btn4.setTextColor(Color.BLACK);
                Button btn5 = (Button) findViewById(R.id.next);
                btn5.setEnabled(true);
                btn5.setBackgroundColor(Color.BLACK);
                btn5.setTextColor(Color.WHITE);


            }
            else
            {
                Button btn3 = (Button) findViewById(R.id.no);
                btn3.setEnabled(false);
                btn3.setBackgroundColor(Color.RED);
                btn3.setTextColor(Color.WHITE);
                Button btn4 = (Button) findViewById(R.id.yes);
                btn4.setEnabled(false);
                btn4.setBackgroundColor(Color.GRAY);
                btn4.setTextColor(Color.BLACK);
                Button btn5 = (Button) findViewById(R.id.next);
                btn5.setEnabled(true);
                btn5.setBackgroundColor(Color.BLACK);
                btn5.setTextColor(Color.WHITE);

            }

        }
        TextView t = (TextView)findViewById(R.id.textView1);
        t.setText(Integer.toString(var));
        Log.i(TAG,"Exit OnCreate");
        if(flag==0) {
            Button btn = (Button) findViewById(R.id.next);
            btn.setEnabled(false);
            btn.setBackgroundColor(Color.GRAY);
            btn.setTextColor(Color.BLACK);
        }
        t = (TextView)findViewById(R.id.textView4);
        t.setText(Integer.toString(count));
        t = (TextView)findViewById(R.id.textView5);
        t.setText(Integer.toString(ACcount));


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putInt( "var",var );
        savedInstanceState.putInt( "count",count );
        savedInstanceState.putInt( "ACcount",ACcount );
        savedInstanceState.putInt( "flag",flag );
        savedInstanceState.putInt( "flag1",flag1 );
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"Saving Instance");
    }


    public void OnClickNext(View view) {
        flag =0;
        flag1=0;
        Log.i(TAG,"Next button clicked");
        TextView t = (TextView)findViewById(R.id.textView1);
        var=var1.nextInt(999)+1;
        t.setText(Integer.toString(var));
        Button btn = (Button) findViewById(R.id.yes);
        btn.setEnabled(true);
        Button btn1 = (Button) findViewById(R.id.no);
        btn1.setEnabled(true);
        Button btn2 = (Button) findViewById(R.id.next);
        btn2.setEnabled(false);
        btn.setBackgroundColor(Color.BLACK);
        btn.setTextColor(Color.WHITE);
        btn1.setBackgroundColor(Color.BLACK);
        btn1.setTextColor(Color.WHITE);
        btn2.setBackgroundColor(Color.GRAY);
        btn2.setTextColor(Color.BLACK);

    }


    public void OnClickYes(View view) {

        count+=1;
        flag=1;
        //Change button colors
        Button btn = (Button) findViewById(R.id.yes);
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.GRAY);
        btn.setTextColor(Color.BLACK);
        Button btn1 = (Button) findViewById(R.id.no);
        btn1.setEnabled(false);
        btn1.setBackgroundColor(Color.GRAY);
        btn1.setTextColor(Color.BLACK);
        Button btn2 = (Button) findViewById(R.id.next);
        btn2.setEnabled(true);
        btn2.setBackgroundColor(Color.BLACK);
        btn2.setTextColor(Color.WHITE);
        TextView t = (TextView)findViewById(R.id.textView4);
        t.setText(Integer.toString(count));
        Log.i(TAG,"Yes button clicked");
        //Checking if Var is Prime or not
        Boolean flaga = true;
        for(int i=2;i<var;i++)
        {
            if(var%i==0)
                {
                    flaga = false;
                    break;
                }
        }
        //If answer is true
        if(flaga) {
            ACcount+=1;
            TextView t1 = (TextView)findViewById(R.id.textView5);
            t1.setText(Integer.toString(ACcount));
            btn.setBackgroundColor(Color.GREEN);
            btn.setTextColor(Color.WHITE);
            Toast.makeText(getApplicationContext(), "correct Answer", Toast.LENGTH_SHORT).show();
            flag1=1;
            Log.i("TAG",flag+""+flag1);
        }
        else {
            btn.setBackgroundColor(Color.RED);
            btn.setTextColor(Color.WHITE);
            Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
            flag1=0;
        }

    }


    public void OnClickNo(View view) {
        count+=1;
        flag=2;
        //Change button colors
        Button btn = (Button) findViewById(R.id.yes);
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.GRAY);
        btn.setTextColor(Color.BLACK);
        Button btn1 = (Button) findViewById(R.id.no);
        btn1.setEnabled(false);
        btn1.setBackgroundColor(Color.GRAY);
        btn1.setTextColor(Color.BLACK);
        Button btn2 = (Button) findViewById(R.id.next);
        btn2.setEnabled(true);
        btn2.setBackgroundColor(Color.BLACK);
        btn2.setTextColor(Color.WHITE);
        TextView t = (TextView)findViewById(R.id.textView4);
        t.setText(Integer.toString(count));
        //Check if var is prime or not
        Log.i(TAG,"No button clicked");
        Boolean flaga = true;
        for(int i=2;i<var;i++)
        {
            if(var%i==0)
            {
                flaga = false;
                break;
            }
        }
        // If answer if true
        if(!flaga) {
            ACcount+=1;
            TextView t1 = (TextView)findViewById(R.id.textView5);
            t1.setText(Integer.toString(ACcount));
            btn1.setBackgroundColor(Color.GREEN);
            btn1.setTextColor(Color.WHITE);
            Toast.makeText(getApplicationContext(),"correct Answer",Toast.LENGTH_SHORT).show();
            flag1=1;
        }
        else {
            btn1.setBackgroundColor(Color.RED);
            btn1.setTextColor(Color.WHITE);
            Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
            flag1=0;
        }

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

}