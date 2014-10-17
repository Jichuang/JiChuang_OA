package org.hope6537.service.impl;

import org.hope6537.dao.BaseDao;
import org.hope6537.model.Message;
import org.hope6537.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements
		MessageService {
	@Autowired
	@Qualifier("messageDao")
	@Override
	public void setDao(BaseDao<Message> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}

}
