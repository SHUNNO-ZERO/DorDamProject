package com.asif.dordam2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class chittagong extends AppCompatActivity implements View.OnClickListener {

    //new........
    private EditText editTextName;
    private EditText editTextBrand;
    private EditText editTextDesc;
    private EditText editTextPrice;
    private EditText editTextQty;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagong);

        //new...............
        db = FirebaseFirestore.getInstance();

        editTextName = findViewById(R.id.edittext_name);
        editTextBrand = findViewById(R.id.edittext_brand);
        editTextDesc = findViewById(R.id.edittext_desc);
        editTextPrice = findViewById(R.id.edittext_price);
        editTextQty = findViewById(R.id.edittext_qty);

        findViewById(R.id.button_save).setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.Barishal){
            Intent intent=new Intent (chittagong.this, barishal.class);
            startActivity(intent);
            return  true;

        }else
        if(id==R.id.dhaka){
            Intent intent=new Intent (chittagong.this, dhaka.class);
            startActivity(intent);
            return  true;
        }
        else
        if(id==R.id.Khulna){
            Intent intent=new Intent (chittagong.this, khulna.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Rajshahi){
            Intent intent=new Intent (chittagong.this, rajsahi.class);
            startActivity(intent);
            return  true;
        }


        if(id==R.id.Rangpur){
            Intent intent=new Intent (chittagong.this, rangpur.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Mymensingh){
            Intent intent=new Intent (chittagong.this, mymensingh.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Sylhet){
            Intent intent=new Intent (chittagong.this, sylhet.class);
            startActivity(intent);
            return  true;
        }


        return super.onOptionsItemSelected(item);



    }

    //new................
    private boolean validateInputs(String name, String brand, String desc, String price, String qty) {
        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return true;
        }

        if (brand.isEmpty()) {
            editTextBrand.setError("Brand required");
            editTextBrand.requestFocus();
            return true;
        }

        if (desc.isEmpty()) {
            editTextDesc.setError("Description required");
            editTextDesc.requestFocus();
            return true;
        }

        if (price.isEmpty()) {
            editTextPrice.setError("Price required");
            editTextPrice.requestFocus();
            return true;
        }

        if (qty.isEmpty()) {
            editTextQty.setError("Quantity required");
            editTextQty.requestFocus();
            return true;
        }
        return false;
    }



    //onclick..........
    @Override
    public void onClick(View v) {


        String name = editTextName.getText().toString().trim();
        String brand = editTextBrand.getText().toString().trim();
        String desc = editTextDesc.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        String qty = editTextQty.getText().toString().trim();

        if (!validateInputs(name, brand, desc, price, qty)) {

            CollectionReference dbProducts = db.collection("chittagang_p");

            chittagang_p  product = new chittagang_p(
                    name,
                    brand,
                    desc,
                    Double.parseDouble(price),
                    Integer.parseInt(qty)
            );

            dbProducts.add(product)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(chittagong.this, "Product Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(chittagong.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

        }








    }
}