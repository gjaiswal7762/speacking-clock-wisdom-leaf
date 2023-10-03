package com.speakingclock.service.Impl;

import com.speakingclock.service.TimeService;
import org.springframework.stereotype.Service;

@Service
public class TimeServiceimpl implements TimeService {
    @Override
    public String convertToWord(int hours, int minutes) {
        if (hours==12 && minutes==0) {
            return "Midday";
        }
        else if ((hours==0 && minutes==0) || (hours==24 && minutes==0)){
            return "Midnight";
        }
        else {
            String result = getHourString(hours) + " " + getMinuteString(minutes % 60);
            return result;

        }
    }

    private String getHourString(int hours) {
        String[] hourWords = {
                "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven","twelve"
        };
        return hourWords[hours % 12];
    }

    private String getMinuteString(int minutes) {
        String[] minuteWords = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three",
                "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight",
                "twenty-nine", "thirty", "thirty-one", "thirty-two", "thirty-three", "thirty-four",
                "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty",
                "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six",
                "forty-seven", "forty-eight", "forty-nine", "fifty", "fifty-one", "fifty-two",
                "fifty-three", "fifty-four", "fifty-five", "fifty-six", "fifty-seven", "fifty-eight",
                "fifty-nine"
        };
        return minuteWords[minutes];
    }
}
