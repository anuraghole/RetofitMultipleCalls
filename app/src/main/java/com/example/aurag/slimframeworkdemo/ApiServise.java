package com.example.aurag.slimframeworkdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServise {

    @FormUrlEncoded
    @HTTP(method = "GET", path = "/users")
    Call<List<User>> getAllUser();

    @FormUrlEncoded
    @GET("/users/{id}")
    Call<User> getUserById(@Path("id") String id);

    @FormUrlEncoded
    @HTTP(method = "POST",path = "/users/insert",hasBody = true)
    Call<User> insertUser(@Field("name") String name,
                          @Field("username") String username,
                          @Field("password") String password,
                          @Field("api_key") String api_key);

    @FormUrlEncoded
    @HTTP(method = "PUT", path = "/users/update")
    Call<User> updateUser(@Field("name") String name);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "/users/delete")
    Call<User> deleteUser(@Field("name") String name);

    @FormUrlEncoded
    @POST("/users/body")
    Call<User> postUserBody(@Body User user);

    @GET("/query")
    Call<User> postUserBody(@Query("name") String name,@Query("id") String id);


}
