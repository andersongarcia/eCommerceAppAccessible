package br.usp.icmc.ecommerceappaccessible.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import br.usp.icmc.ecommerceappaccessible.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DadosPessoaisActivity extends BaseActivity {

    @BindView(R.id.btnProsseguir)
    Button btnProsseguir;

    @BindView(R.id.sUF)
    Spinner sUF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);

        ButterKnife.bind(this);

        btnProsseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), FormaEnvioActivity.class);
                startActivity(intent);
            }
        });

        fillSpinner();
    }

    private void fillSpinner() {
        String[] items = new String[]{"ES","MG","RJ","SP"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        sUF.setAdapter(adapter);
    }
}
