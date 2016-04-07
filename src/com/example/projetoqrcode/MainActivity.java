package com.example.projetoqrcode;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button qrButton = (Button) findViewById(R.id.button);
        qrButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                IntentIntegrator scanIntegrator = new IntentIntegrator();
                scanIntegrator.initiateScan();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult
                (requestCode, resultCode, intent);

        if (scanningResult != null) {
            String conteudoLido = scanningResult.getContents();

            intent = new Intent(this, ExibirValorActivity.class);
            intent.putExtra("conteudoLido", conteudoLido);
            this.startActivity(intent);
            this.finish();

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Nenhum dado foi recebido", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

}

