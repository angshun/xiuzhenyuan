//package util;
//
//import com.google.gson.Gson;
//import com.qiniu.common.QiniuException;
//import com.qiniu.common.Zone;
//import com.qiniu.http.Response;
//import com.qiniu.storage.Configuration;
//import com.qiniu.storage.UploadManager;
//import com.qiniu.storage.model.DefaultPutRet;
//import com.qiniu.util.Auth;
//
///**
// * Created by shun 2017.08.05.00 00:13
// */
//public class UploadImg {
//
//    public static String Upload() {
//
//
////构造一个带指定Zone对象的配置类
//        Configuration cfg = new Configuration(Zone.zone2());
////...其他参数参考类注释
//        UploadManager uploadManager = new UploadManager(cfg);
////...生成上传凭证，然后准备上传
//        String accessKey = "453cqyAZLfzHAyDaph3433Pv0mQz0FwEytk0uPO-";
//        String secretKey = "gbJ8N4vf3QVjW1DYC1P5Y3U1bo7w-yFM39emkttD";
//        String bucket = "bangbang";
////如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "/users/shun/downloads/Java-任务概要.jpg";
////默认不指定key的情况下，以文件内容的hash值作为文件名
//        String key = "Java.jpg";
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//        try {
//            Response response = uploadManager.put(localFilePath, key, upToken);
//            //解析上传成功的结果
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
//        } catch (QiniuException ex) {
//            Response r = ex.response;
//            System.err.println(r.toString());
//            try {
//                System.err.println(r.bodyString());
//            } catch (QiniuException ex2) {
//                //ignore
//            }
//        }
//
//        return "http://ou61wvqp5.bkt.clouddn.com/"+key;
//
//    }
//}
