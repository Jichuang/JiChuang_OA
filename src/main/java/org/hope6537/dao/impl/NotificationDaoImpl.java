package org.hope6537.dao.impl;

import org.hope6537.dao.NotificationDao;
import org.hope6537.model.Notification;
import org.springframework.stereotype.Repository;

@Repository("notificationDao")
public class NotificationDaoImpl extends BaseDaoImpl<Notification> implements
		NotificationDao {

}
