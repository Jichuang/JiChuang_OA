package org.jichuang.hope6537.notification.service;

import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.notification.model.Notification;

import java.util.List;

public interface NotificationService extends BaseService<Notification> {

    List<Notification> selectNotificationByMemberId(Member member) throws MemberException;

}
