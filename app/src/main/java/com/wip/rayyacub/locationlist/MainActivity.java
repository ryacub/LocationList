package com.wip.rayyacub.locationlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wip.rayyacub.locationlist.Adapter.LocationAdapter;
import com.wip.rayyacub.locationlist.Model.DataList;
import com.wip.rayyacub.locationlist.Model.LocationData;
import com.wip.rayyacub.locationlist.Network.ApiClient;
import com.wip.rayyacub.locationlist.Network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<LocationData> locationDataList;
    LocationAdapter locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvInit();
        networkCall();
    }
    //recycler view initialization
    private void rvInit() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
    //doing the network call
    private void networkCall() {
        ApiClient.getClient()
                .create(ApiInterface.class)
                .getData()
                .enqueue(new Callback<DataList>() {
                    @Override
                    public void onResponse(Call<DataList> call, Response<DataList> response) {
                        locationDataList = response.body().getLocationData();
                        locationAdapter = new LocationAdapter(locationDataList, MainActivity.this);
                        recyclerView.setAdapter(locationAdapter);
                    }

                    @Override
                    public void onFailure(Call<DataList> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "total list failure" + call.request().url(), Toast.LENGTH_LONG).show();

                    }
                });
    }


}
