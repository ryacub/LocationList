package com.wip.rayyacub.locationlist.Network;


import com.wip.rayyacub.locationlist.Model.DataList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("service/v2/upcomingGuides/")
    Call<DataList> getData();
}
