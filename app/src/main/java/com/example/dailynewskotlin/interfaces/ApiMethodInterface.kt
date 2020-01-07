package com.example.dailynewskotlin.interfaces

import com.example.dailynewskotlin.models.ApiModels
import com.example.dailynewskotlin.view.Test
import retrofit2.Call
import retrofit2.http.GET

interface ApiMethodInterface {



    @GET("svc/archive/v1/2019/12.json?api-key=F4bsn22LWqBDqKsJuBhwVuP44tsOiN0y")
     fun doGetListResources(): Call<Test>
}

