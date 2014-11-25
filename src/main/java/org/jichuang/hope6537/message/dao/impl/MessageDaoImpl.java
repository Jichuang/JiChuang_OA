package org.jichuang.hope6537.message.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.message.dao.MessageDao;
import org.jichuang.hope6537.message.model.Message;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

}
