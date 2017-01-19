package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	public TbItem getItemById(long itemId);
	
	public EUDataGridResult getItemList(int page,int rows);
	
	public void saveItem(TbItem tbItem,String desc, String itemParams) throws Exception;
}
