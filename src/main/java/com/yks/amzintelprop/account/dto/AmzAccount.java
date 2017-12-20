package com.yks.amzintelprop.account.dto;

/**
 * ClassName:AmzAccount
 *
 * @Dec: 亚马逊销售账号实体
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/12/19 16:04
 */
public class AmzAccount {
    private String account_id;  //账号ID
    private String account; //账号
    private String principal;   //账号负责人
    private String contact; //联系方式
    private String remark;  //备注说明

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
