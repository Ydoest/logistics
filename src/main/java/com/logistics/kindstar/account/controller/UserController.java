package com.logistics.kindstar.account.controller;

import com.logistics.kindstar.account.entity.bo.UserBo;
import com.logistics.kindstar.account.entity.data.UserAccountData;
import com.logistics.kindstar.account.entity.query.QueryUserBo;
import com.logistics.kindstar.account.entity.vo.RespondVo;
import com.logistics.kindstar.account.entity.vo.UserVo;
import com.logistics.kindstar.account.service.UserService;
import com.logistics.kindstar.common.constant.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户修改接口
 *
 * @author KG06884
 * @date 2021-12-27
 */
@Slf4j
@RestController
@RequestMapping(value = "/manage/user")
public class UserController {

    private static final ArrayList<String> OPERATOR = new ArrayList<>();

    static {
        OPERATOR.add("create");
        OPERATOR.add("update");
        OPERATOR.add("delete");
    }

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户账户编辑
     *
     * @param operator 用户账号操作：增、删、改
     * @param userBo   用户账号实体
     * @return {@link RespondVo}
     */
    @PostMapping(value = "/{operator}")
    public RespondVo<UserVo> userEdit(@PathVariable String operator, @Validated @RequestBody UserBo userBo) {
        RespondVo<UserVo> respondVo = new RespondVo<>();
        // step.1 校验路径参数
        if (!OPERATOR.contains(operator)) {
            respondVo.setCode(StatusCode.FAIL.getCode());
            respondVo.setMessage(StatusCode.FAIL.getDesc());
            return respondVo;
        }
        respondVo = userService.manageUser(operator, userBo);
        return respondVo;
    }

    /**
     * 用户查询
     * 账号信息查询
     *
     * @param queryUserBo 查询用户实体
     * @return {@link RespondVo}<{@link List}<{@link UserAccountData}>>
     */
    @PostMapping(value = "/query")
    public RespondVo<List<UserAccountData>> userQuery(@Validated @RequestBody QueryUserBo queryUserBo) {
        return userService.queryUser(queryUserBo);
    }
}
