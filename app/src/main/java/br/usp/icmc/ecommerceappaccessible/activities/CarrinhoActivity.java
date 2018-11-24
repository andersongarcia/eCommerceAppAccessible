package br.usp.icmc.ecommerceappaccessible.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import br.usp.icmc.ecommerceappaccessible.R;
import br.usp.icmc.ecommerceappaccessible.activities.DadosPessoaisActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CarrinhoActivity extends AppCompatActivity {

    @BindView(R.id.btnFinalizarCompra)
    Button btnFinalizarCompra;

    @BindView(R.id.sQuantidade)
    Spinner sQuantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        ButterKnife.bind(this);

        fillSpinner();

        btnFinalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), DadosPessoaisActivity.class);
                startActivity(intent);
            }
        });
    }

    private void fillSpinner() {
        Integer[] items = new Integer[]{1,2,3,4,5};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        sQuantidade.setAdapter(adapter);
    }
}
