package com.hello_world.vikas.primeornot;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hint_Activity extends AppCompatActivity {
    boolean flag1=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_);
        if(savedInstanceState!=null)
        {
            flag1=savedInstanceState.getBoolean("flag1");
            if(flag1)
            {
                TextView t2 = (TextView) findViewById(R.id.textView1);
                t2.setText(" ");
                TextView t3 = (TextView) findViewById(R.id.textView2);
                t3.setText("Prime number has no factors other than 1 and the number itself. Try to find other factors.");
                Button btn = (Button) findViewById(R.id.hint);
                btn.setEnabled(false);
                btn.setBackgroundColor(Color.GRAY);
                btn.setTextColor(Color.BLACK);

            }
        }
    }
    public void OnClickhint(View view) {
        flag1=true;
        TextView t2 = (TextView) findViewById(R.id.textView1);
        t2.setText("");
        TextView t3 = (TextView) findViewById(R.id.textView2);
        t3.setText("Prime number has no factors other than 1 and the number itself. Try to find other factors.");
        Button btn = (Button) findViewById(R.id.hint);
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.GRAY);
        btn.setTextColor(Color.BLACK);

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putBoolean( "flag1",flag1 );
        super.onSaveInstanceState(savedInstanceState);
        Log.i("tAG","Saving Instance");
    }
    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent();
        intent.putExtra("flag1",flag1);
        setResult(1,intent);
        finish();

    }
}
