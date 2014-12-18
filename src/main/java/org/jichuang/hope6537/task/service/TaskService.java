package org.jichuang.hope6537.task.service;

import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.BaseService;
import org.jichuang.hope6537.task.model.Task;

import java.util.List;

public interface TaskService extends BaseService<Task> {

    List<Task> selectTaskByMemberId(Member member, boolean isSent) throws MemberException;

}
