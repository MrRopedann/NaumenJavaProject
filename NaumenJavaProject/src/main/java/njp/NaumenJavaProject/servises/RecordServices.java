package njp.NaumenJavaProject.servises;

import njp.NaumenJavaProject.dao.RecordDao;
import njp.NaumenJavaProject.dao.UserDao;
import njp.NaumenJavaProject.models.Record;
import njp.NaumenJavaProject.models.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class RecordServices {

    private RecordDao recordDao = new RecordDao();
    private UserDao userDao =new UserDao();

    public RecordServices() {
    }

    public Record findByLogin(String login) {
        return recordDao.findByLogin(login);
    }

    public Record findById(long id) {
        return recordDao.findById(id);
    }

    public void saveRecord(Record record) {
        recordDao.save(record);
    }

    public void deleteRecord(Record record) {
        recordDao.delete(record);
    }

    public void updateRecord(Record record) {
        recordDao.update(record);
    }
}