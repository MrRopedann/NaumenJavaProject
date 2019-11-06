package njp.NaumenJavaProject;

import njp.NaumenJavaProject.models.Users;
import njp.NaumenJavaProject.servises.UsersServices;

public class Main {
    public static void main(String[] args) {
        UsersServices usersServices = new UsersServices();
        Users users = new Users("Masha","26"); // для примера как записать в базу параметры
        usersServices.saveUser(users);
        usersServices.updateUser(users); //не понял зачем  нужен
    }
}
