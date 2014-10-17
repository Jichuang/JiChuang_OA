package org.hope6537.dao.impl;

import org.hope6537.dao.TaskDao;
import org.hope6537.model.Task;
import org.springframework.stereotype.Repository;

@Repository("taskDao")
public class TaskDaoImpl extends BaseDaoImpl<Task> implements TaskDao {

}
