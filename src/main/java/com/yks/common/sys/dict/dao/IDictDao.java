package com.yks.common.sys.dict.dao;

import com.yks.common.sys.dict.dto.Dict;

import java.util.List;
import java.util.Map;

/**
 * ClassName:IDictDao
 *
 * @Dec: 字典持久层接口
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/11/7 14:37
 */
public interface IDictDao {
    /**
     * 新增字典类型
     * @param dict
     * @return
     */
    public Integer insert(Dict dict);

    /**
     * 单独或批量删除字典类型
     * @param ids
     * @return
     */
    public Integer delete(String ids);

    /**
     * 更新字典类型
     * @param dict
     * @return
     */
    public Integer update(Dict dict);

    /**
     * 根据ID查找单独的字典类型
     * @param id
     * @return
     */
    public Dict findById(String id);

    /**
     * 按条件查询分页列表
     * @param cond
     * @param map
     */
    //public void queryList(DictCond cond, Map<String, Object> map);

    /**
     * 按条件查询不分页列表（使用类型）
     * @param cond
     * @return
     */
    //List<Dict> queryAllObj(DictCond cond);

    /**
     * 根据筛选条件查找已经存在的数据
     * @param cond
     * @return
     */
    //Integer findCountByCond(DictCond cond);
}
