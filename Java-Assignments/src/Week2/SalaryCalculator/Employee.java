package Week2.SalaryCalculator;

public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;
    public Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    public double tax(){ // vergi oranını tax amounta atıp oradan çektim
        double taxAmount; //yüzde 3 olan miktarı direkt alıp aşağıda toplam paradan eksiltriyoruz.
        if (salary < 1000){
            System.out.println("not tax will be applied.");
            return 0;
        }
        else {
            taxAmount = salary * (0.03);
        }
        return taxAmount;
    }
    public int bonus(){ //bonusları aşağıda for döngüsü ile basit bir şekilde yazırdım
        int bonusAmount = 0;
        int overTime;
        overTime = workHours - 40;
        if (overTime > 0){
            for (int i = 1; i <= overTime; i++){
                bonusAmount += 30;
            }
        }
        return bonusAmount;
    }
    public double raiseSalary(){ //burada yıla göre maaş artışı hesabını yazdırıyoruz
        double raiseSalaryAmount;
        int workingYear = 2021 -  hireYear;
        if (workingYear < 10){
            raiseSalaryAmount = salary * 0.05;
        } else if (workingYear > 9 && workingYear < 20 ) {
            raiseSalaryAmount = salary * 0.1;
        }
        else {
            raiseSalaryAmount = salary * 0.15;
        }
        return raiseSalaryAmount;//raise salary ile bu methodtan artış miktarını alıyoruz
    }
    void printInfo(){
        System.out.println("Employee name surname : " + this.name);
        System.out.println("Salary : " + (this.salary - tax() + bonus() + raiseSalary()));
        System.out.println("Work hours : " + this.workHours);
        System.out.println("Hire year : " + this.hireYear);
    }
}
