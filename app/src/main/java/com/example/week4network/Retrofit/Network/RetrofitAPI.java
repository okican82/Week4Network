package com.example.week4network.Retrofit.Network;

import com.example.week4network.Retrofit.Entity.Comment;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface RetrofitAPI {

    @GET("/posts")
    Call<ResponseBody> getPosts();

    @GET("/users")
    Call<ResponseBody> getUsers();

    @POST("/users")
    Call<ResponseBody> postUser(@Body RequestBody requestBody);

    @GET("/posts")
    Call<ResponseBody> getPostsByUser(@Query("userId") int userId);

    @GET("/posts")
    Call<ResponseBody> getPostsByUserAndPostId(@Query("userId") int userId, @Query("id") int postId);

    @GET("/posts")
    Call<ResponseBody> getPostByParams(@QueryMap HashMap<String,String> params);

    @GET("/posts/{id}")
    Call<ResponseBody> getPostById(@Path("id") int id);

    @GET("https://api.ipify.org/")
    Call<ResponseBody> getDifferentEndpoint();

    @GET
    Call<ResponseBody> sendRequest(@Url String url);

    @Headers({
            "Content-Type:application/json",
            "User-Agent:Retrofit SENG405",
    })
    @GET("https://httpbin.org/get")
    Call<ResponseBody> sendRequestWithHeader();

    @GET("https://httpbin.org/get")
    Call<ResponseBody> sendRequestWithHeaderDynamic(@Header("Content-Type") String contentType, @Header("User-Agent") String userAgent);

    @GET("/comments/{id}")
    Call<Comment> getCommentById(@Path("id") int id);

}
