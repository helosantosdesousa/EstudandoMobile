package com.helo.sorteadormegasena;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public List sortearJogo(){
        List ar = new ArrayList();

        Random rd = new Random();

        for(int i=0; i < 6;  i++){
            int n = rd.nextInt(60) + 1;
            ar.add(n);
        }
        return ar;
    }

    public String toString(List<Integer> ar){
        String r = " ";
        for (int i=0; i < ar.size(); i++) {
            r += ar.get(i);
            if(i < ar.size() - 1){
                r += " - ";
            }

        }
        return r;
    }


    public void selectButton(View v){
        TextView text = findViewById(R.id.resultado);
        List<Integer> ar = sortearJogo();
        text.setText(toString(ar));
    }

}