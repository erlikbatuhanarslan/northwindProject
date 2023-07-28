package kodlama.io.northwindProject.Business.Concretes;


import kodlama.io.northwindProject.Business.Abstracts.UserService;
import kodlama.io.northwindProject.Core.DataAccess.UserDao;
import kodlama.io.northwindProject.Core.Entities.User;
import kodlama.io.northwindProject.Core.Utilities.Results.DataResult;
import kodlama.io.northwindProject.Core.Utilities.Results.Result;
import kodlama.io.northwindProject.Core.Utilities.Results.SuccesDataResult;
import kodlama.io.northwindProject.Core.Utilities.Results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccesDataResult<User>(this.userDao.findByEmail(email)
                ,"Kullanıcı bulundu");
    }

}
