package mvc.web;

import mvc.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Controller
public class MovieController {
    private AtomicInteger id = new AtomicInteger(1);
    private Map<Integer, Movie> movies = getInitData();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView list() {
        // list = /WEB-INF/views/list.jsp because of viewResolver
        return new ModelAndView("list", "movies", movies.values());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("id") int id) {
        return new ModelAndView("detail", "movie", movies.get(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ModelAndView save(@PathVariable("id") int id, @Valid Movie movie, Errors errors) {// Pitfall! Errors must be the argument right after the one annotated with @Valid
        if (errors.hasErrors()) {
            return new ModelAndView("detail", "movie", movie);
        }
        movies.put(id, movie);
        return new ModelAndView(new RedirectView(""));
    }

    private Map<Integer, Movie> getInitData() {
        List<Movie> initData = new ArrayList();
        initData.add(new Movie(id.getAndIncrement(), "The Lord of the Rings: The Return of the King", 2003, 11, 11));
        initData.add(new Movie(id.getAndIncrement(), "Titanic", 1997, 11, 14));
        initData.add(new Movie(id.getAndIncrement(), "Ben-Hur", 1959, 11, 12));
        initData.add(new Movie(id.getAndIncrement(), "West Side Story", 1961, 10, 11));
        initData.add(new Movie(id.getAndIncrement(), "The English Patient", 1996, 9, 12));
        initData.add(new Movie(id.getAndIncrement(), "Gigi", 1958, 9, 9));
        initData.add(new Movie(id.getAndIncrement(), "The Last Emperor", 1987, 9, 9));
        initData.add(new Movie(id.getAndIncrement(), "Slumdog Millionaire", 2008, 8, 10));
        initData.add(new Movie(id.getAndIncrement(), "Amadeus", 1984, 8, 11));

        return initData.stream().collect(Collectors.toMap(Movie::getId, movie -> movie));
    }
}
