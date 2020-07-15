package com.kunguo.linghuawang.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author zhaomaohui
 * @ClassName: QiniuCloudUtil
 * @Description:
 * @date 2020/6/18
 */
public class QiniuCloudUtil {


    // 设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = "us2xqD9GXBSS2micL135dvEuIA3yXJRiLrArRdTb";
    private static final String SECRET_KEY = "of3Hwck__LQh1mI5x1VKF_qMwtqZ3eHbkFT70bma";

    // 要上传的空间名
    private static final String bucketname = "linghuawang";

    // 密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //上传
    public static String upload(MultipartFile uploadFile) throws IOException {
        // 创建上传对象，Zone*代表地区
        Configuration configuration = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(configuration);
        // 调用put方法上传
        String token = auth.uploadToken(bucketname);
        String  preName= "img"+ System.currentTimeMillis()+  uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".") + 1);//获取时间戳作为图片名
        try {
            Response response = uploadManager.put(uploadFile.getInputStream(), preName, token,null,null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
            return "http://qiniu.health123.cc/"+putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
                ex2.error();
            }
        }
        return null;
    }

}
