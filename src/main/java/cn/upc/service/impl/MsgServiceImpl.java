package cn.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.upc.mapper.MsgNoteMapper;
import cn.upc.pojo.MsgNote;
import cn.upc.service.MsgService;
@Service
public class MsgServiceImpl implements MsgService {

	@Autowired
	private MsgNoteMapper msgNoteMapper;
	public List<MsgNote> findAll() {
		return msgNoteMapper.findAllDESC();
	}
	public void delMsg(Integer id) {
		msgNoteMapper.deleteByPrimaryKey(id);
	}
	public void insertMsgInfo(MsgNote msg) {
		msgNoteMapper.insert(msg);
	}

}
