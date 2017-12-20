package com.yks.amzintelprop.account.dto;

import com.yks.common.dto.FilterBean;

/**
 * ClassName:AmzAccount
 *
 * @Dec: 亚马逊销售账号实体
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/19 16:04
 */
public class AmzAccountFilter extends FilterBean {
    private String account_id_c;  //账号ID
    private String account_c; //账号
    private String principal_c;   //账号负责人
    private String contact_c; //联系方式
    private String remark_c;  //备注说明

    public String getAccount_id_c() {
        return account_id_c;
    }

    public void setAccount_id_c(String account_id_c) {
        this.account_id_c = account_id_c;
    }

    public String getAccount_c() {
        return account_c;
    }

    public void setAccount_c(String account_c) {
        this.account_c = account_c;
    }

    public String getPrincipal_c() {
        return principal_c;
    }

    public void setPrincipal_c(String principal_c) {
        this.principal_c = principal_c;
    }

    public String getContact_c() {
        return contact_c;
    }

    public void setContact_c(String contact_c) {
        this.contact_c = contact_c;
    }

    public String getRemark_c() {
        return remark_c;
    }

    public void setRemark_c(String remark_c) {
        this.remark_c = remark_c;
    }
}
