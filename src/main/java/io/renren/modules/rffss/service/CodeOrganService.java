package io.renren.modules.rffss.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.CodeOrganEntity;

import java.util.List;
import java.util.Map;

/**
 * 登记机关代码表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2021-11-08 14:31:41
 */
public interface CodeOrganService extends IService<CodeOrganEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据父级code获取子CodeOrgan
     * @param parentcode
     * @return
     */
    JSONArray queryTree(String parentcode);

    /**
     * 根据code获取子CodeOrgan
     * @param code
     * @return
     */
    JSONArray queryTreeEx(String code);


    /**
     * 根据code获取CodeOrgan
     * @param code
     * @return
     */
    CodeOrganEntity getByCode(String code);

    /**
     * 根据name获取CodeOrgan
     * @param name
     * @return
     */
    CodeOrganEntity getByName(String name);

    /**
     * 根据父级code获取子CodeOrgan
     * @param parentcode
     * @return
     */
    List<CodeOrganEntity> getByParentcode(String parentcode);


    /**
     * 根据key，查询value
     */
    List<CodeOrganEntity> queryListByCode(String orgcode);
}

