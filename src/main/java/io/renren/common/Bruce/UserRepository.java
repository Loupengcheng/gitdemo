package io.renren.common.Bruce;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
    @Override
    public void save() {
        System.out.println("UserRepository save");
    }
}
