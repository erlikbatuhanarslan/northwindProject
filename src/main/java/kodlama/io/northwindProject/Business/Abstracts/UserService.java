package kodlama.io.northwindProject.Business.Abstracts;

import kodlama.io.northwindProject.Core.Entities.User;
import kodlama.io.northwindProject.Core.Utilities.Results.DataResult;
import kodlama.io.northwindProject.Core.Utilities.Results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
