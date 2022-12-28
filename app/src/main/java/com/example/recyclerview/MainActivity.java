package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText eT,eT2;
    TextView tV,tV2;
    ToggleButton tB;
    RecyclerView rV;
    double d;
    double x;
    boolean type=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT = findViewById(R.id.eT); //firts//
        eT2 = findViewById(R.id.eT2); // multiplier//
        tB = findViewById(R.id.tB);
        tV = findViewById(R.id.tV);
        tV2 = findViewById(R.id.tV2);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            String st1=eT.getText().toString();
            String st2=eT2.getText().toString();
            if (st1.matches("-?\\d+(\\.\\d+)?") && st2.matches("-?\\d+(\\.\\d+)?")){
                x=Double.parseDouble(st1);
                d=Double.parseDouble(st2);
                String[] arr=new String[20];
                arr[0]=x+"";
                if(!tB.isChecked())
                    {
                    for (int i = 1; i < arr.length; i++)
                        arr[i] = (x + d * (i)) + "";
                    }
                else
                    {
                    type=false;
                    for (int i = 1; i < arr.length; i++)
                        arr[i] = String.format("%s", (x * Math.pow(d,i)));
                    }
                MyRecycler myRecycler=new MyRecycler(getApplicationContext(), tV, tV2, arr, tB, x, d);
                recyclerView.setAdapter(myRecycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            else {
                eT.setText("");
                eT2.setText("");
                Toast.makeText(MainActivity.this, "Wrong input", Toast.LENGTH_SHORT).show();
            }
        });
    }
}