package dms.pastor.tasks.calculators;

import java.math.BigDecimal;

/**
 * Author Dominik Symonowicz
 * Created 17/03/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
final class TaxCalculator {

    public static final int DEFAULT_PERSONAL_ALLOWANCE_AMOUNT = 10600;
    public static final int FULL_PERSONAL_ALLOWANCE_LIMIT = 100000;
    private static final int DEFAULT_BASIC_TAX_LIMIT = 31785;
    private static final int BASIC_TAX_RATE = 20;
    private static final int HIGH_TAX_RATE = 40;
    private static final int TOP_TAX_RATE = 45;
    private static final int HIGH_TAX_LIMIT = 150000;
    private static final int TOO_HIGH_SALARY_FOR_PERSONAL_ALLOWANCE = 121200;

    private TaxCalculator() {
    }

    public static int getNetSalary(int salary) {
        final BigDecimal personalAllowance = getPersonalAllowanceFor(salary);
        BigDecimal taxableSalary = new BigDecimal(salary);

        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }

        if (salary <= personalAllowance.intValue()) {
            return salary;
        }

        BigDecimal tax = calculateTax(salary, personalAllowance);

        return taxableSalary.subtract(tax).intValue();
    }

    private static BigDecimal calculateTax(int salary, BigDecimal personalAllowance) {
        final int basicTaxLimit = DEFAULT_BASIC_TAX_LIMIT + personalAllowance.intValue();
        BigDecimal tax = BigDecimal.ZERO;
        if (salary > HIGH_TAX_LIMIT) {
            tax = tax.add(getTaxFor(TOP_TAX_RATE, new BigDecimal(salary - HIGH_TAX_LIMIT)));
        }

        if (salary > basicTaxLimit) {
            tax = tax.add(getTaxFor(HIGH_TAX_RATE, getAmountToTaxFor(HIGH_TAX_LIMIT, salary, new BigDecimal(basicTaxLimit))));
        }

        if (salary > personalAllowance.intValue()) {
            tax = tax.add(getTaxFor(BASIC_TAX_RATE, getAmountToTaxFor(basicTaxLimit, salary, personalAllowance)));
        }
        return tax;
    }

    private static BigDecimal getAmountToTaxFor(int taxLimit, int salary, BigDecimal subtract) {
        return (salary > taxLimit ? new BigDecimal(taxLimit) : new BigDecimal(salary)).subtract(subtract);
    }

    private static BigDecimal getTaxFor(int taxRate, BigDecimal amountToTax) {
        return amountToTax.multiply(new BigDecimal(taxRate).movePointLeft(2));
    }

    public static BigDecimal getPersonalAllowanceFor(int salary) {
        if (salary < FULL_PERSONAL_ALLOWANCE_LIMIT) {
            return new BigDecimal(DEFAULT_PERSONAL_ALLOWANCE_AMOUNT);
        } else if (salary >= TOO_HIGH_SALARY_FOR_PERSONAL_ALLOWANCE) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(DEFAULT_PERSONAL_ALLOWANCE_AMOUNT - (salary - FULL_PERSONAL_ALLOWANCE_LIMIT) / 2);
        }
    }

}
