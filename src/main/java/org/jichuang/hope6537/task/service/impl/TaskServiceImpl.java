package org.jichuang.hope6537.task.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.task.dao.Member_TaskDao;
import org.jichuang.hope6537.task.model.Member_Task;
import org.jichuang.hope6537.task.model.Task;
import org.jichuang.hope6537.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl extends BaseServiceImpl<Task> implements
        TaskService {
    @Autowired
    @Override
    @Qualifier("taskDao")
    public void setDao(BaseDao<Task> dao) {
        super.setDao(dao);
    }

    @Autowired
    private Member_TaskDao member_taskDao;

    @Override
    public List<Task> selectTaskByMemberId(Member member, boolean isSent) throws MemberException {
        if (member == null) {
            throw new MemberException("没有用户对象");
        } else {
            String hql1 = "from Member_Task where sentMemberId = " + member.getMemberId();
            String hql2 = "from Member_Task where getMemberId = " + member.getMemberId();
            List<Member_Task> list = member_taskDao.selectEntryByHQL(isSent ? hql1 : hql2);
            StringBuffer ids = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                ids.append(" taskId = ");
                ids.append(list.get(i).getTaskId().getTaskId());
                if (i < list.size() - 1) {
                    ids.append(" OR ");
                }
            }
            String hql = "from Task where " + ids.toString();
            return this.selectEntryByHQL(hql);
        }
    }
}
