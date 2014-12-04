package org.jichuang.hope6537.base.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.jichuang.hope6537.base.exception.MemberException;
import org.jichuang.hope6537.base.model.Member;

import javax.servlet.http.HttpServletRequest;

public interface MemberService extends BaseService<Member> {

    /**
     * <p>Describe: 成员注册</p>
     * <p>DevelopedTime: 2014年11月26日下午5:01:54 </p>
     * <p>Author:Hope6537</p>
     *
     * @param member
     * @param infos
     * @return 1为成功 反之为0并抛出异常
     * @throws MemberException
     */
    int insertRegisterService(Member member, JSONObject infos)
            throws MemberException;

    /**
     * <p>Describe: 成员登录</p>
     * <p>DevelopedTime: 2014年11月26日下午5:07:19 </p>
     * <p>Author:Hope6537</p>
     *
     * @param member
     * @return 对则有对象 否则null
     * @throws MemberException
     * @see
     */
    Member selectLoginService(Member member) throws MemberException;

    int updateMember(Member member) throws MemberException;

    int updatePassword(Member member) throws MemberException;

}
