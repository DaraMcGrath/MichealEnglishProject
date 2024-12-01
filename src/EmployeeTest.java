
import org.junit.jupiter.api.Test;
import models.FullTimeEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {
    @Test
    public void testCalculateNetSalary() {
        FullTimeEmployee emp = new FullTimeEmployee("E001", "Alice", 5000, 100, 50);
        assertEquals(3850, emp.calculateNetSalary());
    }
}
