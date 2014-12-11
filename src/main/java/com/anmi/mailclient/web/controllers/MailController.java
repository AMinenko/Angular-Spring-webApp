package com.anmi.mailclient.web.controllers;

import com.anmi.mailclient.core.entity.Mail;
import com.anmi.mailclient.core.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(produces = MediaType.ALL_VALUE)
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(method = RequestMethod.GET, value = "getAllMails")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Mail> getAll(HttpServletResponse response) throws IOException {
        return mailService.getAll();
    }


    @RequestMapping(method = RequestMethod.POST, value="postMail", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void postMail(@RequestBody Mail mail){
        System.out.println(mail.getSubject());
        System.out.println(mail.getSentAt());
    }


}


