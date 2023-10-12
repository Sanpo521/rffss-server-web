package io.renren.modules.rffssw.controller;


import io.renren.common.utils.R;
import io.renren.modules.rffssw.entity.UploadEntity;
import io.renren.modules.rffssw.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;




/**
 *
 * @author zzb
 * @description
 * @date Sun Oct 08 10:38:51 CST 2023
 */
@RestController
@RequestMapping("rffssw/upload")
public class UploadController {

	@Autowired
	private UploadService uploadService;



	/**
	* 查询文件
	*/
	@GetMapping("/select")
	public R list(@RequestParam String businessId,
	@RequestParam String business
	){
		List<UploadEntity> list = uploadService.getUpload(businessId,business);
		return R.ok().put("list", list);
	}



	/**
	* 上传文件
	*/
	@PostMapping("/save")
	public R save(@RequestParam MultipartFile content,
				  @RequestParam String businessId,
				  @RequestParam String business
				  ) throws IOException {
		UploadEntity upload=new UploadEntity();
		upload.setBusiness(business);
		upload.setBusinessId(businessId);
//		upload.setContent(content.getBytes());
		uploadService.save(upload);
		return R.ok();
	}


	/**
	* 删除文件
	*/
	@PostMapping("/delete")
	public R delete(@RequestParam("id") Long[] ids){
		uploadService.removeByIds(Arrays.asList(ids));
		return R.ok();
	}



}
