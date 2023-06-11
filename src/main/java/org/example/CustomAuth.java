package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomAuth extends Authenticator {

    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(MailMeta.myUserMail, MailMeta.Pass);
    }
}
