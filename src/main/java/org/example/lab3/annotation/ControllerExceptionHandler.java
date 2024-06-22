package org.example.lab3.annotation;
import java.lang.annotation.*;

/**
 * У данного контроллера есть централизованный обработчик исключений ApiExceptionHandler
 */
@Target({ElementType.TYPE, ElementType.MODULE})
@Documented
public @interface ControllerExceptionHandler {
}
