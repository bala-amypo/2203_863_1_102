import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
}
