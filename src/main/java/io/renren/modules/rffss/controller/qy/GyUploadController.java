package io.renren.modules.rffss.controller.qy;


import io.renren.common.utils.R;
import io.renren.modules.rffss.entity.qy.GyUploadEntity;
import io.renren.modules.rffss.service.qy.GyUploadService;
import io.renren.modules.sys.oauth2.ShiroIgnoreAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:43
 */
@RestController
@RequestMapping("qy/gyupload")
public class GyUploadController {
    @Autowired
    private GyUploadService gyUploadService;




    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestParam("file") MultipartFile file) throws IOException {
        GyUploadEntity gyUpload=new GyUploadEntity();
        gyUpload.setType("0");
        gyUpload.setFileName(file.getOriginalFilename());
        gyUpload.setContent(Base64Utils.encodeToString(file.getBytes()));
		gyUploadService.save(gyUpload);
        return R.ok().put("id", gyUpload.getId());
    }


    /**
     * 信息
     */
    @ShiroIgnoreAuth
    @GetMapping("/info")
    public void info(@RequestParam("id") Long id, HttpServletResponse response){
        GyUploadEntity gyUpload = gyUploadService.getById(id);
        if(gyUpload!=null){
            byte[] bytes = Base64Utils.decodeFromString(gyUpload.getContent());
            try {
                setExportResponse(response, new ByteArrayInputStream(bytes),gyUpload.getFileName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * 设置文件下载
     *  @param response
     * @param in 文件流
     */
    private void setExportResponse(HttpServletResponse response, InputStream in,String fileName){
        try {
            response.setContentType("multipart/form-data");
            response.addHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
            int b = 0;
            byte[] buffer = new byte[512];
            while (b != -1) {
                b = in.read(buffer);
                if (b != -1) {
                    response.getOutputStream().write(buffer, 0, b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                response.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
