package web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
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
}
