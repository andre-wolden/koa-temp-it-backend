package koa.controller;


import java.time.LocalDateTime;
import java.util.List;

import koa.models.TempValue;
import koa.repository.TempValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/temp")
@RestController
public class TempValueController {

    @Autowired
    TempValueRepository tempValueRepository;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @CrossOrigin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TempValue> list(){



        return tempValueRepository.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newTempValue(@RequestBody String value) {

        TempValue newTempValue = new TempValue();
        newTempValue.setTemp(Double.parseDouble(value));
        newTempValue.setTimestamp(LocalDateTime.now());
        newTempValue.setUploaded(false);

        tempValueRepository.save(newTempValue);

        System.out.println(value);

        return "Registration of new value succeeded.";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String insertOne() {

        String value = "100";
        TempValue newTempValue = new TempValue();
        newTempValue.setTemp(Long.parseLong(value));
        newTempValue.setTimestamp(LocalDateTime.now());
        newTempValue.setUploaded(false);

        tempValueRepository.save(newTempValue);

        System.out.println(value.toString());

        return "Registration of new value succeeded.";
    }


}
