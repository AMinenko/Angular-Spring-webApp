package web.controllers;

import entity.Mail;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping(produces = MediaType.ALL_VALUE)
public class MailController {
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "getAllMails")
    @ResponseStatus(HttpStatus.OK)
    public void getAll(HttpServletResponse response) throws IOException {
        String path = "data/mails.json";
     //   File file = new ClassPathResource(path).getFile();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());


        OutputStream outputStream = response.getOutputStream();
        try (FileInputStream fis = new FileInputStream(file)) {
            FileCopyUtils.copy(fis, outputStream);
            outputStream.flush();
            outputStream.close();
        }
    }


    @RequestMapping(method = RequestMethod.POST, value="postMail", consumes = MediaType.ALL_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void postMail(@RequestBody Mail mail){
        System.out.println(mail.getSubject());
        System.out.println(mail.getSentAt());
    }


}


