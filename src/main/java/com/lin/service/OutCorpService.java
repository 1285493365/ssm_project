package com.lin.service;
import com.lin.domain.OutCorp;

public interface OutCorpService {
	
	OutCorp selectOutCorpById(Integer id);
	void saveOrUpdateOutCorp(OutCorp outCorp);
}
