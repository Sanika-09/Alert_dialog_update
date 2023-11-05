package com.example.lertdialogupdate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnclose;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnclose = findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = getLayoutInflater().inflate(R.layout.custom_layout, null);
                ImageView dialogIcon = dialogView.findViewById(R.id.dialog_icon);
                TextView dialogMessage = dialogView.findViewById(R.id.dialog_message);

                dialogIcon.setImageResource(R.drawable.checked);
                dialogIcon.setLayoutParams(new LinearLayout.LayoutParams(50, 50)); // Set your desired size here
                dialogMessage.setText("Do you want to update?");

                builder.setView(dialogView)
                        .setTitle("Confirmation !!")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Start a new activity when "Yes" is clicked
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                        .show();
            }
        });


    }
}
