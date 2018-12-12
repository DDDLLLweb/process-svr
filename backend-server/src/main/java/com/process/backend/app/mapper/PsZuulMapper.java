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

    @Select({
            "SELECT ID id, PREFIX prefix, ",
            "PATH path, FULLPATH fullPath, ",
            "LOCATION location, RETRYABLE retryable, ",
            "SENSITIVEHEADERS sensitiveheaders",
            "FROM PS_ZUUL_ROUTE"
    })
    List<PsZuulRouter> routes();

}
