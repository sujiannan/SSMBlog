package cn.upc.service;

import java.util.List;

import cn.upc.pojo.ArtiType;

public interface ArticleTypeService {

	public List<ArtiType> findAll();

	public Integer insertArtiType(String otherType);

	public Integer insertReturnId(String otherType);

	public int findIdByTypeName(String otherType);

	public void delArtiType(Integer id);

	public void updateArtiType(ArtiType arti);

}
