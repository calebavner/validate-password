package app.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validatePass(String pass) {

        List<String> errors = new ArrayList<>();
        validateLength(pass, errors);
        validateUppercase(pass, errors);
        validateLowercase(pass, errors);
        validateNumber(pass, errors);
        validateSpecialChar(pass, errors);

        return errors;
    }

    private void validateLength(String pass, List<String> errors) {

        if(pass.length() != 0 && pass.length() < 8)
            errors.add("A senha deve possuir pelo menos 8 caracteres.");
    }

    private void validateUppercase(String pass, List<String> errors) {

        if(!Pattern.matches(".*[A-Z].*", pass))
            errors.add("A senha precisa conter ao menos uma letra maiuscula");
    }

    private void validateLowercase(String pass, List<String> errors) {

        if(!Pattern.matches(".*[a-z].*", pass))
            errors.add("A senha precisa conter ao menos uma letra minuscula");
    }

    private void validateNumber(String pass, List<String> errors) {

        if(!Pattern.matches(".*[0-9].*", pass))
            errors.add("A senha precisa conter ao menos um caracter numerico");
    }

    private void validateSpecialChar(String pass, List<String> errors) {

        if(!Pattern.matches(".*[\\W].*", pass))
            errors.add("A senha precisa conter ao menos um caracter especial (e.g. !@#$%).");
    }
}
