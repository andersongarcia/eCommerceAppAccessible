package br.usp.icmc.ecommerceappaccessible.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.mobsandgeeks.saripaar.annotation.CreditCard;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import br.usp.icmc.ecommerceappaccessible.R;
import br.usp.icmc.ecommerceappaccessible.extensions.MaskWatcher;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PagamentoActivity extends BaseActivity {

    @BindView(R.id.btnConfirmarPagamento)
    Button btnConfirmarPagamento;

    @BindView(R.id.rbBoletoBancario)
    RadioButton rbBoletoBancario;

    @BindView(R.id.rbCartaoCredito)
    RadioButton rbCartaoCredito;

    @BindView(R.id.rbTransfBancaria)
    RadioButton rbTransfBancaria;

    @CreditCard(messageResId = R.string.msg_erro_numero_cartao)
    @BindView(R.id.numeroCartao)
    EditText numeroCartao;

    @NotEmpty(messageResId = R.string.msg_erro_data_invalida)
    @BindView(R.id.dataValidade)
    EditText dataValidade;

    @NotEmpty(messageResId = R.string.msg_erro_codigo_invalido)
    @BindView(R.id.codigoSeguranca)
    EditText codigoSeguranca;

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

        numeroCartao.addTextChangedListener(new MaskWatcher("#### #### #### ####"));
        dataValidade.addTextChangedListener(new MaskWatcher("##/##"));
        codigoSeguranca.addTextChangedListener(new MaskWatcher("###"));

        btnConfirmarPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });

        rbBoletoBancario.setOnClickListener(listener);
        rbCartaoCredito.setOnClickListener(listener);
        rbTransfBancaria.setOnClickListener(listener);
    }

    @Override
    public void onValidationSucceeded() {
        Intent intent = new Intent(getBaseContext(), ConfirmaActivity.class);
        startActivity(intent);
    }
}
