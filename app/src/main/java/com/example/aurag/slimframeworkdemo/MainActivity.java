package com.example.aurag.slimframeworkdemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.net.URI;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    void uploadImage(String filepath){
        Uri fileUri=null;
        File originalFile=new File(filepath);

        RequestBody descriptionPart=RequestBody.create(MultipartBody.FORM,"file description");


        RequestBody filepart=RequestBody.create(
                MediaType.parse(getContentResolver().getType(fileUri)),
                originalFile
        );

        MultipartBody.Part file=MultipartBody.Part.createFormData("photo",
                originalFile.getName(),
                filepart);




        ApiServiceDelStud apiServiceDelStud=ApiClient.getClient().create(ApiServiceDelStud.class);

       // Call<ResponseBody> call=apiServiceDelStud.imageUpload(descriptionPart,file);
        Call<ResponseBody> call = apiServiceDelStud.imageUpload(descriptionPart, file);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){

                }else {
                    ApiError apiError=ErrorUtils.parseError(response);
                    Toast.makeText(MainActivity.this, apiError.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
