package com.yumeng.webapp.repository;

import com.yumeng.webapp.dao.UserDao;
import com.yumeng.webapp.data.User;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class UserRepository  {
    private Jdbi jdbi;

    public UserRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public User createUser(User user){
        return jdbi.withExtension(UserDao.class, dao -> dao.createUser(user));
    }

    public User getUsers(Long id){
        return jdbi.withExtension(UserDao.class, dao -> dao.getUser(id));
    }

    public User updateUsers(Long id, User userNew){
        User userOld = getUsers(id);
        if(userNew.getFirstName() == null){
            userNew.setFirstName(userOld.getFirstName());
        }
        if(userNew.getLastName() == null){
            userNew.setLastName(userOld.getLastName());
        }
        if(userNew.getPassword() == null){
            userNew.setPassword(userOld.getPassword());
        }
        return jdbi.withExtension(UserDao.class, dao -> dao.updateUser(id, userNew));
    }


}
