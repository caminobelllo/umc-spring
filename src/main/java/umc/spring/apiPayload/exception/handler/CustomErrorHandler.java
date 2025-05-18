package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class CustomErrorHandler extends GeneralException {
    public CustomErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
