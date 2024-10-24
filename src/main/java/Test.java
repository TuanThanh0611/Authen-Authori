import com.Ivo.Auth.dto.request.AuthenticationRequest;
import com.Ivo.Auth.repository.UserRepository;
import com.Ivo.Auth.service.impl.AuthenticationServiceImpl;

public class Test {
    public static void main(String[] args){
        UserRepository userRepository;
        AuthenticationServiceImpl authenticationService = null;
        AuthenticationRequest authenticationRequest=new AuthenticationRequest();
        authenticationRequest.setPassword("123456");
        authenticationRequest.setUsername("test");

    }
}
