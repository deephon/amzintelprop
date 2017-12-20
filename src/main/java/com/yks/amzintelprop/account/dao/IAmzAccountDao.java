package com.yks.amzintelprop.account.dao;

import com.yks.amzintelprop.account.dto.AmzAccount;
import com.yks.amzintelprop.account.dto.AmzAccountFilter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * ClassName:IAmzAccountDao
 *
 * @Dec: 亚马逊账号底层处理接口
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/19 16:07
 */
public interface IAmzAccountDao {

    /**
     * 新增账号
     * @param account
     */
    @Insert("insert into amz_account(account_id,account,principal,contact,remark) values (#{account_id},#{account},#{principal},#{contact},#{remark})")
    void insert(AmzAccount account);

    /**
     * 根据账号查找相关数据
     * @param account
     * @return
     */
    @Select("select count(1) from amz_account where account = #{account}")
    Integer findByAccount(String account);

    @SelectProvider(type = AmzAccountSqlProvider.class,method = "findByCond")
    List<AmzAccount> findByCond(AmzAccountFilter cond);
}
