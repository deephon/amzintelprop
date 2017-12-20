package com.yks.common.sys.dict.dto;

/**
 * ClassName:Dict
 *
 * @Dec: 字典实体类
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/11/7 9:53
 */
public class Dict {
    private String data_id;  //标识
    private String data_value;  //值
    private Integer data_key;   //编码
    private String type_id; //类型标识
    private Integer type_code;  //类型编码
    private String remark;  //备注

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getData_value() {
        return data_value;
    }

    public Dict setData_value(String data_value) {
        this.data_value = data_value;
        return this;
    }

    public Integer getData_key() {
        return data_key;
    }

    public Dict setData_key(Integer data_key) {
        this.data_key = data_key;
        return this;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public Integer getType_code() {
        return type_code;
    }

    public Dict setType_code(Integer type_code) {
        this.type_code = type_code;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Dict setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
