package br.com.uniftec.trabalhofinal.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by lececatto on 16/11/2017.
 */

public class ServerCommunicationUtil {

    private static ServerCommunicationUtil instance;
    private Retrofit retrofit;

    private ServerCommunicationUtil(){
        OkHttpClient client = new OkHttpClient.Builder()
                                    .connectTimeout(60, TimeUnit.SECONDS)
                                    .readTimeout(60, TimeUnit.SECONDS)
                                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://54.207.42.228:4040/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        this.retrofit = retrofit;
    }

    public static ServerCommunicationUtil getInstance(){
        if (instance == null){
            instance = new ServerCommunicationUtil();
        }

        return instance;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
