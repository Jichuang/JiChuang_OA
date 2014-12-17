package org.jichuang.hope6537.task.service.impl;

import org.jichuang.hope6537.base.dao.BaseDao;
import org.jichuang.hope6537.base.service.impl.BaseServiceImpl;
import org.jichuang.hope6537.task.model.Task;
import org.jichuang.hope6537.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("taskService")
public class TaskServiceImpl extends BaseServiceImpl<Task> implements
        TaskService {
    @Autowired
    @Override
    @Qualifier("taskDao")
    public void setDao(BaseDao<Task> dao) {
        super.setDao(dao);
    }

}
