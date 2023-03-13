package com.itheima.mapper;
import com.itheima.pojo.Brand;

import java.util.List;

public interface BrandMapper {

   /**
    * 查询所有
    * @return
    */
   List<Brand> selectAll();

   Brand selectById(int id);
}
