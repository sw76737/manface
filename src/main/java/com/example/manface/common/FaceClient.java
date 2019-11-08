package com.example.manface.common;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

public class FaceClient {
    //设置APPID/AK/SK
    public static final String APP_ID = "17709784";
    public static final String API_KEY = "b75Txd4yZiUYeKmAx0YH5KYT";
    public static final String SECRET_KEY = "GUMVyKL9ULu2mSpCRZhw8x0dAY1yLHao";

    public volatile  static AipFace client;

    public static AipFace getClient() {
        if (client == null) {
            synchronized (AipFace.class) {
                if (client == null) {
                    client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return client;
    }
}