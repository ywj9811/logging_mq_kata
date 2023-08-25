package com.mq.producer.domain.user.controller;

import com.mq.producer.domain.user.dto.request.SignInRequest;
import com.mq.producer.domain.user.dto.request.SignUpRequest;
import com.mq.producer.domain.user.entity.User;
import com.mq.producer.domain.user.service.UserAuthService;
import com.mq.producer.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/user/auth")
public class UserAuthController {
    private final UserAuthService userAuthService;

    @PostMapping("sign_up")
    public ResponseEntity<SuccessResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        userAuthService.save(signUpRequest);
        return ResponseEntity.ok(SuccessResponse.create(OK.value(), "success"));
    }

    @PostMapping("sign_in")
    public ResponseEntity<SuccessResponse<User>> signIn(@RequestBody SignInRequest signInRequest) {
        User user = userAuthService.login(signInRequest);
        return ResponseEntity.ok(SuccessResponse.create(OK.value(), "success", user));
    }
}
