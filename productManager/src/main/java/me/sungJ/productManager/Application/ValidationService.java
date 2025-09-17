package me.sungJ.productManager.Application;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidationService {
    public <T> void checkvalid(@Valid T validationTarget) {
        //do nothing
    }
}
