package com.usercrud.business.user.api;

import com.usercrud.business.user.entity.User;
import com.usercrud.business.user.form.UserForm.*;
import com.usercrud.business.user.mapper.UserMapper;
import com.usercrud.business.user.service.UserService;
import com.usercrud.business.user.validator.UserValidator;
import com.usercrud.common.response.dto.ResponseDto;
import com.usercrud.common.response.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @PostMapping("/users")
    public ResponseEntity<ResponseDto> join(@Valid @RequestBody Request.Join join){
        final User user = mapper.joinDtoToEntity(join);
        userService.join(user);

        return ApiResponse.success(HttpStatus.CREATED, "정상적으로 회원가입 되었습니다.");
    }

    @GetMapping("/users")
    public List<Response.Find> findAccounts(){
        return userService.findAll().stream()
                                    .map((entity) -> mapper.toDto(entity))
                                    .collect(Collectors.toList());
    }

    @GetMapping("/users/{email}")
    public Response.Find findUser(@PathVariable String email){
        userValidator.validate(email);

        return mapper.toDto(userService.findByEmail(email));
    }

    @PatchMapping("/users/{email}")
    public ResponseEntity<ResponseDto> modifyPassword(@PathVariable String email,
                                                      @Valid @RequestBody Request.Modify modify){
        userValidator.validate(email);

        final User user = userService.findByEmail(email);
        userService.updatePassword(user, modify.getPassword());

        return ApiResponse.success(HttpStatus.OK,"패스워드가 정상적으로 변경되었습니다.");
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<ResponseDto> deletePassword(@PathVariable String email){
        userValidator.validate(email);

        final User user = userService.findByEmail(email);
        userService.delete(user);

        return ApiResponse.success(HttpStatus.OK,"패스워드가 정상적으로 삭제되었습니다.");
    }
}
