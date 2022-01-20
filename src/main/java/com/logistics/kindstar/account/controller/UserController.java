package com.logistics.kindstar.account.controller;

import cn.hutool.crypto.KeyUtil;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.AlgorithmUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.logistics.kindstar.account.entity.bo.UserBo;
import com.logistics.kindstar.account.entity.data.UserAccountData;
import com.logistics.kindstar.account.entity.query.QueryUserBo;
import com.logistics.kindstar.account.entity.vo.RespondVo;
import com.logistics.kindstar.account.entity.vo.UserVo;
import com.logistics.kindstar.account.service.UserService;
import com.logistics.kindstar.common.constant.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
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


    private static final String ID = "RS256";

    private static final KeyPair keyPair;

    static {
        keyPair = KeyUtil.generateKeyPair(AlgorithmUtil.getAlgorithm(ID));
    }

    /**
     * 登录
     *
     * @param userBo 用户博
     * @return {@link RespondVo}<{@link String}>
     */
    @PostMapping(value = "/login")
    public RespondVo<String> login(@Validated @RequestBody UserBo userBo) {
        RespondVo<String> result = new RespondVo<>();
        HashMap<String, Object> map = new HashMap<>(5);
        map.put("userCode", userBo.getUserCode());
        map.put("passwd", userBo.getUserLoginPassword());
        JWTSigner signer = JWTSignerUtil.createSigner(ID, keyPair);
        String token = JWTUtil.createToken(map, signer);
        result.setCode(StatusCode.SUCCESS.getCode());
        result.setMessage(StatusCode.SUCCESS.getDesc());
        result.setData(token);
        System.out.println(signer);
        return result;
    }
}
