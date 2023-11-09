package io.renren.modules.rffssw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.rffssw.entity.UploadEntity;

import java.util.List;

/**
 *
 * @author zzb
 * @date Sun Oct 08 10:39:42 CST 2023
 */
public interface UploadService extends IService<UploadEntity>{
    List<UploadEntity> getUpload(String businessId, String business);

    List<UploadEntity> getUpload(String businessId);
}
