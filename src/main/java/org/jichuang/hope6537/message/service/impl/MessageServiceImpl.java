package org.jichuang.hope6537.message.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.message.model.Message;
import org.jichuang.hope6537.message.service.MessageService;
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
        super.setDao(dao);
    }

}
