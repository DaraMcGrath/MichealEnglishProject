//extend different types of professions
//

import java.util.ArrayList;
import java.util.List;
public abstract class Employee {
    private int id;
    private String name;
    private String email;
    private String role;
    private boolean isFullTime;


    public Employee(int id, String name, String email, String role, boolean isFullTime){
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.isFullTime = isFullTime;
        
    }
}
