package com.process.backend.app.mapper;

import com.process.common.database.domain.PsSql;
import com.process.common.domain.PsZuulRouter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
public interface PsZuulMapper {

    class PsZuulSqlBuilder extends PsSql {

    }

    /**
     * 查询
     *
     * @return
     */
    @Select({
            "SELECT ID id, strip_prefix stripPrefix, ",
            "PATH path, URL url, ",
            "SERVICE_ID serviceId, RETRYABLE retryable, ",
            "SENSITIVE_HEADERS sensitiveHeaders,",
            "CUSTOM_SENSITIVE_HEADERS customSensitiveHeaders",
            "FROM PS_ZUUL_ROUTE"
    })
    List<PsZuulRouter> routes();

}
