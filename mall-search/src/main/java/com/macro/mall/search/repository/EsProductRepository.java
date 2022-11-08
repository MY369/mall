package com.macro.mall.search.repository;

import com.macro.mall.search.domain.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索商品ES操作类
 * //////////////////////////////就是继承ElasticsearchRepository,他就是SpringData的仓库类,封装了一些常用的数据操作方法
 * /////////////////////////////与之相对的还有ElasticsearchRestTemplate, 他能实现各种ES的底层方法
 * Created by macro on 2018/6/19.
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
    /**
     * 搜索查询:
     * 一个简单查询: -------根据关键字搜索名称或者副标题
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords,Pageable page);

}
