package njp.NaumenJavaProject.servises;


import njp.NaumenJavaProject.dao.UserDao;
import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Users;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public class UsersServices {

    private UserDao usersDao = new UserDao();

    public UsersServices() {
    }

    public Users findUserLogin(String login) {
        return usersDao.findById(usersDao.findIDByLogin(login));
    }



    public Users findUser(long id) {
        return usersDao.findById(id);
    }

    public List<Record> findAll(String login, boolean basket){

        return usersDao.findAll(login,basket);
    }

    public void saveUser(Users users) {
        usersDao.save(users);
    }

    public void deleteUser(Users users) {
        usersDao.delete(users);
    }

    public void updateUser(Users users) {
        usersDao.update(users);
    }

}