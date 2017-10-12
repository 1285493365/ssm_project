package com.lin.service;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lin.dao.OutUserDao;
import com.lin.domain.OutUser;

@Service
public class OutUserServiceImpl implements OutUserService {
	@Resource
	private OutUserDao outUserDao;
		
	@Override
	public void saveOrUpdateOutUser(OutUser outUser) {
		outUserDao.saveOrUpdateOutUser(outUser);
	}
	
}
