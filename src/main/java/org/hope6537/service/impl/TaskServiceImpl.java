package org.hope6537.service.impl;

import org.hope6537.dao.BaseDao;
import org.hope6537.model.Task;
import org.hope6537.service.TaskService;
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
		// TODO Auto-generated method stub
		super.setDao(dao);
	}

}
