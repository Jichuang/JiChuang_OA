package org.hope6537.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

/** 
 *<pre>
 *七.个人文件树对象 —— 数据库表，每条数据都有一个父文件的外键 / 也可能使用XML进行映射 单单只在数据库中记录XML的地址
 *1.文件树对象主键 fid int 10 自增长
 *2.文件树用户外键 fmid int 10 一对一
 *3.文件树xml路径地址 fpath varchar 255 
 *4.文件树状态 fstatus varchar 50
 *</pre>
 * <p>Describe: </p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月13日下午7:39:45</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
public class FileTree implements Serializable {

	enum FileType {
		FILE, FOLDER
	}

	/**
	 * <p>Describe: </p>
	 * <p>Using: </p>
	 */
	private static final long serialVersionUID = 466294696456934278L;

	private Integer fid;

	private Member fmid;

	private String fpath;

	private String fstatus;

	private FileNode fileNode;

	/**
	 * <pre>
	 * 对于Xml的数性结构，不适用Update方法进行更改
	 * 而是将doc对象提取出来之后，进行读取，然后找到修改的点添加或者删除或者重命名
	 * 然后再将新的doc覆写进去
	 * 所以，实际上文件树里显示的东西不是那个啥，额，不是File对象，显示还是一个个的字符串
	 * 主要分为folder标签和file标签
	 * folder标签的属性仅仅为name
	 * 而file标签的属性分为name和path
	 * 最后给到一个树形结构的数据结构交给FileTree对象来持有
	 * 然后前端的Controller来进行FileTreeRoot的提取从而获取到信息。
	 * </pre>
	 * <p>Describe: 核心文件树代码</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月24日下午5:25:40 </p>
	 * <p>Author:Hope6537</p>
	 * @throws Exception 
	 * @see
	 */
	@SuppressWarnings("unused")
	public void init() {
		try {
			SAXReader reader = new SAXReader();
			InputStream in = new FileInputStream(getFpath());
			Document doc = reader.read(in);
			Element root = doc.getRootElement();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * <p>Describe: 创建一个FileTree的XML</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月26日上午11:15:43 </p>
	 * <p>Author:Hope6537</p>
	 * @see
	 */
	public void create() {
		try {
			//
			Document doc = DocumentHelper.createDocument();
			File file = new File(getFpath());
			file.createNewFile();
			Element root = doc.addElement(FileType.FOLDER.toString());
			root.addAttribute("name", "/");
			root.addAttribute("path", "/");
			XMLWriter out = new XMLWriter(new FileWriter(file));
			out.write(doc);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>Describe: 添加新文件</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月26日上午11:38:35 </p>
	 * <p>Author:Hope6537</p>
	 * @param folderPath
	 * @param file
	 * @throws IOException
	 * @throws DocumentException
	 * @see
	 */
	public void insertFile(String folderPath, File file) throws IOException,
			DocumentException {
		if (file == null) {
			return;
		}
		if (!file.exists()) {
			return;
		}
		SAXReader reader = new SAXReader();
		InputStream in = new FileInputStream(getFpath());
		Document doc = reader.read(in);
		String fileName = file.getName();
		String filePath = file.getAbsolutePath();
		Element element = (Element) doc.selectNodes(
				("//FOLDER[@path='" + folderPath + "']")).get(0);
		Element file1 = element.addElement(FileType.FILE.toString());
		file1.addAttribute("filename", fileName);
		file1.addAttribute("filePath", filePath);
		XMLWriter out = new XMLWriter(new FileWriter(getFpath()));
		out.write(doc);
		out.flush();
		out.close();
	}

	/**
	 * <p>Describe: 添加新的文件夹</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月26日上午11:38:45 </p>
	 * <p>Author:Hope6537</p>
	 * @param folderPath
	 * @param folderName
	 * @throws Throwable
	 * @see
	 */
	public void insertFolder(String folderPath, String folderName)
			throws Throwable {
		SAXReader reader = new SAXReader();
		InputStream in = new FileInputStream(getFpath());
		Document doc = reader.read(in);
		Element element = (Element) doc.selectNodes(
				("//FOLDER[@path='" + folderPath + "']")).get(0);
		Element folder = element.addElement(FileType.FOLDER.toString());
		String newPath = folderPath.equals("/") ? folderPath + folderName
				: folderPath + "/" + folderName;
		folder.addAttribute("path", newPath);
		folder.addAttribute("name", folderName);
		XMLWriter out = new XMLWriter(new FileWriter(getFpath()));
		out.write(doc);
		out.flush();
		out.close();
	}

	/**
	 * <p>Describe: 得到符合条件的文件或者文件夹节点</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月26日上午11:52:13 </p>
	 * <p>Author:Hope6537</p>
	 * @param fileType
	 * @param param
	 * @return
	 * @throws Throwable
	 * @see
	 */
	@SuppressWarnings("unchecked")
	protected List<Element> getFileNodes(FileType fileType, String param)
			throws Throwable {

		SAXReader reader = new SAXReader();
		InputStream in = new FileInputStream(getFpath());
		Document doc = reader.read(in);
		List<Element> list;
		if (fileType.toString().equals(FileType.FOLDER.toString())) {
			list = doc.selectNodes(("//FOLDER[@path='" + param + "']"));
		} else {
			list = doc.selectNodes(("//FILE[@filePath='" + param + "']"));
		}
		return list;
	}

	/**
	 * <p>Describe: 更新已有文件的信息</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月26日上午11:52:00 </p>
	 * <p>Author:Hope6537</p>
	 * @param oldFilePath 这个是在文件系统中的路径
	 * @param file
	 * @param isAbsolutePath 确认是否使用全路径 yes 
	 * 	或者使用相对路径 false
	 * @throws DocumentException
	 * @throws IOException
	 * @see
	 */
	public void updateFile(String oldFilePath, File file, boolean isAbsolutePath)
			throws DocumentException, IOException {
		if (file == null) {
			System.err.println("File is Null");
			return;
		}
		if (!file.exists()) {
			System.err.println("File is not exist");
			return;
		}
		SAXReader reader = new SAXReader();
		InputStream in = new FileInputStream(getFpath());
		Document doc = reader.read(in);
		String fileName = file.getName();
		String filePath = file.getAbsolutePath();
		Element element;
		if (isAbsolutePath) {
			element = (Element) doc.selectNodes(
					("//FILE[@filePath='" + oldFilePath + "']")).get(0);
		} else {
			String[] strs = oldFilePath.split("/");
			StringBuffer oldfolder = new StringBuffer();
			StringBuffer oldfilePath = new StringBuffer();
			for (int i = 0; i < strs.length; i++) {
				if (i == strs.length - 1) {
					oldfolder.append(strs[i]);
					break;
				}
				oldfilePath.append(strs[i]);
			}

			element = (Element) doc.selectNodes(
					("//FOLDER[@path='" + oldfolder.toString() + "']")).get(0);
			element.selectNodes(
					"//FILE[@path='" + oldfilePath.toString() + "']").get(0);
		}
		element.addAttribute("filename", fileName);
		element.addAttribute("filePath", filePath);
		XMLWriter out = new XMLWriter(new FileWriter(getFpath()));
		out.write(doc);
		out.flush();
		out.close();
	}

	/**
	 * <p>Describe: 得到文件节点</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月26日上午11:52:50 </p>
	 * <p>Author:Hope6537</p>
	 * @param filePath
	 * @return
	 * @throws Throwable
	 * @see
	 */
	public Element getFileNode(String filePath) throws Throwable {
		return this.getFileNodes(FileType.FILE, filePath).get(0);
	}

	/**
	 * <p>Describe: 得到文件夹节点</p>
	 * <p>Using: </p>
	 * <p>How To Work: </p>
	 * <p>DevelopedTime: 2014年10月26日上午11:53:02 </p>
	 * <p>Author:Hope6537</p>
	 * @param filePath
	 * @return
	 * @throws Throwable
	 * @see
	 */
	public Element getFolderNode(String filePath) throws Throwable {
		return this.getFileNodes(FileType.FOLDER, filePath).get(0);
	}

	public void setFileNode(FileNode fileNode) {
		this.fileNode = fileNode;
		init();
	}

	class FileNode {
		private File file;
		private FileType type;
		private File fileParent;

		public FileNode(File file) {
			this.file = file;
		}

		public File getFile() {
			return file;
		}

		public FileType getType() {
			return type;
		}

		public File getFileParent() {
			return fileParent;
		}

		public void setFile(File file) {
			this.file = file;
		}

		public void setType(FileType type) {
			this.type = type;
		}

		public void setFileParent(File fileParent) {
			this.fileParent = fileParent;
		}
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Member getFmid() {
		return fmid;
	}

	public void setFmid(Member fmid) {
		this.fmid = fmid;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public String getFstatus() {
		return fstatus;
	}

	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}

}
