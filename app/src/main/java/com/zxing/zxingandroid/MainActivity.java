package com.zxing.zxingandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case IntentIntegrator.REQUEST_CODE:
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

                final String result = scanResult.getContents();

                if ((result != null)) {

                    Toast.makeText(this, "Código: " + result, Toast.LENGTH_LONG).show();

                    TextView textResult = (TextView) findViewById(R.id.textView);
                    textResult.setText(result);

                } else {

                    Toast.makeText(getBaseContext(), "Código inválido ou inexistente.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}