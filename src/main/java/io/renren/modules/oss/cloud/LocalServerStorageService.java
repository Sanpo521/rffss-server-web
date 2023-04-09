package io.renren.modules.oss.cloud;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.sign.Credentials;
import io.renren.common.exception.RRException;
import io.renren.common.utils.DateUtils;
import io.renren.common.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.UUID;

/**
 * @author zhaoxiubin
 * @create 2022-11-04 15:27
 * @desc 本地服务器存储
 **/
@Slf4j
public class LocalServerStorageService extends CloudStorageService {
    /**
     * 文件服务器存放地址
     */
    private String filePath;
    /**
     * 文件访问地址
     */
    private String urlPath;

    public LocalServerStorageService(CloudStorageConfig config){
        this.config = config;
        //初始化
        init();
    }

    private void init(){
        filePath = FileUtils.getYmdPath(config.getLocalFilePath());
        if(!filePath.endsWith("/")) {
            filePath = filePath + "/";
        }
        urlPath = filePath.replace(config.getLocalFilePath(), "");
        String startUrl = config.getLocalStartUrl();
        if(!startUrl.endsWith("/")) {
            startUrl = startUrl + "/";
        }
        if(urlPath.startsWith("/")) {
            urlPath = urlPath.substring(1, urlPath.length()-1);
        }
        if(!urlPath.endsWith("/")) {
            urlPath = urlPath + "/";
        }
        urlPath = startUrl + urlPath;
    }

    @Override
    public String upload(byte[] data, String path) {
        String fullFileName;
        String fullUrl = "";
        if(path.startsWith("/")) {
            path = path.replace("/", "");
        }
        if(StringUtils.isNotEmpty(path)) {
            fullFileName = filePath + path;
            fullUrl = urlPath + path;
        }else{
            //生成uuid
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fullFileName = filePath + uuid;
            fullUrl = urlPath + uuid;
        }
        OutputStream stream = null;
        try {
            stream = new FileOutputStream(fullFileName);
            stream.write(data);
        } catch (FileNotFoundException e) {
            fullUrl = "";
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            fullUrl = "";
            log.error(e.getMessage(), e);
        } finally {
            if (null!=stream){
                try {
                    stream.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return fullUrl;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return upload(data, uuid+suffix);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        //生成uuid
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return upload(data, path);
        } catch (IOException e) {
            throw new RRException("上传文件失败", e);
        }
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        //生成uuid
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            return upload(data, uuid+suffix);
        } catch (IOException e) {
            throw new RRException("上传文件失败", e);
        }
    }
}
