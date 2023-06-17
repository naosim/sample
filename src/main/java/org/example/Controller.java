package org.example;
import org.example.datasource.DbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class Controller {
    @Autowired
    private final DbMapper dbMapper;
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map hello() {
        Map<String, Object> res = new HashMap<>();
        res.put("response", "hello");
        return res;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map list() {
        Map<String, Object> res = new HashMap<>();
        res.put("response", dbMapper.select().stream().map(v -> v.event_date_time).collect(Collectors.toList()));
        return res;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public Map insert() {
        dbMapper.insert(LocalDateTime.now());

        // 返却値
        List l = dbMapper.select();
        Map<String, Object> res = new HashMap<>();
        res.put("response", l.get(l.size() - 1));
        return res;

    }
}
