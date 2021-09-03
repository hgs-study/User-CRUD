package com.usercrud.business.user.mapper;

import com.usercrud.business.user.entity.User;
import com.usercrud.business.user.form.UserForm.*;
import com.usercrud.common.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper extends GenericMapper<Response.Find, User> {
    User joinDtoToEntity(Request.Join dto);

    User modifyDtoToEntity(Request.Modify dto);
}
