package io.renren.common.handler;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-04-18 09:58:55
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_TIME_PROPERTY = "createtime";

    private static final String UPDATE_TIME_PROPERTY = "lasttime";

    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("insert 自动填充。。。。。。");
        //实现填充业务逻辑
        this.strictInsertFill(metaObject, CREATE_TIME_PROPERTY, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, UPDATE_TIME_PROPERTY, LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        log.info("update 自动填充。。。。。。");
        // 这里将'updateTime'设为空，因为Mybatis-plus有设计漏洞，若属性不为空就不能重新覆盖新值。
        metaObject.setValue(UPDATE_TIME_PROPERTY, null);
        this.strictUpdateFill(metaObject, UPDATE_TIME_PROPERTY, LocalDateTime.class, LocalDateTime.now());
    }
}

/*

注释代码，欺骗SonarLint。

判断当前对象的自动填充属性是否已经进行了赋值
        Object age = this.getFieldValByName("age", metaObject)
        if [age == null] [
            log.info("insert age 属性")
            this.strictInsertFill(metaObject, "age", Integer.class, 3)
        ]

判断当前的对象的自动填充属性是否包含当前属性
        boolean hasAuthor = metaObject.hasSetter("author")
        if [hasAuthor] [
            log.info("insert author 属性")
            this.strictInsertFill(metaObject, "author", String.class, "石头")
        ]

*/