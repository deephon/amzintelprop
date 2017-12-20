package com.yks.common.sys.dicttype.dao;

import com.yks.common.sys.dicttype.dto.DictType;

import java.util.Map;

/**
 * ClassName:IDictTypeDao
 *
 * @Dec: 字典类型持久层接口
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/11/7 12:00
 */
public interface IDictTypeDao {
    /**
     * 新增字典类型
     * @param type
     * @return
     */
    public Integer insert(DictType type);

    /**
     * 单独或批量删除字典类型
     * @param ids
     * @return
     */
    public Integer delete(String ids);

    /**
     * 更新字典类型
     * @param type
     * @return
     */
    public Integer update(DictType type);

    /**
     * 根据ID查找单独的字典类型
     * @param id
     * @return
     */
    public DictType findById(String id);

    /**
     * 按条件查询分页列表
     * @param cond
     * @param map
     */
    //public void queryList(DictTypeCond cond, Map<String, Object> map);

    /**
     * 查询符合查询条件的数据条数
     * @param cond
     * @return
     */
    //Integer findCountByCond(DictTypeCond cond);
}
