package com.fg.archive.tool.master.service.helper;

import com.fg.archive.tool.common.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class ArchiveToolSourceHelper {

  public String generateStartDateToMidNight(String startDate){

      Calendar calendar = DateUtil.getCalendar(startDate,DateUtil.YYYY_MM_DD_SEPERATED_SLASH);
      Calendar toMidNight = DateUtil.toMidNight(calendar);
      String formatedToMidNight = DateUtil.getDate(DateUtil.YYYY_MM_DD_HHMMSS_SEPERATED_SLASH, toMidNight);
      return formatedToMidNight;

  }

  public String generateEndDateToMidNight(String endDate){

        Calendar calendar = DateUtil.getCalendar(endDate,DateUtil.YYYY_MM_DD_SEPERATED_SLASH);
        Calendar nextDate = DateUtil.addDays(calendar,1);
        Calendar toMidNight = DateUtil.toMidNight(nextDate);
        String formatedToMidNight = DateUtil.getDate(DateUtil.YYYY_MM_DD_HHMMSS_SEPERATED_SLASH, toMidNight);
        return formatedToMidNight;

    }
}
