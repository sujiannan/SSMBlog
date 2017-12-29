package cn.upc.service;

import java.util.List;

import cn.upc.pojo.MsgNote;

public interface MsgService {

	public List<MsgNote> findAll();

	public void delMsg(Integer id);

	public void insertMsgInfo(MsgNote msg);
	
}
