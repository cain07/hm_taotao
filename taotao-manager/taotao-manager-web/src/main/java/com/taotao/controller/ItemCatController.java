package com.taotao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EUTreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {

		List<TbItemCat> itemCatList = itemCatService.getItemCatList(parentId);

		List<EUTreeNode> euTreeNodes = new ArrayList<>();

		for (TbItemCat cat : itemCatList) {
			EUTreeNode eNode = new EUTreeNode();
			eNode.setId(cat.getId());
			eNode.setText(cat.getName());
			eNode.setState(cat.getIsParent() ? "closed" : "open");
			euTreeNodes.add(eNode);
		}
		return euTreeNodes;
	}
	
	

	
}
