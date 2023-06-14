package pro.sky.springExeptions.service;

import org.springframework.stereotype.Service;
import pro.sky.springExeptions.Interface.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    public String registration(String login, String password, String confirmPassword) {
        String allowChars = "a-zA-Z0-9_";

        if (login.length() > 20 || !login.equals(allowChars)) {
            throw new WrongLoginExeption("Логин длиннее 20 символов или содержит недопустимые символы!!!");
        }

        if (password.length() > 20 || !password.equals(allowChars)) {
            throw new WrongPasswordExeptin("Пароль длиннее 20 символов или содержит недопустимые символы!!!");
        }

        if (!confirmPassword.equals(password)) {
            throw new WrongConfirmPasswordExeption("Пароль введен не верно");
        }
    }
}
