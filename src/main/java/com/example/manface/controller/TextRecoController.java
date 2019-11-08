package com.example.manface.controller;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.ocr.AipOcr;
import com.example.manface.common.FaceClient;
import com.example.manface.common.TextRecoClient;
import com.example.manface.utils.ImageBase64Utils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.HashMap;
@Controller
@RequestMapping("/text")
public class TextRecoController {

    @RequestMapping("/textReco")
    @ResponseBody
    public String textReco(String imgString){
        AipOcr client = TextRecoClient.getClient();
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");


        // 参数为本地路径
//        String image = "test.jpg";
//        JSONObject res = client.basicGeneral(image, options);
//        System.out.println(res.toString(2));
        // 参数为二进制数组
        BASE64Decoder d = new BASE64Decoder();
        byte[] file = new byte[0];
        try {
            file = d.decodeBuffer(imgString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject res = client.basicGeneral(file, options);

//        // 通用文字识别, 图片参数为远程url图片
//        JSONObject res = client.basicGeneralUrl(url, options);
        return res.toString(2);
    }
}
