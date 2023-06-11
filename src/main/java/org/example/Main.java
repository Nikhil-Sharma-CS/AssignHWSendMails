package org.example;

import java.sql.SQLOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting to send out multiple Mails");

        Handler Send = new Handler();
        Send.sendMail();

        System.out.println("Mails send to following : ");
        System.out.println(MailMeta.receiveMail + " " + MailMeta.newReceiver);

        System.out.println("Mails Sent");
    }
}