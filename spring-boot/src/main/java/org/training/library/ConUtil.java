package org.training.library;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class ConUtil {

    public boolean contains(String stringParam,
                            String sParam) {
        return stringParam.contains(sParam);
    }

}
