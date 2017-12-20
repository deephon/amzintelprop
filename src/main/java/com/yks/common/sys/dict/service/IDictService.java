package com.yks.common.sys.dict.service;

import com.yks.common.sys.dict.dto.Dict;

import java.util.List;
import java.util.Map;

/**
 * ClassName:IDictService
 *
 * @Dec: 字典业务操作接口
 * Company:www.yks.com
 * @Author 125C01063135
 * @Date 2017/11/7 17:59
 */
public interface IDictService {

    /**
     * 按条件查询不分页列表(使用类型)
     * @param cond
     * @return
     */
    //public List<Dict> queryAllObj(DictCond cond);

    /**
     * 分页查询字典
     * @param cond
     * @param map
     */
    //void queryList(DictCond cond, Map<String, Object> map);

    /**
     * 查找相关字典类型中的编码是否存在
     * @param cond
     * @return
     */
    //Integer findCountByCond(DictCond cond);

    /**
     * 新增字典
     * @param dict
     */
    Integer insert(Dict dict);

    /**
     * 根据ID查找相关字典
     * @param id
     * @return
     */
    Dict findById(String id);

    /**
     * 更新字典
     * @param dict
     * @return
     */
    Integer update(Dict dict);

    /**
     * 根据ID删除字典
     * @param id
     */
    Integer delete(String id);
}
