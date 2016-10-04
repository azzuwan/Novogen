import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {

        get("/hello", (req, res) -> "Hello World");

        
        get("/departments", (req,res) -> "Generated Route departments");        
        
        get("/dept_emp", (req,res) -> "Generated Route dept_emp");        
        
        get("/dept_manager", (req,res) -> "Generated Route dept_manager");        
        
        get("/employees", (req,res) -> "Generated Route employees");        
        
        get("/salaries", (req,res) -> "Generated Route salaries");        
        
        get("/titles", (req,res) -> "Generated Route titles");        
        
        get("/current_dept_emp", (req,res) -> "Generated Route current_dept_emp");        
        
        get("/dept_emp_latest_date", (req,res) -> "Generated Route dept_emp_latest_date");        
        

        
    }
}

