package com.speakingclock.controller;

import com.speakingclock.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    private TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getStringTime(@RequestParam("time") String time){
        try{
        String[] timeInput = time.split(":");
        if(timeInput.length != 2){
            return new ResponseEntity<>("Please input valid time format, right time format (HH:MM)", HttpStatus.BAD_REQUEST);
        }
        int hours = Integer.parseInt(timeInput[0]);
        int minutes = Integer.parseInt(timeInput[1]);
        if ((hours < 0 || hours > 23 || minutes < 0 || minutes > 59) && !(hours == 24 && minutes == 0)) {
            throw new IllegalArgumentException("Invalid time format, " +
                    "Please input the right format (HH:MM) -> Range HH -> [00 - 24] and Range MM -> [00 - 59]");
        }

        String wordTime= timeService.convertToWord(hours,minutes);
        String result = "It's " + wordTime;
        return ResponseEntity.ok(result);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body("Invalid time format"+" "+e);
    }
    }

}
