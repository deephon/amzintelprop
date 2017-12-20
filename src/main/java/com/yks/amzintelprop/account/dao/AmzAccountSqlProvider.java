package com.yks.amzintelprop.account.dao;

import com.yks.amzintelprop.account.dto.AmzAccountFilter;
import org.apache.ibatis.jdbc.SQL;

/**
 * ClassName:AmzAccountSqlProvider
 *
 * @Dec: 亚马逊账号动态SQL处理器
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/20 17:11
 */
public class AmzAccountSqlProvider {

    public String findByCond(AmzAccountFilter filter) {
        return new SQL(){{
            SELECT("account_id,account,principal,contact,remark");
            FROM("amz_account");
            if (null != filter.getAccount_c()) {
                WHERE("account like concat('%',#{account_c},'%')");
            }
            if (null != filter.getPrincipal_c()) {
                WHERE("principal like concat('%',#{principal_c},'%')"); //如果报错，可尝试 like concat('%',#{roleName},'%')
            }
        }}.toString();
    }
}
