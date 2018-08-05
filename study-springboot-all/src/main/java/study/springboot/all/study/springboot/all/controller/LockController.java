package study.springboot.all.study.springboot.all.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.springboot.all.study.springboot.all.cachelock.LockService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping(value = "/v1/lock")
public class LockController {
    @Autowired
    private LockService lockService;

    /**
     * @param key
     */
    @RequestMapping(value = "/lock", method = RequestMethod.POST)
    public String lock(@RequestParam("key") String key) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            executorService.execute(
                    () -> lockService.lock(key)
            );
        }
    }
}
