package com.skellyco.hito.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.r0adkll.slidr.Slidr;
import com.skellyco.hito.R;
import com.skellyco.hito.core.entity.dto.CreateAccountDTO;
import com.skellyco.hito.viewmodel.CreateAccountViewModel;

public class CreateAccountActivity extends AppCompatActivity {

    public static final String TAG = "CreateAccountActivity";

    private ImageButton btnBack;
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnCreateAccount;

    private CreateAccountViewModel createAccountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Slidr.attach(this);

        initializeViews();
        initializeListeners();
        initializeViewModel();
    }

    private void initializeViews()
    {
        btnBack = findViewById(R.id.btnBack);
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
    }

    private void initializeListeners()
    {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                CreateAccountDTO createAccountDTO = new CreateAccountDTO(email, username, password);
                createAccount(createAccountDTO);
            }
        });
    }

    private void initializeViewModel()
    {
        createAccountViewModel = new ViewModelProvider(this).get(CreateAccountViewModel.class);
    }

    private void createAccount(CreateAccountDTO createAccountDTO)
    {

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
    }
}
