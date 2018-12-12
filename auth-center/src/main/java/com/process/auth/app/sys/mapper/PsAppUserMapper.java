package com.process.auth.app.sys.mapper;

import com.process.auth.app.sys.api.PsAppUserQuery;
import com.process.common.database.domain.PsSql;
import com.process.auth.core.security.domain.PsAppUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/9
 */
public interface PsAppUserMapper {

    class PsAppUserSqlBuilder extends PsSql {

        private void buildSelectSql() {
            SELECT("T.ID id");
            SELECT("T.USERNAME username");
            SELECT("T.PASSWORD password");
            SELECT("T.NICKNAME nickname");
            SELECT("T.SEX sex");
            SELECT("T.AGE age");
            SELECT("T.PHONE phone");
            SELECT("T.EMAIL email");
            SELECT("T.HEAD_IMG_URL headImgUrl");
            SELECT("T.ENABLE enable");
        }

        private void buildFromSql() {
            FROM("PS_AUTH_USER T");
        }

        private void buildFilterSql(PsAppUserQuery query) {
            ORDER_BY(query);
        }

        static final String PAGE_SQL = "pages";

        public String pages(PsAppUserQuery query) {
            buildSelectSql();
            buildFromSql();
            buildFilterSql(query);
            return toPagingSql(query);
        }

        static final String COUNT_SQL = "count";

        public String count(PsAppUserQuery query) {
            buildFromSql();
            buildFilterSql(query);
            return toCountSql();
        }

    }

    @SelectProvider(method = PsAppUserSqlBuilder.PAGE_SQL, type = PsAppUserSqlBuilder.class)
    List<PsAppUser> pages(PsAppUserQuery query);

    /**
     * 计数
     *
     * @param query
     * @return
     */
    @SelectProvider(method = PsAppUserSqlBuilder.COUNT_SQL, type = PsAppUserSqlBuilder.class)
    int total(PsAppUserQuery query);


    /**
     * 根据登陆名查询
     *
     * @param username
     * @return
     */
    @Select({
            "SELECT T.USERNAME username,",
            "T.PASSWORD password,T.NICKNAME nickname,",
            "T.SEX sex,T.AGE age,",
            "T.PHONE phone,T.EMAIL email,",
            "T.HEAD_IMG_URL headImgUrl,T.ENABLE enabled",
            "FROM PS_AUTH_USER T",
            "WHERE T.USERNAME = #{username}"
    })
    PsAppUser getEntityByName(String username);
}
