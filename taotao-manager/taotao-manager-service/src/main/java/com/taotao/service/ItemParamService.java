package com.taotao.service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemParam;

public interface ItemParamService {

	public TaotaoResult getItemParamByCid(long cid);
	
	public TaotaoResult saveItem(TbItemParam itemParam);
}
