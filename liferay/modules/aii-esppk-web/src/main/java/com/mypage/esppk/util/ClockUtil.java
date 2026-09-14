package com.mypage.esppk.util;

import java.time.Clock;
import java.time.ZoneId;

public class ClockUtil {
    private ClockUtil() {}

    private static final ZoneId ZONE_ID = ZoneId.of("Asia/Jakarta");

    public static Clock getSystemClock() {
        return Clock.systemUTC();
    }

    public static Clock getZoneClock() {
        return Clock.system(ZONE_ID);
    }
}
