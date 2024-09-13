package com.colak.springtutorial.layout;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * See <a href="https://medium.com/@facuramallo8/understanding-logback-66044df087ed">...</a>
 * In the context of modern apps, layouts are no longer used because the approach to append logs to files has changed toward
 * logging aggregation systems in containerized apps into clusters or cloud environments where logs are delivered as byte array streams.
 */
public class MaskingPatternLayout extends PatternLayout {

    private Pattern multilinePattern;
    private final List<String> maskPatterns = new ArrayList<>();

    public void addMaskPattern(String maskPattern) {
        maskPatterns.add(maskPattern);
        multilinePattern = Pattern.compile(String.join("|", maskPatterns), Pattern.MULTILINE);
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        String originalMessage = super.doLayout(event);
        return maskSensitiveData(originalMessage);
    }

    private String maskSensitiveData(String message) {
        if (multilinePattern == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(message);
        Matcher matcher = multilinePattern.matcher(sb);
        while (matcher.find()) {
            IntStream.rangeClosed(1, matcher.groupCount()).forEach(group -> {
                if (matcher.group(group) != null) {
                    int start = matcher.start(group);
                    int end = matcher.end(group);

                    String mask = "*".repeat(5);
                    sb.replace(start, end, mask);
                }
            });
        }
        return sb.toString();
    }
}
