package cn.zzdz.error;

import org.springframework.context.MessageSource;

public class MessageSourceHolder {
    private static MessageSource messageSource;

    public static MessageSource getMessageSource() {
        System.out.println(messageSource);
        return messageSource;
    }

    public static void setMessageSource(final MessageSource messageSource) {
        MessageSourceHolder.messageSource = messageSource;
    }
}
