package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public void setSessionFactory(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

   /*@Override
   public void deleteAllUsers() {
      userDao.deleteAllUsers();
   }*/

    @Transactional(readOnly = true)
    @Override
    public User findUserByMS(String model, int series) {
        return userDao.findUserByMS(model, series);
    }

}
