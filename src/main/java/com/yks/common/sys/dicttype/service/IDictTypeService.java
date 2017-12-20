package com.yks.common.sys.dicttype.service;

import com.yks.common.sys.dicttype.dto.DictType;

import java.util.Map;

/**
 * ClassName:IDictTypeService
 *
 * @Dec: 字典类型业务操作接口
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/11/17 11:46
 */
public interface IDictTypeService {

    /**
     * 按条件查询分页列表
     * @param cond
     * @param map
     */
    //public void queryList(DictTypeCond cond, Map<String, Object> map);

    /**
     * 新增字典类型
     * @param type
     */
    Integer insert(DictType type);

    /**
     * 根据条件查询数据个数
     * @param cond
     * @return
     */
    //Integer findCountByCond(DictTypeCond cond);

    /**
     * 根据ID查找字典类型
     * @param id
     * @return
     */
    DictType findById(String id);

    /**
     * 修改字典类型
     * @param type
     */
    Integer update(DictType type);

    /**
     * 根据ID删除字典类型
     * @param ids
     * @return
     */
    Integer delete(String ids);
}
