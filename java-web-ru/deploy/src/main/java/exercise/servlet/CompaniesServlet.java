package exercise.servlet;

import jdk.dynalink.SecureLookupSupplier;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        List<String> result = new ArrayList<>(getCompanies());
        String paramSearch = request.getParameter("search");
        if (paramSearch != null && !"".equals(paramSearch)) {
            result = result.stream()
                    .filter(s -> s.contains(paramSearch))
                    .collect(Collectors.toList());
        }
        if (result.size() > 0) {
            result.forEach(out::println);
        } else out.println("Companies not found");
        // END
    }
}
