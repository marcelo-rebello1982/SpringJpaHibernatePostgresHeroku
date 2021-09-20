package com.heroku.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
    /*
     * O Spring instanciará um objeto que pegará os valores informados na chaves
     * "spring.mail..." nos arquivos application-dev.properties (e prod)
     */
    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Envio de email...");
        mailSender.send(msg);
        LOG.info("Email enviado");
    }

}
