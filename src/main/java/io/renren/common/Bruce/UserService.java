package io.renren.common.Bruce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @LogAnnotation(Value = "Bruce")
    @Override
    public void add() {

        userRepository.save();

        System.out.println("UserService add");
    }
}
