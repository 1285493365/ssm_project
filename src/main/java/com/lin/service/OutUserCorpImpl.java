package com.lin.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.lin.dao.OutCorpDao;
import com.lin.domain.OutCorp;

@Service
public class OutUserCorpImpl implements OutCorpService  {

	@Override
	public void saveOrUpdateOutCorp(OutCorp outCorp) {
		// TODO Auto-generated method stub
		outCorpDao.saveOrUpdateOutCorp(outCorp);
	}

	@Resource
	private OutCorpDao outCorpDao;
	
	public OutCorp selectOutCorpById(Integer id) {
		// TODO Auto-generated method stub
		return outCorpDao.selectOutCorpById(id);
	}

}
