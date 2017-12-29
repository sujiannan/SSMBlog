package cn.upc.mapper;

import cn.upc.pojo.ArtiType;
import cn.upc.pojo.ArtiTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArtiTypeMapper {
    int countByExample(ArtiTypeExample example);

    int deleteByExample(ArtiTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArtiType record);

    int insertSelective(ArtiType record);

    List<ArtiType> selectByExample(ArtiTypeExample example);

    ArtiType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArtiType record, @Param("example") ArtiTypeExample example);

    int updateByExample(@Param("record") ArtiType record, @Param("example") ArtiTypeExample example);

    int updateByPrimaryKeySelective(ArtiType record);

    int updateByPrimaryKey(ArtiType record);
    
    int insertReturnId(ArtiType record);
}