package pro.sky.homeworks.homework214.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import pro.sky.homeworks.homework214.services.StringList;

@RestController
public class StringListController {
    private final StringList stringList;


    public StringListController(StringList string) {
        this.stringList = string;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("item") String item) throws HttpClientErrorException.BadRequest {
        return stringList.add(item);
    }

    @GetMapping(path = "/add-index")
    public String add(@RequestParam("item") String item, @RequestParam("index") int index) throws HttpClientErrorException.BadRequest {
        return stringList.add(index, item);
    }

    @GetMapping(path = "/set")
    public String set(@RequestParam("item") String item, @RequestParam("index") int index) throws HttpClientErrorException.BadRequest {
        return stringList.set(index, item);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("item") String item) throws HttpClientErrorException.BadRequest {
        return stringList.remove(item);
    }

    @GetMapping(path = "/remove-index")
    public String remove(@RequestParam("index") int index) throws HttpClientErrorException.BadRequest {
        return stringList.remove(index);
    }

    @GetMapping(path = "/contains")
    public boolean contains(@RequestParam("item") String item) throws HttpClientErrorException.BadRequest {
        return stringList.contains(item);
    }

    @GetMapping(path = "/indexOf")
    public int indexOf(@RequestParam("item") String item) throws HttpClientErrorException.BadRequest {
        return stringList.indexOf(item);
    }

    @GetMapping(path = "/lastIndexOf")
    public int lastIndexOf(@RequestParam("item") String item) throws HttpClientErrorException.BadRequest {
        return stringList.lastIndexOf(item);
    }

    @GetMapping(path = "/get")
    public String lastIndexOf(@RequestParam("index") int index) throws HttpClientErrorException.BadRequest {
        return stringList.get(index);
    }

    @GetMapping(path = "/size")
    public int size() {
        return stringList.size();
    }

    @GetMapping(path = "/isEmpty")
    public boolean isEmpty() {
        return stringList.isEmpty();
    }

    @GetMapping(path = "/clear")
    public void clear() {
    }
}
