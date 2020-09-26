package jcg.petagram.activity;

import androidx.appcompat.app.AppCompatActivity;
import jcg.petagram.R;
import jcg.petagram.pojo.Utils;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormularioActivity extends AppCompatActivity {

    String[] argumento;
    TextInputEditText tietNombre;
    TextInputEditText tietEmail;
    TextInputEditText tietComentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        tietNombre        = findViewById(R.id.tietNombre);
        tietEmail         = findViewById(R.id.tietEmail);
        tietComentario    = findViewById(R.id.tietComentario);

    }

    public void enviarComentario(View view) {

        String nombre = tietNombre.getText().toString();
        String email = tietEmail.getText().toString();
        String comentario = tietComentario.getText().toString();

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(Utils.EMAIL));
            msg.setRecipients(Message.RecipientType.TO, email);
            msg.setSubject(nombre);
            msg.setSentDate(new Date());
            msg.setText(comentario);
            Transport.send(msg);
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }
}