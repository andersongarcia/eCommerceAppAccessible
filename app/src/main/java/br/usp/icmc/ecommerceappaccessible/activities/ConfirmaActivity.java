package br.usp.icmc.ecommerceappaccessible.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.usp.icmc.ecommerceappaccessible.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma);
    }
}
