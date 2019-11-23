package njp.NaumenJavaProject.servises;


import njp.NaumenJavaProject.dao.UserDao;
import njp.NaumenJavaProject.models.Users;

public class UsersServices {

    private UserDao usersDao = new UserDao();

    public UsersServices() {
    }

    public Users findUserLogin(String login) {
        return usersDao.findByLogin(login);
    }

    public Users findUser(int id) {
        return usersDao.findById(id);
    }
    public Users findUserEmail(String email){
        return usersDao.findByEmail(email);
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