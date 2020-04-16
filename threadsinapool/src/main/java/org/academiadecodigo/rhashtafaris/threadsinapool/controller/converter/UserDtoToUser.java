package org.academiadecodigo.rhashtafaris.threadsinapool.controller.converter;

import org.academiadecodigo.rhashtafaris.threadsinapool.controller.dto.UserDto;
import org.academiadecodigo.rhashtafaris.threadsinapool.model.impl.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser extends AbstractConverter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
