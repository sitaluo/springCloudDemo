package com.sitaluo.client.hystrix;


import org.springframework.stereotype.Component;

import com.sitaluo.client.AuthServiceClient;
import com.sitaluo.entity.JWT;

/**
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
