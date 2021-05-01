package com.asif.dordam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.BreakIterator;

public class barishal extends AppCompatActivity {

    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barishal);

        mFirestoreList=findViewById(R.id.firebase_list);
        firebaseFirestore=FirebaseFirestore.getInstance();

        //query
        Query query=firebaseFirestore.collection("products");


        // recycler option.............
        FirestoreRecyclerOptions<ProductsModel> options= new FirestoreRecyclerOptions.Builder<ProductsModel>( )
                .setQuery(query,ProductsModel.class)
                .build();

         adapter= new FirestoreRecyclerAdapter<ProductsModel, ProductsViewHolder>(options) {
            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);

                return new ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull ProductsModel model) {

                holder.list_brand.setText(model.getBrand());
                holder.list_description.setText(model.getDescription());
                holder.list_name.setText(model.getName());
                holder.list_price.setText(model.getPrice() + "");
                holder.list_qty.setText(model.getQty()+"");




            }
        };
         mFirestoreList.setHasFixedSize(true);
         mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
         mFirestoreList.setAdapter(adapter);

        //view Holder..........
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
        if(id==R.id.dhaka){
            Intent intent=new Intent (barishal.this, dhaka.class);
            startActivity(intent);
            return  true;

        }else
        if(id==R.id.Chittagong){
            Intent intent=new Intent (barishal.this, chittagong.class);
            startActivity(intent);
            return  true;
        }
        else
        if(id==R.id.Khulna){
            Intent intent=new Intent (barishal.this, khulna.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Rajshahi){
            Intent intent=new Intent (barishal.this, rajsahi.class);
            startActivity(intent);
            return  true;
        }


        if(id==R.id.Rangpur){
            Intent intent=new Intent (barishal.this, rangpur.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Mymensingh){
            Intent intent=new Intent (barishal.this, mymensingh.class);
            startActivity(intent);
            return  true;
        }

        if(id==R.id.Sylhet){
            Intent intent=new Intent (barishal.this, sylhet.class);
            startActivity(intent);
            return  true;
        }


        return super.onOptionsItemSelected(item);



    }


    static class ProductsViewHolder extends RecyclerView.ViewHolder{

        public TextView list_brand;
        public TextView list_description;
        public TextView list_name;
        public TextView list_price;
        public TextView list_qty;



        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            list_brand=itemView.findViewById(R.id.list_brand);
            list_description=itemView.findViewById(R.id.list_description);
            list_name=itemView.findViewById(R.id.list_name);
            list_price=itemView.findViewById(R.id.list_price);
            list_qty=itemView.findViewById(R.id.list_qty);



        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}