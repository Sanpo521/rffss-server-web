package io.renren.modules.rffssw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.rffssw.dao.UploadDao;
import io.renren.modules.rffssw.entity.UploadEntity;
import io.renren.modules.rffssw.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author zzb
 * @date Sun Oct 08 10:39:56 CST 2023
 */
@Service("UploadService")
public class UploadServiceImpl extends ServiceImpl<UploadDao, UploadEntity> implements UploadService{

	@Autowired
	private UploadDao Uploaddao;

	@Override
	public List<UploadEntity> getUpload(String businessId, String business) {
		QueryWrapper<UploadEntity> qu=new QueryWrapper<>();
		qu.eq("business_id",businessId);
		qu.eq("business",business);
		return Uploaddao.selectList(qu);
	}
}
