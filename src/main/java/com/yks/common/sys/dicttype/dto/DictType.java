package com.yks.common.sys.dicttype.dto;

/**
 * ClassName:DictType
 *
 * @Dec: 字典类型实体类
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/11/7 9:54
 */
public class DictType {
    private String type_id;  //标识
    private String type_name;   //编码值
    private Integer type_code;  //编码
    private String remark;  //备注

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public DictType setType_name(String type_name) {
        this.type_name = type_name;
        return this;
    }

    public Integer getType_code() {
        return type_code;
    }

    public DictType setType_code(Integer type_code) {
        this.type_code = type_code;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public DictType setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
