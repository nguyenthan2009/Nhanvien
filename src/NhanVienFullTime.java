public class NhanVienFullTime extends NhanVien{
    private int Bonus;
    private int Fine;
    private int Salary;
    public  NhanVienFullTime(){

    }
    public NhanVienFullTime(String codeNV,String Name,int Phone,String Email,int Bonus,int Fine,int Salary){
       super(codeNV, Name, Phone, Email);
       this.Bonus =Bonus;
       this.Fine = Fine;
       this.Salary =Salary;
    }

    public int getBonus() {
        return Bonus;
    }

    public int getFine() {
        return Fine;
    }

    public int getSalary() {
        return Salary;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public void setFine(int fine) {
        Fine = fine;
    }

    @Override
    public String toString() {
        return "NhanVienFullTime{" +
                "Bonus=" + Bonus +
                ", Fine=" + Fine +
                ", Salary=" + Salary +
                "} " + super.toString();
    }
    public int luongFulltime(){
        return Salary+(Bonus-Fine);
    }
}
