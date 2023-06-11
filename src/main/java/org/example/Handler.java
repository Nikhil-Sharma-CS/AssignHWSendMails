package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Handler {
    void sendMail() {
        Properties SysProp = System.getProperties();    //This gives me a hash-map/hash-table

        //System.out.println(SysProp);

        SysProp.put("mail.smtp.host", MailMeta.Hostserver);
        SysProp.put("mail.smtp.port", MailMeta.Port);
        SysProp.put(MailMeta.SSLProperty, "true");
        SysProp.put(MailMeta.AuthPerm, "true");

        //Create a session using sender-email and password
        Authenticator mailAuthenticator = new CustomAuth();

        Session mailSession = Session.getInstance(SysProp, mailAuthenticator);

        //MIME message build
        MimeMessage mailMessage = new MimeMessage(mailSession);
        try {
            mailMessage.setFrom(MailMeta.myUserMail);

            mailMessage.setSubject("This is my java code testing");

            mailMessage.setText("This is the assignment code for sending mails to multiple recipients, Thanks for receiving!");

            Address receiverEmail = new InternetAddress(MailMeta.receiveMail);
            mailMessage.setRecipient(Message.RecipientType.TO, receiverEmail);

            Address NewReceiver = new InternetAddress(MailMeta.newReceiver);
            mailMessage.addRecipient(Message.RecipientType.CC, NewReceiver);

            Transport.send(mailMessage);
        } catch (Exception mailEx) {
            System.out.println(mailEx.toString());
        }
    }
}
