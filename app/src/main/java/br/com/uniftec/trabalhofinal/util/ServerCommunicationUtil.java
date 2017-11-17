package br.com.uniftec.trabalhofinal.util;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by lececatto on 16/11/2017.
 */

public class ServerCommunicationUtil {

    private static ServerCommunicationUtil instance;
    private Retrofit retrofit;

    private ServerCommunicationUtil(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("url")
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
