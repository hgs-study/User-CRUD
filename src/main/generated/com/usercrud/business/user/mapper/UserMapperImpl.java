package com.usercrud.business.user.mapper;

import com.usercrud.business.user.entity.User;
import com.usercrud.business.user.entity.User.UserBuilder;
import com.usercrud.business.user.form.UserForm.Request.Join;
import com.usercrud.business.user.form.UserForm.Request.Modify;
import com.usercrud.business.user.form.UserForm.Response.Find;
import com.usercrud.business.user.form.UserForm.Response.Find.FindBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-03T22:41:04+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public Find toDto(User arg0) {
        if ( arg0 == null ) {
            return null;
        }

        FindBuilder find = Find.builder();

        find.id( arg0.getId() );
        find.email( arg0.getEmail() );
        find.password( arg0.getPassword() );

        return find.build();
    }

    @Override
    public User toEntity(Find arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.id( arg0.getId() );
        user.email( arg0.getEmail() );
        user.password( arg0.getPassword() );

        return user.build();
    }

    @Override
    public User joinDtoToEntity(Join dto) {
        if ( dto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.email( dto.getEmail() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public User modifyDtoToEntity(Modify dto) {
        if ( dto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        return user.build();
    }
}
