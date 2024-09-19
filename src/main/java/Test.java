import com.Ivo.Gym.service.dto.reponse.AuthenticationResponse;
import com.Ivo.Gym.service.dto.request.AuthenticationRequest;
import com.Ivo.Gym.service.entity.User;
import com.Ivo.Gym.service.repository.UserRepository;
import com.Ivo.Gym.service.service.impl.AuthenticationServiceImpl;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Test {
    public static void main(String[] args){
        UserRepository userRepository;
        AuthenticationServiceImpl authenticationService = null;
        AuthenticationRequest authenticationRequest=new AuthenticationRequest();
        authenticationRequest.setPassword("123456");
        authenticationRequest.setUserName("test");

    }
}
