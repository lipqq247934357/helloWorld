/**
 * Twotiger.com Llc.
 * Copyright (c) 2013-2016 All Rights Reserved.
 */
/**
 * @Description: 这是一个关于公司活动书写优化的一个方案 
 * 
       1.如何截取除了html头部之外的内容
       2.图片url优化
       3.拷贝图片优化
    
    思路：将原生的html页面转换成需要的页面
          将所有图片按照需求放到指定目录下面
          自动生成需要的js,html
          
    主要思路：1.将web图片放到web目录（java），
              2.将touch图片放到touch目录（java），
              3.对web原来的html页面进行优化：主要是去掉头部尾部，将图片url改为系统需要的url（java，正则）
              4.对touch原来的html页面进行优化：主要是去掉头部尾部，将图片url改为系统需要的url（java，正则）
              5.在指定目录生成web页面，将上面的web内容插入进去
              6.在指定目录生成touch页面，将上面的touch内容插入进去
              7.在actController中写一个标准的模板，然后用的时候直接复制就行了
              8.在需要增加service时再增加service内容。
 * 
 * @Author Lipeng
 * @Date 2016年7月18日 下午6:53:29 
 */
package ActOptimize;