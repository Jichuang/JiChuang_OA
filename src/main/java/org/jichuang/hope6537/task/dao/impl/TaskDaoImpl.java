package org.jichuang.hope6537.task.dao.impl;

import org.jichuang.hope6537.base.dao.impl.BaseDaoImpl;
import org.jichuang.hope6537.task.dao.TaskDao;
import org.jichuang.hope6537.task.model.Task;
import org.springframework.stereotype.Repository;

@Repository("taskDao")
public class TaskDaoImpl extends BaseDaoImpl<Task> implements TaskDao {

}
