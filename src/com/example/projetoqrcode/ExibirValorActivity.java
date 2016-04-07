package com.example.projetoqrcode;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ExibirValorActivity extends Activity {
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_exibir_valor);

	        TextView conteudoLido = (TextView) findViewById(R.id.textViewValorLido);

	        Intent intent = getIntent();

	        conteudoLido.setText(("O conteúdo lido foi: "+ (String) intent.getSerializableExtra("conteudoLido")));
	    }

}
