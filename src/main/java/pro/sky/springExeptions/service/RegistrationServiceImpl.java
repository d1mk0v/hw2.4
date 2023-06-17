package pro.sky.springExeptions.service;

import org.springframework.stereotype.Service;
import pro.sky.springExeptions.Interface.RegistrationService;
import pro.sky.springExeptions.exceptions.WrongConfirmPasswordException;
import pro.sky.springExeptions.exceptions.WrongLoginException;
import pro.sky.springExeptions.exceptions.WrongPasswordException;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    public String registration(String login, String password, String confirmPassword) {
        String allowChars = "a-zA-Z0-9_";

        if (login.length() > 20 || !login.equals(allowChars)) {
            throw new WrongLoginException("Логин длиннее 20 символов или содержит недопустимые символы!!!");
        }

        if (password.length() > 20 || !password.equals(allowChars)) {
            throw new WrongPasswordException("Пароль длиннее 20 символов или содержит недопустимые символы!!!");
        }

        if (!confirmPassword.equals(password)) {
            throw new WrongConfirmPasswordException("Пароль не подтвержден!!!");
        }
        return allowChars;
    }
}
