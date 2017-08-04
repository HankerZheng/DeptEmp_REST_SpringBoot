package net.antra.hanz.controller;

import net.antra.hanz.exception.ErrorTestException;
import net.antra.hanz.exception.OtherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by hanzheng on 7/27/17.
 */

@RestController
public class MainController {

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/main")
    public String getMainPage() {
        return "Hello" + "<br/>" + messageSource.getMessage("greetings", null, Locale.CHINESE);
    }

    @RequestMapping("/main/{user}")
    public String getMainPage(@PathVariable String user) {
        return "Hello, " + user + "<br/>" + messageSource.getMessage("greetings", null, Locale.CHINESE);
    }

    @RequestMapping(path="/main/errortest", method=RequestMethod.GET)
    public String getErrorTestMessage() throws ErrorTestException{
        throw new ErrorTestException("This is an ErrorTestException thrown from the main controller!");
    }

    @RequestMapping(path="/main/otherexception", method= RequestMethod.GET)
    public String showErrorMsg(@RequestParam Integer num) throws OtherException{
        if (num == 12)  throw new OtherException("Goodbye!");
        return "right!";
//        throw new ErrorTestException("this is a error message example!");
    }
}
