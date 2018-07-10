package com.example.aurag.slimframeworkdemo;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiServiceDelStud {


    // GET request to specific userList
    @GET("/user/anu/repos")
    Call<List<User>> userList(String user);


    // GET request to dynamic userList
    @GET("/user/{user}/repos")
    Call<List<User>> duserList(@Path("user") String user);


    // POST request using java object to register a User
    @POST("user")
    Call<User> userRegistration(@Body User user);


    // POST request using java object to update a User
    @PUT("user")
    Call<User> userUpdate(@Body User user);


    //uploading image to server Using @Multipart and Multipart.Body
    @Multipart
    @POST("imageUpload")
    Call<ResponseBody> imageUpload(
            @Part("description") RequestBody desc,
            @Part MultipartBody.Part image
    );


    //sending Multiple Parts alog with file using @PartMap
    @Multipart
    @POST("imageUpload")
    Call<ResponseBody> imageUpload(
            @PartMap Map<String, RequestBody> data,
            @Part MultipartBody.Part image
    );


    //sending Multiple multiple files
    @Multipart
    @POST("imageUpload")
    Call<ResponseBody> uploadImages(
            @Part MultipartBody.Part image,
            @Part MultipartBody.Part image2
    );


    //sending Multiple multiple files at time(uploading Album)
    Call<ResponseBody> uploadAlbum(
            @Part("description") RequestBody description,
            @Part List<MultipartBody.Part> files
    );


    //setting single Header using @Headers
    @Headers("Cache-Control: max-age=3600")
    @POST("/user")
    Call<User> registerUser(@Body User user);


    //setting multiple Header values using @Headers
    @Headers({
            "Cache-Control: max-age=3600",
            "user-Agent   :Android"
    })
    @POST("/user")
    Call<User> registerUserr(@Body User user);


    //setting dynamic Header using @Header
    @Headers({
            "Cache-Control: max-age=3600",
            "user-Agent   :Android"
    })
    @POST("/user")
    Call<User> registerUserr(
            @Header("UserName") String username,
            @Body User user
    );

    //Dynamic url for request @Url
    @GET
    Call<RequestBody> getPhoto(@Url String url);

    //download file using Static url
    @GET("/user/profile/image.jpg")
    Call<ResponseBody> downloadImage();

    //download file using dynamic url
    @GET
    Call<ResponseBody> downloadImage(@Url String url);

    //download file using  url and @Streaming
    @Streaming
    @GET
    Call<ResponseBody> downloadImageStream(@Url String url);

    //sending form data using @FormUrlEncoded
    @FormUrlEncoded
    @POST("/user")
    Call<User> sendForm(@Field("name") String name,
                        @Field("email") String email,
                        @Field("mobile") String mobile,
                        @Field("hobbies") String hobbies);

    //sending form data with list using @FormUrlEncoded
    @FormUrlEncoded
    @POST("/user")
    Call<User> sendForm(@Field("name") String name,
                        @Field("email") String email,
                        @Field("mobile") String mobile,
                        @Field("hobbies") List<String> hobbies);


    //instead of sending multiple fields we can send one Map Object using @FieldMap
    //here we will not get the 'List<Strings> hobbies' values in the form of array because we cannot apply split(",") on Object object
    @FormUrlEncoded
    @POST("/user")
    Call<User> sendForm(@FieldMap Map<String,Object> map);

    /*if we want 'List<Strings> hobbies' value in the form of array the we have to pass
    'List<Strings> hobbies' as a separate parameter*/
    @FormUrlEncoded
    @POST("/user")
    Call<User> sendForm(@FieldMap Map<String,String> map,
                        @Field("hobbies") List<String> hobbies);



}
