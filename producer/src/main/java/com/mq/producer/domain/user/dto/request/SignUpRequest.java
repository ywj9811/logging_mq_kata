package com.mq.producer.domain.user.dto.request;

import com.mq.producer.domain.user.constant.Role;
import com.mq.producer.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SignUpRequest {
    private String userId;
    private String password;
    private String name;

    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .userId(userId)
                .role(Role.USER)
                .build();
    }
}