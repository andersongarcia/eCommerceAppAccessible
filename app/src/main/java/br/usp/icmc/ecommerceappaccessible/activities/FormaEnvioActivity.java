package br.usp.icmc.ecommerceappaccessible.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.usp.icmc.ecommerceappaccessible.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FormaEnvioActivity extends BaseActivity {

    @BindView(R.id.btnSelecionarFormaPagamento)
    Button btnSelecionarFormaPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_envio);

        ButterKnife.bind(this);

        btnSelecionarFormaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PagamentoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onValidationSucceeded() {

    }
}
