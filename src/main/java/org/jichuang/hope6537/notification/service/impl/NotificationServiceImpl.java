package org.jichuang.hope6537.notification.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.notification.dao.Member_NotificationDao;
import org.jichuang.hope6537.notification.model.Member_Notification;
import org.jichuang.hope6537.notification.model.Notification;
import org.jichuang.hope6537.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhaopeng-Rabook on 14-12-20.
 */
@Service("notificationService")
public class NotificationServiceImpl extends BaseServiceImpl<Notification> implements NotificationService {

    @Autowired
    @Qualifier(value = "notificationDao")
    @Override
    public void setDao(BaseDao<Notification> dao) {
        super.setDao(dao);
    }

    @Autowired
    private Member_NotificationDao member_notificationDao;


    @Override
    public List<Notification> selectNotificationByMemberId(Member member) throws MemberException {
        if (member == null) {
            throw new MemberException("没有用户对象");
        } else {

            String hql1 = "from Member_Notification where memberId = " + member.getMemberId();
            List<Member_Notification> list = member_notificationDao.selectEntryByHQL(hql1);
            StringBuffer ids = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                ids.append(" notificationId = ");
                ids.append(list.get(i).getNotificationId().getNotificationId());
                if (i < list.size() - 1) {
                    ids.append(" OR ");
                }
            }
            String hql = "from Notification where " + ids.toString();
            return this.selectEntryByHQL(hql);
        }
    }
}
