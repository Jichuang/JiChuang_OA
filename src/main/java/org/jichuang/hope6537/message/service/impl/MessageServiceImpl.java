package org.jichuang.hope6537.message.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
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
    private Member_MessageDao member_messageDao;

    @Autowired
    @Qualifier("messageDao")
    @Override
    public void setDao(BaseDao<Message> dao) {
        super.setDao(dao);
    }

    @Override
    public List<Message> selectMessageByMemberId(Member member, boolean isSent) throws MemberException {
        if (member == null) {
            throw new MemberException("没有用户对象");
        } else {
            String hql1 = "from Member_Message where sentMemberId = " + member.getMemberId();
            String hql2 = "from Member_Message where getMemberId = " + member.getMemberId();
            List<Member_Message> list = member_messageDao.selectEntryByHQL(isSent ? hql1 : hql2);
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
}
