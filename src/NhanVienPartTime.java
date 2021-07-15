public class NhanVienPartTime extends NhanVien{
    private int Time;
    public NhanVienPartTime(){

    }
    public NhanVienPartTime(String codeNV,String Name,int Phone,String Email,int Time){
        super(codeNV, Name, Phone, Email);
        this.Time =Time;

    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }
    public int getLuongPartTime(){
       return Time*100000;
    }

    @Override
    public String toString() {
        return "NhanVienPartTime{" +
                "Time=" + Time +
                "} " + super.toString();
    }
}
