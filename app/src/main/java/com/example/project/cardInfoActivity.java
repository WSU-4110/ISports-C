package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;
// Implements AppCompatActivity to function the card info form
public class cardInfoActivity extends AppCompatActivity {
    CardForm cardForm;
    Button save;
    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info);


        cardForm = findViewById(R.id.card_form);
        save= findViewById(R.id.btnSave);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_REQUIRED)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .actionLabel("SAVE")
                .setup(cardInfoActivity.this);


        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardForm.isValid()) {

                    alertBuilder = new AlertDialog.Builder(cardInfoActivity.this);
                    alertBuilder.setTitle("CONFIRM");
                    alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                            "Card Expiry Date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "Card CVV: " + cardForm.getCvv() + "\n" +
                            "Postal Code: " + cardForm.getPostalCode() + "\n" +
                            "Phone Number: " + cardForm.getMobileNumber());

                    alertBuilder.setPositiveButton("Conform", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();
                            Toast.makeText(cardInfoActivity.this, "THANK YOU", Toast.LENGTH_SHORT).show();
                        }
                    });

                    cardForm.isCardScanningAvailable();
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();
                        }
                    });


                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();
                }

                else{

                    Toast.makeText(cardInfoActivity.this,"Please Complete The Form",Toast.LENGTH_LONG).show();
                }
            }
        });






    }
}
