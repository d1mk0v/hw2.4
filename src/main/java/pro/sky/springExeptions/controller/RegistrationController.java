package pro.sky.springExeptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.springExeptions.Interface.RegistrationService;
import pro.sky.springExeptions.exceptions.WrongConfirmPasswordException;
import pro.sky.springExeptions.exceptions.WrongLoginException;
import pro.sky.springExeptions.exceptions.WrongPasswordException;

@RestController
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = "/registration")
    public String registration(@RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword) {
        try {
            return registrationService.registration(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return "Логин длиннее 20 символов или содержит недопустимые символы!!!";
        } catch (WrongPasswordException e) {
            return "Пароль длиннее 20 символов или содержит недопустимые символы!!!";
        } catch (WrongConfirmPasswordException e) {
            return "Пароль не подтвержден!!!";
        } finally {
            System.out.println("Работа метода registrationService завершена");
        }
    }
}
