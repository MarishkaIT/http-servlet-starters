package validator;

import dto.CreateUserDto;
import entity.Gender;
import entity.Role;
import util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto>{

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid.birthday", "Birthday is valid"));
        }
        if (Gender.find(object.getGender()).isEmpty()){
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        if (Role.find(object.getRole()).isEmpty()){
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        return validationResult;
    }


    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }
}
