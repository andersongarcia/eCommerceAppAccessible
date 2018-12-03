package br.usp.icmc.ecommerceappaccessible.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import br.usp.icmc.ecommerceappaccessible.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DadosPessoaisActivity extends BaseActivity {

    @BindView(R.id.btnSelecionarFormaEnvio)
    Button btnSelecionarFormaEnvio;

    @NotEmpty(messageResId = R.string.msg_erro_preencha_nome)
    @BindView(R.id.nome)
    EditText nome;

    @NotEmpty(messageResId = R.string.msg_erro_preencha_sobrenome)
    @BindView(R.id.sobrenome)
    EditText sobrenome;

    @Email(messageResId = R.string.msg_erro_email_invalido)
    @BindView(R.id.email)
    EditText email;

    @NotEmpty(messageResId = R.string.msg_erro_preencha_endereco)
    @BindView(R.id.endereco)
    EditText endereco;

    @NotEmpty(messageResId = R.string.msg_erro_preencha_bairro)
    @BindView(R.id.bairro)
    EditText bairro;

    @NotEmpty(messageResId = R.string.msg_erro_preencha_cidade)
    @BindView(R.id.cidade)
    EditText cidade;

    @BindView(R.id.sUF)
    Spinner sUF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_pessoais);

        ButterKnife.bind(this);

        btnSelecionarFormaEnvio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validator.validate();
            }
        });

        fillSpinner();
    }

    private void fillSpinner() {
        String[] items = new String[]{"ES","MG","RJ","SP"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        sUF.setAdapter(adapter);
    }

    @Override
    public void onValidationSucceeded() {
        Intent intent = new Intent(getBaseContext(), FormaEnvioActivity.class);
        startActivity(intent);
    }
}
