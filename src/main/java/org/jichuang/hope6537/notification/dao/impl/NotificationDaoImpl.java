package org.jichuang.hope6537.notification.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.notification.dao.NotificationDao;
import org.jichuang.hope6537.notification.model.Notification;
import org.springframework.stereotype.Repository;

@Repository("notificationDao")
public class NotificationDaoImpl extends BaseDaoImpl<Notification> implements
		NotificationDao {

}
