package com.flyaway.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Yvonne on 10/15/2017.
 */

public class FlightListAdapter extends RecyclerView.Adapter<FlightListAdapter.FlightVH> {

    List<Flight> mFlights;

    public FlightListAdapter(List<Flight> flights) {
        mFlights = flights;
    }

    @Override
    public FlightVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.flight_row, parent, false);
        return new FlightVH(itemView);
    }

    @Override
    public void onBindViewHolder(FlightListAdapter.FlightVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mFlights.size();
    }

    public class FlightVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView flightNumber;
        TextView startTime;
        TextView endTime;
        TextView flightCompany;
        TextView price;
        TextView desLoc, departLoc, retDesLoc, retDepartLoc;
        public FlightVH(View itemView) {
            super(itemView);

            flightCompany = itemView.findViewById(R.id.flight_comp);
            price = itemView.findViewById(R.id.flight_price);
            //startTime = itemView.findViewById(R.id.des)
            retDepartLoc = itemView.findViewById(R.id.ret_depart_loc);
            retDesLoc = itemView.findViewById(R.id.ret_des_loc);
            //flightNumber = itemView.findViewById(R.id.)
            departLoc = itemView.findViewById(R.id.depart_loc);
            desLoc = itemView.findViewById(R.id.des_loc);

            itemView.setOnClickListener(this);
        }

        // Handles the row being being clicked
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                Intent intent = new Intent(v.getContext(), PaymentSummary.class);
                v.getContext().startActivity(intent);
            }
        }
    }
}
