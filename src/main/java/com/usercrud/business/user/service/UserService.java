package com.usercrud.business.user.service;

import com.usercrud.business.user.entity.User;
import com.usercrud.business.user.repository.UserRepository;
import com.usercrud.common.error.code.ErrorCode;
import com.usercrud.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void join(User user){
        userRepository.findByEmail(user.getEmail())
                      .ifPresent(e -> {
                          throw new BusinessException(ErrorCode.EXIST_EMAIL);
                      });

        userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                             .orElseThrow(()-> new BusinessException(ErrorCode.NOT_FOUND_USER));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Transactional
    public void delete(User user){
        userRepository.delete(user);
    }

    @Transactional
    public void updatePassword(User user, String password){
        user.updatePassword(password);
    }
}
