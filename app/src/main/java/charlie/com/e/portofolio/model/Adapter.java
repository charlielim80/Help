package charlie.com.e.portofolio.model;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import charlie.com.e.portofolio.NoteDetails;
import charlie.com.e.portofolio.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> titles;//muculkan data
    List<String> itemName;
    List<String>  stock;
    List<String> expDate;

    public Adapter(List<String> titles, List<String> itemName, List<String> stock, List<String> expDate){
        this.titles = titles;
        this.itemName = itemName;
        this.stock = stock;
        this.expDate = expDate;

    }//akhircoding

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //untuk mengrimkan data dari list dan mengirimkan ke view layout
        holder.noteTitle.setText(titles.get(position));
        holder.noteContent.setText(itemName.get(position));
        holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(getRandomColor(),null));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "The Item is Clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), NoteDetails.class);
                i.putExtra("titles",titles.get(position));
                i.putExtra("itemName",itemName.get(position));
                i.putExtra("stock",stock.get(position));
                i.putExtra("expDate",expDate.get(position));
                v.getContext().startActivity(i);
            }
        });
    }

    private int getRandomColor() {
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.blue);
        colorCode.add(R.color.yellow);
        colorCode.add(R.color.lightPurple);
        colorCode.add(R.color.pink);
        colorCode.add(R.color.lightGreen);
        colorCode.add(R.color.gray);
        colorCode.add(R.color.red);
        colorCode.add(R.color.greenlight);
        colorCode.add(R.color.notgreen);

        Random randomColor = new Random();
        int number = randomColor.nextInt (colorCode.size());
        return colorCode.get(number);
    }

    @Override
    public int getItemCount() {

        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle,noteContent;
        View view;
        CardView mCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.titles);
            noteContent = itemView.findViewById(R.id.content);
            mCardView = itemView.findViewById(R.id.noteCard);
            view = itemView;//untuk menghendel click dari recyclerview item
        }
    }
}
