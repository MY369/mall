package com.macro.mall.search.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 搜索商品的品牌名称，分类名称及属性
 * //////////////////搜索商品的一些相关信息: 品牌名, 分类名 ,属性(内部类,又包括了属性id,属性名,属性值等)
 * Created by macro on 2018/6/27.
 */
@Data
@EqualsAndHashCode
public class EsProductRelatedInfo {
    private List<String> brandNames;
    private List<String> productCategoryNames;
    private List<ProductAttr> productAttrs;

    @Data
    @EqualsAndHashCode
    public static class ProductAttr {
        private Long attrId;
        private String attrName;
        private List<String> attrValues;
    }
}
