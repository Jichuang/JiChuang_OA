package org.hope6537.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import org.hope6537.model.Member;
import org.hope6537.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/** 
 * <p>Describe: 异步交互控制器</p>
 * <p>Using: </p>
 * <p>DevelopedTime: 2014年10月15日下午2:01:15</p>
 * <p>Company: ChangChun Unviersity JiChuang Team</p>
 * @author Hope6537
 * @version 1.0
 * @see
 */
@Controller()
@RequestMapping("/memberAjax")
public class AjaxActionController {
	@Autowired
	private MemberService memberService;
	private Logger logger = Logger.getLogger("memberAjax");

	@RequestMapping(value = "{username}/isMemberExist", method = RequestMethod.GET)
	public void isMemberExist(@PathVariable String username,
			PrintWriter printWriter) {
		logger.info(username);
		List<Member> list = memberService
				.selectEntryByHQL("from Member where musername = '" + username
						+ "'");
		if (list.size() <= 0) {
			printWriter.write("null");
			printWriter.flush();
			printWriter.close();
		} else {
			String jsonString = JSON.toJSONString(list.get(0),
					SerializerFeature.PrettyFormat);
			printWriter.write(jsonString);
			printWriter.flush();
			printWriter.close();
		}

	}
	
}
