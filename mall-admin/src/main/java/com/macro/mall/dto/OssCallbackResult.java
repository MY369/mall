package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * oss上传文件后的回调函数结果
 * --------这是服务器返回给OSS的, OSS会转达给用户
 *
 *
 * 	 //整个OSS的逻辑是:
 * 	               ----用户      先请求服务器要相关参数, 然后直接找OSS上传, 然后接收OSS转达的结果
 * 	               ----服务器     给用户提供上传策略, 回调函数所需的参数,  给OSS提供回调函数
 * 	               ----OSS服务    读取上传策略-->上传-->调用回调函数-->转达结果给用户
 *
 * 	               1. 服务器操作: 用户向服务器请求上传策略和回调函数参数, 服务器告诉他上传策略和回调函数参数.
 * 	               				OSS上传完成后也会调用服务器的回调函数, 并接受回调函数的响应.
 * 	               2. OSS操作:  用户直接向OSS请求上传文件(拥有上传策略和回调函数参数), 并接收到OSS转达的服务器的响应
 * 	               				在这期间,OSS根据上传策略完成上传, 并根据回调函数参数去调用服务器的回调函数,获取服务器的响应
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackResult {
    @ApiModelProperty("文件名称")
    private String filename;
    @ApiModelProperty("文件大小")
    private String size;
    @ApiModelProperty("文件的mimeType")
    private String mimeType;
    @ApiModelProperty("图片文件的宽")
    private String width;
    @ApiModelProperty("图片文件的高")
    private String height;
}
