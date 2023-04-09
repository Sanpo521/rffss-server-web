package io.renren.common.utils;

import io.renren.common.utils.result.SingleDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author zhaoxiubin
 * @create 2021-10-22 20:29
 * @desc 文件处理工具
 **/
public class FileUtils {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

    public static final int INITIAL_CAPACITY = 3;

    /**
     * 运行类根路径
     */
    private static final String CLASS_ROOT_PATH = "/";

    public static void saveTempFile(byte[] bytes, String tempPath, String fileName){
        OutputStream stream = null;
        File dir =new File(tempPath);
        if (!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        try {
            stream = new FileOutputStream(tempPath + "/" + fileName);
            stream.write(bytes);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (null!=stream){
                try {
                    stream.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    public static String getYmdPath(String pdfPath){
        String result = pdfPath.endsWith("/")?pdfPath:pdfPath + "/";
        File dir =new File(result);
        if (!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        Calendar cal = Calendar.getInstance();
        String year = String.valueOf(cal.get(Calendar.YEAR));
        result += year + "/";
        dir =new File(result);
        if (!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
        result += month + "/";
        dir =new File(result);
        if (!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        String day = String.valueOf(cal.get(Calendar.DATE));
        result += day + "/";
        dir =new File(result);
        if (!dir.exists() || !dir.isDirectory()){
            dir.mkdirs();
        }
        return result;
    }

    /**
     * 获取运行类物理路径
     * @return 运行类物理路径
     */
    public static String getClassRootPath(){
        return FileUtils.class.getResource(CLASS_ROOT_PATH).getPath();
    }

    /**
     * 读取指定目录下指定格式的文件列表
     * @param path 指定目录
     * @param suffix 指定格式，多种格式用|分隔；空为所有
     * @return 文件列表
     */
    public static SingleDataResponse getFileName(String path, String suffix){
        SingleDataResponse result = new SingleDataResponse<List<String>>();
        File dir =new File(path);
        if (!dir.exists()){
            result.setCode(1001);
            result.setMsg(path + "文件路径不存在！");
        }else{
            if(!dir.isDirectory()){
                result.setCode(1002);
                result.setMsg(path + "不是文件夹！");
            }else{
                //读取输入路径的文件
                List<String> fileList=new ArrayList<String>(INITIAL_CAPACITY);
                File[] list = new File(path).listFiles();
                for(File file : list){
                    if(file.isFile()){
                        if (!StringUtils.hasText(suffix)){
                            fileList.add(file.getAbsolutePath());
                        }else{
                            String[] suffixArray = suffix.split("\\|");
                            for (String suffixEx: suffixArray){
                                if (file.getName().endsWith(suffixEx)) {
                                    fileList.add(file.getAbsolutePath());
                                }
                            }
                        }
                    }
                }
                result.setCode(0);
                result.setMsg("共发现"+fileList.size()+"个文件");
                result.setData(fileList);
            }
        }
        return result;
    }

    /**
     * 读取jar类路径下的文件到二进制数组
     * @param fileName 文件路径
     * @return 二进制数组
     */
    public static byte[] classpathFile2Bytes(String fileName){
        byte[] result = null;
        return result;
    }

    /**
     * 读取jar类路径下的文件到字符串
     * @param fileName 文件路径
     * @return 字符串
     */
    public static String classpathFile2String(String fileName){
        StringBuffer result = new StringBuffer("");
        Resource resource = new ClassPathResource(fileName);
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            is = resource.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line = null;
            while((line = br.readLine()) != null) {
                result.append(line + "\n");
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }finally {
            if (null!=br){
                try {
                    br.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            if (null!=isr){
                try {
                    isr.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            if (null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
        return result.toString();
    }

    /**
     * 读取文件到字符串
     * @param path 文件路径
     * @return 字符串
     */
    public static String file2String(String path){
        File file = new File(path);
        return file2String(file);
    }

    /**
     * 读取文件到字符串
     * @param file 文件
     * @return 字符串
     */
    public static String file2String(File file){
        StringBuffer result = new StringBuffer("");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                result.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            if (null != isr){
                try {
                    isr.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
            if (null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
        return result.toString();
    }

}
