package dms.pastor.tools.job.salarycalc;

public class SalaryApp {
    private Vacancy vacancy;

    private SalaryApp() {
        // set role details
        vacancy = Vacancy.builder()
                .salary(60000)
                .hours(35)
                .annualLeaveDays(24)
                .timeTravel(53)
                .hatedStation(true)
                .inZone1(true)
                .optionToBuyExtraDays(10)
                .wfh(true)
                .build();
    }

    public static void main(String[] args) {
        final SalaryApp app = new SalaryApp();
        app.generateReport();
    }

    private void generateReport() {
        System.out.println(String.format("For this role I expect to earn: %d pounds.", new Calculator(vacancy).calculateSalary()));
        System.out.println(getResultForRole());
    }

    private String getResultForRole() {
        final int salary = new Calculator(vacancy).calculateSalary();
        if (salary == vacancy.getSalary()) {
            return "Perfect match!";
        }
        if (vacancy.getSalary() > salary) {
            return String.format("Salary from vacancy is higher by %d british queens.", vacancy.getSalary() - salary);
        }
        if (salary - (salary / 13) > vacancy.getSalary()) {
            return "Salary too low. Reject it!";
        }
        return "Salary is lower than my expectation but still worth to consider if tech stack and company are great.";
    }

}
