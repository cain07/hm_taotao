package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tools.internal.ws.processor.model.Request;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;
import com.taotao.service.ItemService;

@RequestMapping("/item/param")
@Controller
public class ItemParamController {
	
	@Autowired
	private ItemParamService itemParamService;

	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult saveItem(@PathVariable Long itemCatId) throws Exception{
		TaotaoResult itemParamByCid = itemParamService.getItemParamByCid(itemCatId);
		return itemParamByCid;
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertParamItem(@PathVariable Long cid, String paramData) throws Exception{
		
		TbItemParam itemParam = new TbItemParam();
		itemParam.setId(cid);
		itemParam.setParamData(paramData);
		
		TaotaoResult result = itemParamService.saveItem(itemParam );
		return result;
	}
	
	
}
