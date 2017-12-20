package com.yks.amzintelprop.account.service;

import com.yks.amzintelprop.account.dto.AmzAccount;
import com.yks.amzintelprop.account.dto.AmzAccountFilter;

import java.util.List;

/**
 * ClassName:IAmzAccountService
 *
 * @Dec: 亚马逊账号业务处理层接口
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/19 16:18
 */
public interface IAmzAccountService {

    /**
     * 新增账户
     * @param account
     */
    void insert(AmzAccount account);

    /**
     * 根据账户名查找账号是否已经存在
     * @param account
     * @return
     */
    Integer findByAccount(String account);

    /**
     * 根据查询条件获取相关数据
     * @param cond
     * @return
     */
    List<AmzAccount> findByCond(AmzAccountFilter cond);
}
