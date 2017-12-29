package cn.upc.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.upc.mapper.ArtiTypeMapper;
import cn.upc.pojo.ArtiType;
import cn.upc.pojo.ArtiTypeExample;
import cn.upc.pojo.ArtiTypeExample.Criteria;
import cn.upc.service.ArticleTypeService;
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService{

	@Autowired
	private ArtiTypeMapper artiTypeMapper; 
	
	public List<ArtiType> findAll() {
		ArtiTypeExample example = new ArtiTypeExample();
		Criteria criteria = example.createCriteria();
		List<ArtiType> list = artiTypeMapper.selectByExample(example );
		return list; 
	} 
	/**
	 * insert 
	 */
	public Integer insertArtiType(String otherType) {
		ArtiType a = new ArtiType();
		a.setTypeName(otherType);
		int insert = artiTypeMapper.insert(a);
		return insert;
	}
	
	public Integer insertReturnId(String otherType) {
		ArtiType a = new ArtiType();
		a.setTypeName(otherType);
		int insert = artiTypeMapper.insertReturnId(a);
		return insert;
	}
	
	public int findIdByTypeName(String otherType) {
		ArtiTypeExample example = new ArtiTypeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTypeNameEqualTo(otherType);
		List<ArtiType> resList = artiTypeMapper.selectByExample(example );
		if(!resList.isEmpty() && resList.size() > 0) {
			return resList.get(0).getId();
		}
		return 0;
	}
	public void delArtiType(Integer id) {
		artiTypeMapper.deleteByPrimaryKey(id);
	}
	public void updateArtiType(ArtiType arti) {
		artiTypeMapper.updateByPrimaryKey(arti);
	}

	
}
