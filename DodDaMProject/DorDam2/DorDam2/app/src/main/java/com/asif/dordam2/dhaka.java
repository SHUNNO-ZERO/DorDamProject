package com.asif.dordam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class dhaka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka);
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
            Intent intent=new Intent (dhaka.this, barishal.class);
            startActivity(intent);
            return  true;

        }else
            if(id==R.id.Chittagong){
                Intent intent=new Intent (dhaka.this, chittagong.class);
                  startActivity(intent);
                return  true;
            }
            else
            if(id==R.id.Khulna){
                Intent intent=new Intent (dhaka.this, khulna.class);
                startActivity(intent);
                return  true;
            }

        if(id==R.id.Rajshahi){
            Intent intent=new Intent (dhaka.this, rajsahi.class);
            startActivity(intent);
            return  true;
        }


        if(id==R.id.Rangpur){
            Intent intent=new Intent (dhaka.this, rangpur.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Mymensingh){
            Intent intent=new Intent (dhaka.this, mymensingh.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Sylhet){
            Intent intent=new Intent (dhaka.this, sylhet.class);
            startActivity(intent);
            return  true;
        }


                return super.onOptionsItemSelected(item);



    }
}