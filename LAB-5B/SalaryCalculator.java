public class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        switch (employee.getRole()) {
            case "Manager":
                return 5000;
            case "Developer":
                return 3000;
            case "Intern":
                return 1500;
            default:
                return 2000;
        }
    }
}
