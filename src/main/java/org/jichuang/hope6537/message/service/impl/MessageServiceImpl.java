package org.jichuang.hope6537.message.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.message.dao.Member_MessageDao;
import org.jichuang.hope6537.message.model.Member_Message;
import org.jichuang.hope6537.message.model.Message;
import org.jichuang.hope6537.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements
        MessageService {
    @Autowired
    @Qualifier("messageDao")
    @Override
    public void setDao(BaseDao<Message> dao) {
        super.setDao(dao);
    }

    @Autowired
    private Member_MessageDao member_messageDao;


    @Override
    public List<Message> selectMessageByMemberId(Member member) {
        List<Member_Message> list = member_messageDao.selectEntryByHQL("from Member_Message where memberId = " + member.getMemberId());
        StringBuffer ids = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            ids.append(" messageId = ");
            ids.append(list.get(i).getMessageId().getMessageId());
            if (i < list.size() - 1) {
                ids.append(" OR ");
            }
        }
        String hql = "from Message where " + ids.toString();
        return this.selectEntryByHQL(hql);
    }
}
