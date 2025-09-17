package org.nttdata.com.servicionotificaciones.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailManagerPersonalizado {
    public static final String HTML =       """
      <!DOCTYPE html>
      <html lang="es">
      <head>
          <meta charset="UTF-8">
          <title>Notificación Bancaria</title>
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <style>
              body { background: #f4f6fb; margin:0; padding:0; font-family: 'Segoe UI', Arial, sans-serif;}
              .container { background: #fff; border-radius: 8px; box-shadow: 0 4px 20px #dce3ef7a; max-width: 520px; margin: 30px auto; padding: 32px 24px;}
              .header { background: #2354a7; border-radius: 8px 8px 0 0; padding: 24px; text-align:center;}
              .header img { width: 80px; margin-bottom: 12px;}
              .header h1 { color: #fff; margin: 0; font-size: 28px; font-weight: 700; letter-spacing: 1px;}
              .greeting { color: #2354a7; font-size: 20px; margin-top: 28px; font-weight: 600;}
              .content { color: #222; font-size: 17px; margin: 18px 0 32px 0; }
              .details { background: #f1f6ff; border-radius: 7px; padding: 18px 18px 10px 18px; margin-bottom: 22px;}
              .details p { margin: 7px 0; color: #2354a7; font-size: 15px;}
              .footer { color: #5d6e82; font-size: 14px; text-align: center; padding-top: 16px;}
              .footer strong { color: #2354a7;}
              @media (max-width: 600px) {
                  .container { padding: 12px 4px; }
                  .header { padding: 16px; }
              }
          </style>
      </head>
      <body>
          <div class="container">
              <div class="header">
                  <!-- Puedes poner el logo de tu banco aquí -->
                  <img src="https://i.imgur.com/BNFQ5jA.png" alt="Banco Logo" />
                  <h1>%s</h1>
              </div>
              <div class="greeting">
                  Hola, %s:
              </div>
              <div class="content">
                  %s
              </div>
              <div class="details">
                  <p><strong>Nombre:</strong> %s</p>
                  <p><strong>DNI:</strong> %s</p>
                  <p><strong>Email:</strong> %s</p>
                  <p><strong>Enviado el:</strong> %s</p>
                  <p><strong>Estado de notificación:</strong> %s</p>
              </div>
              <div class="footer">
                  Si tienes dudas o no reconoces esta notificación, comunícate con nosotros.<br>
                  <strong>Tu Banco Digital</strong>
              </div>
          </div>
      </body>
      </html>
      """;

    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public MailManagerPersonalizado(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendMessage(String email, String subject, String body) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            message.setSubject(subject);
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setText(body, true);
            helper.setFrom(from);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
