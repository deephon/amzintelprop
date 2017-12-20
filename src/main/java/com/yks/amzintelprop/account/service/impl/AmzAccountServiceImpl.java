package com.yks.amzintelprop.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.yks.amzintelprop.account.dao.IAmzAccountDao;
import com.yks.amzintelprop.account.dto.AmzAccount;
import com.yks.amzintelprop.account.dto.AmzAccountFilter;
import com.yks.amzintelprop.account.service.IAmzAccountService;
import com.yks.common.dto.PageBean;
import com.yks.common.util.UUIDGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:AmzAccountServiceImpl
 *
 * @Dec: 亚马逊账号业务处理接口实现类
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/19 16:18
 */
@Service
public class AmzAccountServiceImpl implements IAmzAccountService {

    @Resource
    private IAmzAccountDao dao;

    @Override
    public void insert(AmzAccount account) {
        account.setAccount_id(UUIDGenerator.getUUID());
        dao.insert(account);
    }

    @Override
    public Integer findByAccount(String account) {
        return dao.findByAccount(account);
    }

    @Override
    public List<AmzAccount> findByCond(AmzAccountFilter cond) {
        PageHelper.startPage(cond.getCurPage(), cond.getPageSize());
        List<AmzAccount> list = dao.findByCond(cond);
        int count = list.size();
        cond.setRowCount(count);
        int pageSize = cond.getPageSize();// 页大小
        int curPage = cond.getCurPage();// 当前页
        cond.setPageCount(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);// 页数
        PageBean<AmzAccount> pageData = new PageBean<>(cond.getCurPage(), cond.getPageSize(), count);
        pageData.setItems(list);
        return pageData.getItems();
    }

}
