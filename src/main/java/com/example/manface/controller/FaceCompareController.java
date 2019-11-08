package com.example.manface.controller;

import com.baidu.aip.face.AipFace;
import com.example.manface.common.FaceClient;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/face")
public class FaceCompareController {
    @RequestMapping("/testFace")
    @ResponseBody
    public String ggg(String imgString){
        AipFace client = FaceClient.getClient();
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("face_field", "age,beauty,gender");
        options.put("max_face_num", "2");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");

        String image = imgString;
        String imageType = "BASE64";

//        String groupIdList = "test";
//
//
//        // 人脸搜索
//        JSONObject res = client.search(image, imageType, groupIdList, options);

//        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);
        return res.toString(2);
    }
}
