package cn.upc.mapper;

import cn.upc.pojo.MsgNote;
import cn.upc.pojo.MsgNoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgNoteMapper {
    int countByExample(MsgNoteExample example);

    int deleteByExample(MsgNoteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MsgNote record);

    int insertSelective(MsgNote record);

    List<MsgNote> selectByExampleWithBLOBs(MsgNoteExample example);

    List<MsgNote> selectByExample(MsgNoteExample example);

    MsgNote selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MsgNote record, @Param("example") MsgNoteExample example);

    int updateByExampleWithBLOBs(@Param("record") MsgNote record, @Param("example") MsgNoteExample example);

    int updateByExample(@Param("record") MsgNote record, @Param("example") MsgNoteExample example);

    int updateByPrimaryKeySelective(MsgNote record);

    int updateByPrimaryKeyWithBLOBs(MsgNote record);

    int updateByPrimaryKey(MsgNote record);

	List<MsgNote> findAllDESC();
}