package com.lin.dao;
import com.lin.domain.OutCorp;
public interface OutCorpDao {
	public OutCorp selectOutCorpById(Integer id);
	public void saveOrUpdateOutCorp(OutCorp outCorp);
}
