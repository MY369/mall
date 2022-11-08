package com.macro.mall.search.dao;

import com.macro.mall.search.domain.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索商品管理自定义Dao
 * ///////////根据id查询产品, 这个接口是对数据库的操作!!!!!!!!而这个模块不连接数据库!!!!
 * ////所以必须在使用者那里实现!!!!!!!
 * Created by macro on 2018/6/19.
 */
public interface EsProductDao {
    /**
     * 获取指定ID的搜索商品
     */
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
