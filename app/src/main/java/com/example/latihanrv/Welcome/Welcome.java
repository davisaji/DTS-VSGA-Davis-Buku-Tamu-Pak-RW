package com.example.latihanrv.Welcome;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.latihanrv.MainActivity;
import com.example.latihanrv.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Welcome extends AppCompatActivity {

    Button button_gs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Berikut ini adalah awal kode program perpindahan Fragment
        loadFragment(new Welcome1());
        button_gs = (Button) findViewById(R.id.button_gs);
        button_gs.setOnClickListener(new View.OnClickListener() {
            int i = 1;

            public void onClick(View view) {
                i = i + 1;
                if (i > 4 || i < 1) {
                    i = 1;
                }
                switch (i) {
                    case 1:
                        loadFragment(new Welcome1());
                        break;
                    case 2:
                        loadFragment(new Welcome2());
                        break;
                    case 3:
                        loadFragment(new Welcome3());
                        break;
                    case 4:
                        Intent intent = new Intent(Welcome.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        loadFragment(new Welcome1());
                }
            }
        });
    }
    public void contactusklik(View view) {
        String url = "https://api.whatsapp.com/send?phone=6281259933757";
        Toast.makeText(view.getContext(), "Menghubungi Developer", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentlayout, fragment);
        fragmentTransaction.commit();
    }
}