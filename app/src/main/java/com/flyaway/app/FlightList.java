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

        Flight flight2 = new Flight();
        flight.setFlightCompany("Delta");
        flight.setFlightNumber("DL 1888");
        flight.setDepartLoc("ATL");
        flight.setDesLoc("DEN");
        flight.setStartTime("8:00AM");
        flight.setEndTime("3:00PM");
        flight.setPrice("$1887");

        Flight flight3 = new Flight();
        flight.setFlightCompany("Delta");
        flight.setFlightNumber("DL 1440");
        flight.setDepartLoc("ATL");
        flight.setDesLoc("DEN");
        flight.setStartTime("3:00PM");
        flight.setEndTime("7:00PM");
        flight.setPrice("$500");

        Flight flight4 = new Flight();
        flight.setFlightCompany("Delta");
        flight.setFlightNumber("DL 1903");
        flight.setDepartLoc("ATL");
        flight.setDesLoc("DEN");
        flight.setStartTime("1:00AM");
        flight.setEndTime("3:00PM");
        flight.setPrice("$1900");

        Flight flight5 = new Flight();
        flight.setFlightCompany("Delta");
        flight.setFlightNumber("DL 1904");
        flight.setDepartLoc("ATL");
        flight.setDesLoc("DEN");
        flight.setStartTime("5:00AM");
        flight.setEndTime("10:00PM");
        flight.setPrice("$1400");

        Flight flight6 = new Flight();
        flight.setFlightCompany("Delta");
        flight.setFlightNumber("DL 1904");
        flight.setDepartLoc("ATL");
        flight.setDesLoc("DEN");
        flight.setStartTime("5:00AM");
        flight.setEndTime("10:00PM");
        flight.setPrice("$1400");

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);
        flightList.add(flight2);
        flightList.add(flight3);
        flightList.add(flight4);
        flightList.add(flight5);
        flightList.add(flight6);

        return flightList;
    }
}
