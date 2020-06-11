package com.nicolas.multifunctiontextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nicolas.multifunctionlibrary.MultiFunctionTextView;

public class MainActivity extends AppCompatActivity {

    MultiFunctionTextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
//        textView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.getDrawable(R.drawable.ic_airport_shuttle_black_24dp), null);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("3688445555");
            }
        });
    }
}
