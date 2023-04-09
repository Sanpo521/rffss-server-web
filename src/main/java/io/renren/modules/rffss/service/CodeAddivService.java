package io.renren.modules.rffss.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.CodeAddivEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoxiubin
 * create-time 2023-04-05 11:52
 * description 代码集--行政区划Service
 **/

public interface CodeAddivService extends IService<CodeAddivEntity> {

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
    CodeAddivEntity getByCode(String code);

    /**
     * 根据name获取CodeOrgan
     * @param name
     * @return
     */
    CodeAddivEntity getByName(String name);

    /**
     * 根据父级code获取子CodeOrgan
     * @param parentcode
     * @return
     */
    List<CodeAddivEntity> getByParentcode(String parentcode);


    /**
     * 根据key，查询value
     */
    List<CodeAddivEntity> queryListByCode(String orgcode);
}
