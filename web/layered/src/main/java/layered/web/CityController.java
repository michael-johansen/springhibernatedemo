package layered.web;

import layered.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class CityController {
    private final AppService appService;

    @Autowired
    public CityController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list(@PageableDefault(size = 50, sort = "name") Pageable pageable){
        return new ModelAndView("list", "cities", appService.getCities(pageable));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") Long id){
        return new ModelAndView("detail", "city", appService.getCityById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView save(@PathVariable("id") Long id, @Valid CityData cityData, Errors errors){
        if(errors.hasErrors()){
            return new ModelAndView("detail", "city", cityData);
        }
        appService.updateCity(id, cityData);
        return new ModelAndView(new RedirectView(""));
    }
}
