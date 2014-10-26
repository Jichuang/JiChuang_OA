package org.hope6537.dao.test;

import java.io.File;

import org.hope6537.model.FileTree;
import org.junit.Test;

public class FileTreeTest {

	@Test
	public void createTest() throws Throwable {
		FileTree ft = new FileTree();
		ft.setFpath("G:\\ft.xml");
		ft.create();
	}

	@Test
	public void updateFile() throws Throwable {
		FileTree ft = new FileTree();
		ft.setFpath("G:\\ft.xml");
		/* ft.insertFile("/usr/hope6537", new File("G://User123000.xml")); */
		ft.updateFile("G:\\2.xml", new File("G:\\3.xml"), true);
	}

	@Test
	public void updateFolder() throws Throwable {
		FileTree ft = new FileTree();
		ft.setFpath("G:\\ft.xml");
		ft.insertFolder("/usr", "hope6537");
	}
}
