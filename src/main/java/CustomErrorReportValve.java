import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ErrorReportValve;

import java.io.IOException;
import java.io.Writer;

public class CustomErrorReportValve extends ErrorReportValve {
    @Override
    protected void report(Request request, Response response, Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        sb.append("自定义HTML页面");
        Writer writer = null;
        try {
            writer = response.getReporter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (writer != null) {
            try {
                writer.write(sb.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
