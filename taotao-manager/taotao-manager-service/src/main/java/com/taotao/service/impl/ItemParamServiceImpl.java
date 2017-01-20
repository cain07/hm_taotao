package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService{

	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		// TODO Auto-generated method stub
		
		TbItemParamExample example = new TbItemParamExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(cid);
		
		List<TbItemParam> selectByExample = tbItemParamMapper.selectByExampleWithBLOBs(example);
		
		if (selectByExample != null && selectByExample.size() >0) {
			return TaotaoResult.ok(selectByExample.get(0));
		}
		
		return TaotaoResult.ok();
	}
	
	@Override
	public TaotaoResult saveItem(TbItemParam itemParam) {
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		
		// TODO Auto-generated method stub
		tbItemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

}
