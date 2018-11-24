package br.usp.icmc.ecommerceappaccessible.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import br.usp.icmc.ecommerceappaccessible.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PagamentoActivity extends BaseActivity {

    @BindView(R.id.btnProsseguir)
    Button btnProsseguir;

    @BindView(R.id.rbBoletoBancario)
    RadioButton rbBoletoBancario;

    @BindView(R.id.rbCartaoCredito)
    RadioButton rbCartaoCredito;

    @BindView(R.id.rbTransfBancaria)
    RadioButton rbTransfBancaria;

    @BindView(R.id.llDadosCartao)
    LinearLayout llDadosCartao;


    View.OnClickListener listener  = new View.OnClickListener() {
        public void onClick(View v) {
            rbBoletoBancario.setChecked(false);
            rbCartaoCredito.setChecked(false);
            rbTransfBancaria.setChecked(false);

            switch (v.getId()){
                case R.id.rbBoletoBancario:
                    rbBoletoBancario.setChecked(true);
                    llDadosCartao.setVisibility(View.GONE);
                    break;
                case R.id.rbCartaoCredito:
                    rbCartaoCredito.setChecked(true);
                    llDadosCartao.setVisibility(View.VISIBLE);
                    break;
                case R.id.rbTransfBancaria:
                    rbTransfBancaria.setChecked(true);
                    llDadosCartao.setVisibility(View.GONE);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        ButterKnife.bind(this);

        btnProsseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ConfirmaActivity.class);
                startActivity(intent);
            }
        });

        rbBoletoBancario.setOnClickListener(listener);
        rbCartaoCredito.setOnClickListener(listener);
        rbTransfBancaria.setOnClickListener(listener);
    }
}
