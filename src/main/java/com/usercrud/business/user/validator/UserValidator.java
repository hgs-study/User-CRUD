package com.usercrud.business.user.validator;

import com.usercrud.common.error.code.ErrorCode;
import com.usercrud.common.error.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;


@Component
public class UserValidator {
    private final Pattern E_MAIL = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");

    public void validate(String email){
        if(isInvalidEmail(email))
            new BusinessException(ErrorCode.INVALID_EMAIL_FORMAT);
    }

    private boolean isInvalidEmail(String email) {
        return !E_MAIL.matcher(email).matches();
    }
}
