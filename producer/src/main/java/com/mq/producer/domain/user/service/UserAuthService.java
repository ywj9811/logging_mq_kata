package com.mq.producer.domain.user.service;

import com.mq.producer.domain.user.dto.request.SignInRequest;
import com.mq.producer.domain.user.dto.request.SignUpRequest;
import com.mq.producer.domain.user.entity.User;
import com.mq.producer.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserAuthService {
    private final UserRepository userRepository;

    public void save(SignUpRequest signUpRequest) {
        userRepository.save(signUpRequest.toEntity());
    }

    public User login(SignInRequest signInRequest) {
        User user = userRepository.findByUserIdAndPassword(signInRequest.getUserId(), signInRequest.getPassword())
                .orElseThrow(() -> new ClassCastException("일치하는 사용자가 없습니다."));
        return user;
    }
}
