import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {

        get("/hello", (req, res) -> "Hello World");

        
        get("/departments", (req,res) -> "GET route for departments"); 
        
        post("/departments", (req,res) -> "POST route for departments");
        
        put("/departments/:id", (req,res) -> "PUT route for departments");
        
        delete("/departments/:id", (req,res) -> "DELETE route for departments");
        
        options("/departments", (req,res) -> "OPTIONS route for departments");
        
        get("/dept_emp", (req,res) -> "GET route for dept_emp"); 
        
        post("/dept_emp", (req,res) -> "POST route for dept_emp");
        
        put("/dept_emp/:id", (req,res) -> "PUT route for dept_emp");
        
        delete("/dept_emp/:id", (req,res) -> "DELETE route for dept_emp");
        
        options("/dept_emp", (req,res) -> "OPTIONS route for dept_emp");
        
        get("/dept_manager", (req,res) -> "GET route for dept_manager"); 
        
        post("/dept_manager", (req,res) -> "POST route for dept_manager");
        
        put("/dept_manager/:id", (req,res) -> "PUT route for dept_manager");
        
        delete("/dept_manager/:id", (req,res) -> "DELETE route for dept_manager");
        
        options("/dept_manager", (req,res) -> "OPTIONS route for dept_manager");
        
        get("/employees", (req,res) -> "GET route for employees"); 
        
        post("/employees", (req,res) -> "POST route for employees");
        
        put("/employees/:id", (req,res) -> "PUT route for employees");
        
        delete("/employees/:id", (req,res) -> "DELETE route for employees");
        
        options("/employees", (req,res) -> "OPTIONS route for employees");
        
        get("/salaries", (req,res) -> "GET route for salaries"); 
        
        post("/salaries", (req,res) -> "POST route for salaries");
        
        put("/salaries/:id", (req,res) -> "PUT route for salaries");
        
        delete("/salaries/:id", (req,res) -> "DELETE route for salaries");
        
        options("/salaries", (req,res) -> "OPTIONS route for salaries");
        
        get("/titles", (req,res) -> "GET route for titles"); 
        
        post("/titles", (req,res) -> "POST route for titles");
        
        put("/titles/:id", (req,res) -> "PUT route for titles");
        
        delete("/titles/:id", (req,res) -> "DELETE route for titles");
        
        options("/titles", (req,res) -> "OPTIONS route for titles");
        
        get("/current_dept_emp", (req,res) -> "GET route for current_dept_emp"); 
        
        post("/current_dept_emp", (req,res) -> "POST route for current_dept_emp");
        
        put("/current_dept_emp/:id", (req,res) -> "PUT route for current_dept_emp");
        
        delete("/current_dept_emp/:id", (req,res) -> "DELETE route for current_dept_emp");
        
        options("/current_dept_emp", (req,res) -> "OPTIONS route for current_dept_emp");
        
        get("/dept_emp_latest_date", (req,res) -> "GET route for dept_emp_latest_date"); 
        
        post("/dept_emp_latest_date", (req,res) -> "POST route for dept_emp_latest_date");
        
        put("/dept_emp_latest_date/:id", (req,res) -> "PUT route for dept_emp_latest_date");
        
        delete("/dept_emp_latest_date/:id", (req,res) -> "DELETE route for dept_emp_latest_date");
        
        options("/dept_emp_latest_date", (req,res) -> "OPTIONS route for dept_emp_latest_date");
        

        
    }
}

