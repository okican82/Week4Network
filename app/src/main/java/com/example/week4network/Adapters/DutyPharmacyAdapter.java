package com.example.week4network.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.week4network.Activities.DutyPharmacyDetailActivity;
import com.example.week4network.Entity.DutyPharmacy;
import com.example.week4network.R;

import java.util.ArrayList;

public class DutyPharmacyAdapter extends RecyclerView.Adapter<DutyPharmacyAdapter.ViewHolder> {

    private ArrayList<DutyPharmacy> dutyPharmacyItemList;


    public DutyPharmacyAdapter( ArrayList<DutyPharmacy> dutyPharmacyItemList) {
        this.dutyPharmacyItemList = dutyPharmacyItemList;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        DutyPharmacy dutyPharmacy = dutyPharmacyItemList.get(position);
        holder.dist_txt.setText(dutyPharmacy.getDist());
        holder.name_txt.setText(dutyPharmacy.getName());
        holder.adress_txt.setText(dutyPharmacy.getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DutyPharmacyDetailActivity.class);
                intent.putExtra("dutyPharmacyObject",dutyPharmacy);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.duty_pharmacy_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return dutyPharmacyItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView dist_txt;
        private TextView name_txt;
        private TextView adress_txt;


        public ViewHolder(View v) {
            super(v);
            dist_txt = v.findViewById(R.id.dist_txt);
            name_txt = v.findViewById(R.id.name_txt);
            adress_txt = v.findViewById(R.id.adress_txt);
        }
    }
}
