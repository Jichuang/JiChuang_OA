package org.hope6537.dao.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hope6537.model.Member;
import org.hope6537.model.Message;
import org.hope6537.model.Task;
import org.hope6537.model.Team;
import org.hope6537.service.MemberService;
import org.hope6537.service.MessageService;
import org.hope6537.service.TaskService;
import org.hope6537.service.TeamService;
import org.hope6537.utils.SpringHelper;
import org.junit.Test;

public class ServiceTest extends SpringHelper {

	public ServiceTest() {
		super(true);
	}

	@Test
	public void testDaoFindMembersInBox() {

	}

	@Test
	public void memberServiceInsertTest() {
		MemberService memberService = (MemberService) context
				.getBean("memberService");
		Member member = new Member();
		member.setMdate("2014-10-19 20:08:44");
		member.setMimage("1.png");
		Map<String, String> taskinfo = new HashMap<String, String>();
		taskinfo.put("重要程度", "非常重要");
		taskinfo.put("难易程度", "非常难");
		member.setMinfo("个人简历");
		member.setMname("赵鹏");
		member.setMpassword("4236537");
		member.setMqa(taskinfo.toString());
		member.setMstatus("正常");
		member.setMusername("hope6537@qq.com");
		member.Encrypt();
		memberService.insertEntry(member);
	}

	@Test
	public void memberServiceGetTest() {
		MemberService memberService = (MemberService) context
				.getBean("memberService");
		List<Member> list = memberService.selectEntryAll();
		for (Member member : list) {
			member.Decrypt();
			System.out.println(member.toString());
		}
	}

	@Test
	public void teamServiceTest() {
		Team team = new Team("测试队伍", "测试图片", "测试描述", "{'测试问题':'测试回答',}",
				"2014-10-14 13:40:01", "测试团队信息", null);
		TeamService teamService = (TeamService) context.getBean("teamService");
		teamService.insertEntry(team);

	}

	@Test
	public void taskServiceTest() {
		Map<String, String> taskinfo = new HashMap<String, String>();
		taskinfo.put("重要程度", "非常重要");
		taskinfo.put("难易程度", "非常难");
		Task task = new Task(null, "测试任务标题", "2014-10-14 16:36:30",
				"2014-10-30 16:36:35", "2014-10-24 16:36:43", "已完成",
				taskinfo.toString());
		TaskService taskService = (TaskService) context.getBean("taskService");
		taskService.insertEntry(task);

	}

	@Test
	public void messageServiceTest() {
		Map<String, String> info = new HashMap<String, String>();
		info.put("messageq", "messagea");
		Message message = new Message(null, "测试消息标题", "测试消息内容",
				"2014-10-14 17:56:37", "消息状态正常", info.toString());
		MessageService messageService = (MessageService) context
				.getBean("messageService");
		messageService.insertEntry(message);

	}
}
