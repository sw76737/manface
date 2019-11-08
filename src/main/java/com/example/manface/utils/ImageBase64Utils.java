package com.example.manface.utils;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class ImageBase64Utils {
    public static String getImageStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            return null;
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    public static boolean getImageByBase64Str(String base64str, String savepath) {
        if (base64str == null) {
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(base64str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(savepath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] getImageByBase64Str1(String base64str, String savepath) {
        if (base64str == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(base64str);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(savepath);
            out.write(b);
            out.flush();
            out.close();
            return b;
        } catch (Exception e) {
            return null;
        }
    }

//    /**
//     * base64字符串转文件
//     * @param base64
//     * @return
//     */
//    public static File base64ToFile(String base64) {
//        File file = null;
//        String fileName = "IMG/logo.png";
//        FileOutputStream out = null;
//        try {
//            // 解码，然后将字节转换为文件
//            file = new File(Environment.getExternalStorageDirectory(), fileName);
//            if (!file.exists())
//                file.createNewFile();
//            byte[] bytes = Base64.decode(base64);// 将字符串转换为byte数组
//            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
//            byte[] buffer = new byte[1024];
//            out = new FileOutputStream(file);
//            int bytesum = 0;
//            int byteread = 0;
//            while ((byteread = in.read(buffer)) != -1) {
//                bytesum += byteread;
//                out.write(buffer, 0, byteread); // 文件写操作
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } finally {
//            try {
//                if (out!= null) {
//                    out.close();
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return file;
//    }

}