package com.whale.security.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyUserDetailService
 * @Description TODO
 * @Author like
 * @Data 2019/8/22 14:47
 * @Version 1.0
 **/
@Slf4j
@Component
public class MyUserDetailService implements UserDetailsService, SocialUserDetailsService {

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    /**
     * @param username 用户输入的用户名
     * @return User实体实现了UserDetails接口，此处并不一定使用org.springframework.security.core.userdetails.User
     * 可使用数据库中的映射user实体实现UserDetails接口，具体的用户状态校验逻辑可在其中编写
     * @throws UsernameNotFoundException 用户不存在异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 根据用户名去数据库查询用户信息
        log.info("登录用户名{}", username);
        String password = passwordEncoder.encode("123456");
        log.info("加密后密码{}", password);
        // username password 为数据库中查询出来的数据，并非用户输入的数据
        //2. 根据查询到的用户信息，编写自定义逻辑判断用户状态是否冻结等... 同时，将用户状态返回给Security
        return new User(username, password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info("社交登录用户Id:" + userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
        // 根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结
        //模拟注册时将密码加密动作
        String password = "{bcrypt}"+passwordEncoder.encode("123456");
        log.info("加密后密码{}", password);
        return new SocialUser(userId, password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    }
}
