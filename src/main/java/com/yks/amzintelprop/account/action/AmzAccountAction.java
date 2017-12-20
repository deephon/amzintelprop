package com.yks.amzintelprop.account.action;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.yks.amzintelprop.account.dto.AmzAccount;
import com.yks.amzintelprop.account.dto.AmzAccountFilter;
import com.yks.amzintelprop.account.service.IAmzAccountService;
import com.yks.common.dto.FilterBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:AmzAccountAction
 *
 * @Dec: 亚马逊账号视图处理层
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/19 16:44
 */
@Controller
@RequestMapping("/amzaccount")
public class AmzAccountAction {

    @Autowired
    private IAmzAccountService service;

    @RequestMapping("/list")
    public String list(Map<String,Object> map,@ModelAttribute("cond") AmzAccountFilter cond) {
        List<AmzAccount> list = service.findByCond(cond);
        map.put("dataList", list);
        return "amzaccount/list";
    }

    public Map<String,Object> insert(@ModelAttribute("account") AmzAccount account) {
        Map<String, Object> map = new HashMap<>();
        Integer count = service.findByAccount(account.getAccount());
        if (count > 0) {
            map.put("success", 1);
            map.put("result", "账号已经存在。");
        } else {
            service.insert(account);
            map.put("success", 0);
            map.put("result", "新增账号成功。");
        }
        return map;
    }
}
