package com.sitaluo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitaluo.client.AuthServiceClient;
import com.sitaluo.dao.UserDao;
import com.sitaluo.dto.UserLoginDTO;
import com.sitaluo.entity.JWT;
import com.sitaluo.entity.User;
import com.sitaluo.exception.UserLoginException;
import com.sitaluo.util.BPwdEncoderUtil;

@Service
public class UserServiceDetail {

    @Autowired
    private UserDao userRepository;

    public User insertUser(String username,String  password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }
    
    @Autowired
    private AuthServiceClient client;

    public UserLoginDTO login(String username, String password){
        User user=userRepository.findByUsername(username);
        if (null == user) {
            throw new UserLoginException("error username");
        }
        if(!BPwdEncoderUtil.matches(password,user.getPassword())){
            throw new UserLoginException("error password");
        }
        // 获取token
        JWT jwt=client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==","password",username,password);
        // 获得用户菜单
        if(jwt==null){
            throw new UserLoginException("error internal");
        }
        UserLoginDTO userLoginDTO=new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;

    }

}