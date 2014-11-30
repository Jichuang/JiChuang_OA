package org.jichuang.hope6537.utils;

import java.io.Serializable;

import org.apache.poi.ss.formula.functions.T;
import org.jichuang.hope6537.blog.model.Blog;
import org.junit.Test;

public class MyBatisTest {

	@Test
	public void testAdd() {
		IBaseGenericDAO<Blog, Integer> dao = new MybatisBaseGenericDAOImpl<Blog, Integer>() {

		};
		Blog ob = new Blog();
		ob.setBlogId(2);
		ob.setContent("dasdas");
		dao.save(ob);

	}
}
