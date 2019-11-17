package phoneNumber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import phoneNumber.model.PhoneNumber;
import phoneNumber.service.PhoneNumberService;

@Controller
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;
    @GetMapping("")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("phoneNumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("/doAddPhone")
    public ModelAndView doAddPhoneNumber(@Validated @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult ){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/index","phoneNumber",phoneNumber);
            return modelAndView;
        }
        phoneNumberService.save(phoneNumber);
        ModelAndView modelAndView = new ModelAndView("/index","msg","Added A PhoneNumber");
        return modelAndView;
    }
}
