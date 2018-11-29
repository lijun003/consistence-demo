package com.blocks.consistency.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.blocks.consistency.entity.Message;

@Mapper
public interface MessageMapper {

    @Insert("INSERT INTO t_message(`serial_number`, `body`, `status`) VALUES (#{serialNumber}, #{body}, #{status})")
    int insert(Message message);

    @Update("UPDATE t_message SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") int id, @Param("status") int status);

    @Select("SELECT * FROM t_message WHERE status = #{status}")
    List<Message> findByStatus(@Param("status")int status);
}
