package io.renren.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxiubin
 * @create 2022-11-05 16:00
 * @desc 配置
 **/
@Data
@Configuration
public class RffssConfig {
    /**
     * ID前缀
     */
    @Value("${rffss.idprefix}")
    private String idprefix;
}
