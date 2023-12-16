package ru.sultanyarov.common.exception;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sultanyarov.common.dto.Error;
import ru.sultanyarov.common.errorhandler.BusinessError;

import static org.springframework.util.StringUtils.hasText;

public abstract class CommonExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public final ResponseEntity<Error> handleBusinessException(BusinessException ex) {
        BusinessError businessError = AnnotatedElementUtils.findMergedAnnotation(ex.getClass(), BusinessError.class);
        Assert.notNull(businessError, "Can't find BusinessError annotation");

        return getResponseFromBusinessError(businessError, ex);
    }

    private ResponseEntity<Error> getResponseFromBusinessError(BusinessError businessError, BusinessException ex) {
        if (hasText(businessError.errorCode())) {
            Error err = new Error(
                    businessError.errorCode(),
                    !hasText(businessError.debug()) ? null : businessError.debug(),
                    !hasText(businessError.message()) ? ex.getLocalizedMessage() : businessError.message()
            );

            return new ResponseEntity<>(err, businessError.status());
        }
        return new ResponseEntity<>(businessError.status());
    }
}
