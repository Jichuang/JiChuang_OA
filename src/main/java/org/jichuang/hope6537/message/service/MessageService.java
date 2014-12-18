package org.jichuang.hope6537.message.service;

import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.message.model.Message;

import java.util.List;

public interface MessageService extends BaseService<Message> {

    public List<Message> selectMessageByMemberId(Member member, boolean isSent) throws MemberException;

}
