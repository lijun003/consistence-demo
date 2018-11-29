package com.blocks.consistency.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.blocks.consistency.entity.Order;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO t_order(`inventory_id`, `count`, `status`) VALUES (#{inventoryId}, #{count}, #{status})")
    int insert(Order order);

    @Update("UPDATE t_order SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") int id, @Param("status") int status);
}
