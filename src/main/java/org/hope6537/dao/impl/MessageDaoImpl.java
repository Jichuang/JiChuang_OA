package org.hope6537.dao.impl;

import org.hope6537.dao.MessageDao;
import org.hope6537.model.Message;
import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

}
