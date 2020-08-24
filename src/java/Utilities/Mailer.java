package Utilities;

import Entity.Actuacionessolicitudes;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {

    public static void recordarContrasena(String para, String contrasena) {
        final String user = "herramientasdecobranzas@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "jfpuertoeu";

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            message.addRecipients(Message.RecipientType.TO, para);
            message.setSubject("Recordatorio contraseña");

            message.setContent(
                    "A continuación encontrará su clave de ingreso a Herramientas de Cobranzas,"
                    + ""
                    + "<h4> Clave Usuario : "
                    + contrasena
                    + " </h4>"
                    + ""
                    + "Por favor no responder este mensaje.",
                    "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearUsuario(String para, String nombreUsuario, String contrasena) {
        final String user = "herramientasdecobranzas@gmail.com";//cambiará en consecuencia al servidor utilizado
        final String pass = "jfpuertoeu";

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com"); // envia 
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.starttls.required", "false");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            message.addRecipients(Message.RecipientType.TO, para);
            message.setSubject("Bienvenido a Herramientas de cobranzas");

            message.setContent(
                    "A partir de ahora usted cuenta con un usuario y contraseña para ingresar a Herramientas de Cobranzas. "
                    + ""
                    + "<h4> Nombre de usuario : "
                    + nombreUsuario
                    + " </h4>" + "<h4> Clave de ingreso : "
                    + contrasena
                    + " </h4>"
                    + ""
                    + "Por favor no responder este mensaje.",
                    "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    

}
