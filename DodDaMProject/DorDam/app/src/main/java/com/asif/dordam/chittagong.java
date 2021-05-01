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

public class chittagong extends AppCompatActivity {

    private RecyclerView mFirestoreList;
    private FirebaseFirestore firebaseFirestore;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagong);

        mFirestoreList=findViewById(R.id.firebase_list);
        firebaseFirestore=FirebaseFirestore.getInstance();

        //query
        Query query=firebaseFirestore.collection("chittagang_p");


        // recycler option.............
        FirestoreRecyclerOptions<ProductsModel> options= new FirestoreRecyclerOptions.Builder<ProductsModel>( )
                .setQuery(query,ProductsModel.class)
                .build();

        adapter= new FirestoreRecyclerAdapter<ProductsModel, barishal.ProductsViewHolder>(options) {
            @NonNull
            @Override
            public barishal.ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single,parent,false);

                return new barishal.ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull barishal.ProductsViewHolder holder, int position, @NonNull ProductsModel model) {

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
            Intent intent=new Intent (chittagong.this, dhaka.class);
            startActivity(intent);
            return  true;

        }else
        if(id==R.id.Chittagong){
            Intent intent=new Intent (chittagong.this, chittagong.class);
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


    private class ProductsViewHolder extends RecyclerView.ViewHolder{
        private TextView list_brandd;
        private TextView list_descriptionn;
        private TextView list_namee;
        private TextView list_pricee;
        private TextView list_qtyy;



        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            list_brandd=itemView.findViewById(R.id.list_brand);
            list_descriptionn=itemView.findViewById(R.id.list_description);
            list_namee=itemView.findViewById(R.id.list_name);
            list_pricee=itemView.findViewById(R.id.list_price);
            list_qtyy=itemView.findViewById(R.id.list_qty);



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