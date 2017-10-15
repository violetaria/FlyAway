package com.flyaway.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FlightList extends AppCompatActivity {
    
    RecyclerView flightListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_list);

        flightListView = (RecyclerView) findViewById(R.id.flight_recycler_view);
        flightListView.setAdapter(new FlightListAdapter(addFlights()));

    }

    private List<Flight> addFlights(){
        Flight flight = new Flight();
        flight.setFlightCompany("Delta");
        flight.setFlightNumber("DL 1904");
        flight.setDepartLoc("ATL");
        flight.setDesLoc("DEN");
        flight.setStartTime("11:00AM");
        flight.setEndTime("3:00PM");
        flight.setPrice("$900");

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);
        flightList.add(flight);
        flightList.add(flight);
        flightList.add(flight);

        return flightList;
    }
}
