package app.itdivision.lightbulb;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Register extends AppCompatActivity {
    EditText first_name;
    EditText last_name;
    EditText email;
    EditText password;
    EditText confirmpw;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.emailReg);
        password = (EditText) findViewById(R.id.passwordReg);
        confirmpw = (EditText) findViewById(R.id.confpasswordReg);
        btnRegister = (Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = first_name.getText().toString();
                String last = last_name.getText().toString();
                String em = email.getText().toString();
                String pw = password.getText().toString();
                String confpw = confirmpw.getText().toString();

                if(first.equals("") || em.equals("") || pw.equals("") || confpw.equals("")){
                    Toast.makeText(Register.this, "All forms must be filled!", Toast.LENGTH_SHORT).show();
                }else if(!isValidEmail(em)){
                    Toast.makeText(Register.this, "Email invalid!", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                    confirmpw.setText("");
                }else if(pw.length() < 8 ){
                    Toast.makeText(Register.this, "Password must contain at least 8 characters!", Toast.LENGTH_SHORT).show();
                    password.setText("");
                    confirmpw.setText("");
                }else if(confpw.equals(pw)) {
                    showToast();
                    Intent intent = new Intent(Register.this, Homepage.class);
                    intent.putExtra("first_name", first);
                    intent.putExtra("last_name", last);
                    intent.putExtra("email", em);
                    intent.putExtra("password", pw);
                    startActivity(intent);
                }else{
                    Toast.makeText(Register.this, "Password and confirm password do not match!", Toast.LENGTH_SHORT).show();
                    password.setText("");
                    confirmpw.setText("");
                }

            }
        });

    }

    public void showToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));
        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastImage.setImageResource(R.drawable.ic_check_black_24dp);
        toastText.setText("Successfully Registered!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean shouldAllowBack(){
        return false;
    }
    public void doNothing(){
        finish();
        moveTaskToBack(true);
    }

    @Override
    public void onBackPressed() {
        if (!shouldAllowBack()) {
            doNothing();
        } else {
            super.onBackPressed();
        }
    }
}

