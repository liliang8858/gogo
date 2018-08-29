package yz.gogo.web;

import yz.gogo.core.Config;

import java.time.LocalTime;

/**
 * 主页构建器
 *
 * @author zenuo
 * 2018-07-08 20:50:25
 */
public class IndexPageBuilder {
    /**
     * 反相样式之前的HTML字符串
     */
    private static final String HTML_BEFORE_INVERT_STYLE = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"utf-8\"/><title>Gogo</title><style>";

    /**
     * 反相样式之后的HTML字符串
     */
    private static final String HTML_AFTER_INVERT_STYLE = "</style></head><body><div class=\"main\"><h1>Gogo</h1><form action=\"/search\" method=\"GET\" onsubmit=\"return q.value!=''\"><input name=\"q\" autocomplete=\"off\" autofocus=\"autofocus\" type=\"text\"> <button value=\"Search\" type=\"submit\">Go</button></form></div><footer>(ゝ∀･)~试试<a href=\"https://176.122.157.73:5001\">5001端口</a>，原版谷歌搜索镜像</footer></body></html>";

    /**
     * 夜间模式的样式表
     */
    private static final String HTML_NIGHT_MODE_STYLE = "body{text-align:center;background-color:#000;color:#fff}h1{font-size:50px;font-family:\"Times New Roman\",Times,serif}footer{font-size:15px;font-family:Roboto,arial,sans-serif}.main{margin:0 auto;width:50%;padding-bottom:50px}";

    /**
     * 日间模式的样式表
     */
    private static final String HTML_DAY_MODE_STYLE = "body{text-align:center}h1{font-size:50px;font-family:\"Times New Roman\",Times,serif}footer{font-size:15px;font-family:Roboto,arial,sans-serif}.main{margin:0 auto;width:50%;padding-bottom:50px}";

    /**
     * 构建主页
     *
     * @return 主页的字符串
     */
    public static String build() {
        final StringBuilder sb = new StringBuilder(HTML_BEFORE_INVERT_STYLE);
        final LocalTime now = LocalTime.now();
        //若不是日间模式
        if (now.isBefore(Config.INSTANCE.getDayModeStartTime()) ||
                now.isAfter(Config.INSTANCE.getDayModeEndTime())) {
            sb.append(HTML_NIGHT_MODE_STYLE);
        } else {
            sb.append(HTML_DAY_MODE_STYLE);
        }
        sb.append(HTML_AFTER_INVERT_STYLE);
        return sb.toString();
    }
}