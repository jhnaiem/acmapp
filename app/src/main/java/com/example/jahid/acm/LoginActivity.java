//package com.example.jahid.acm;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.AppCompatButton;
//import android.text.TextUtils;
//import android.view.WindowManager;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//public class LoginActivity extends AppCompatActivity {
//
//    private static final String TAG= "EmailPasswd:";
//
//    private FirebaseAuth mAuth;
//    private AppCompatButton signInButton;
//    private EditText emailField;
//    private EditText passwdField;
//    private TextView signUPtxView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.login_page);
//
//        // Keyboard off by default; Will only appear once user click on any of the fields;
//        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//
//        // Inflate widgets;
//        signInButton= findViewById(R.id.btn_login);
//        emailField= findViewById(R.id.input_email);
//        passwdField= findViewById(R.id.input_password);
//        signUPtxView= findViewById(R.id.link_signup);
//
//        // Create instance of auth
//        //FirebaseApp app = ACMApplication.getFirebaseApp();
//
//        mAuth= FirebaseAuth.getInstance();
//
//        // Event Listeners
//        signInButton.setOnClickListener(v -> {
//            signIn(emailField.getText().toString(),passwdField.getText().toString());
//        });
//
//        signUPtxView.setOnClickListener(v -> signUP());
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user= mAuth.getCurrentUser();
//        updateUI(user);
//    }
//
//    private boolean validateField(){
//        boolean valid= true;
//        String email= emailField.getText().toString();
//        String passwd= passwdField.getText().toString();
//
//        if(TextUtils.isEmpty(email)){
//            emailField.setError("Required");
//            valid= false;
//        }else{
//            emailField.setError(null);
//        }
//
//        if(TextUtils.isEmpty(passwd)){
//            passwdField.setError("Required");
//            valid= false;
//        }else{
//            passwdField.setError(null);
//        }
//
//        return valid;
//    }
//
//    private void signIn(String email,String passwd){
//
//        final ProgressDialog progressDialog;
//        if(!validateField())
//            return;
//        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//            progressDialog = new ProgressDialog(LoginActivity.this,android.R.style.Theme_Material_Dialog);
//        else
//            progressDialog = new ProgressDialog(LoginActivity.this);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Authenticating...");
//        progressDialog.show();
//
//        mAuth.signInWithEmailAndPassword(email,passwd)
//                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            FirebaseUser user= mAuth.getCurrentUser();
//                            updateUI(user);
//                        }else{
//                            Toast.makeText(getApplicationContext(),"Log In Failed!",Toast.LENGTH_LONG).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//
////        new android.os.Handler().postDelayed(()-> {
////            mAuth.signInWithEmailAndPassword(email,passwd).
////                    addOnCompleteListener(task -> {
////
////                        if(task.isSuccessful()){
////                            FirebaseUser user= mAuth.getCurrentUser();
////                            updateUI(user);
////                        }else{
////                            Toast.makeText(getApplicationContext(),"Log In Failed!",Toast.LENGTH_LONG).show();
////                            updateUI(null);
////                        }
////                    });
////
////            progressDialog.dismiss();
////
////        },5000);
//
//        // Sign IN Endl
//    }
//
//    private void updateUI(FirebaseUser user) {
//        if(user!=null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//        }
//    }
//
//    private void signUP(){
//        startActivity(new Intent(getApplicationContext(),MainActivity.class));
//    }
//}
