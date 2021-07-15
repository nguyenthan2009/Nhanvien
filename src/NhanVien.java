public class NhanVien {
    private String codeNV;
    private String Name;
    private int Phone;
    private String Email;

    public NhanVien() {
    }

    public NhanVien(String codeNV, String Name, int Phone, String Email) {
        this.codeNV = codeNV;
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCodeNV(String codeNV) {
        this.codeNV = codeNV;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public int getPhone() {
        return Phone;
    }

    public String getCodeNV() {
        return codeNV;
    }

    public String getEmail() {
        return Email;
    }


    @Override
    public String toString() {
        return "NhanVien{" +
                "codeNV='" + codeNV + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone=" + Phone +
                ", Email='" + Email + '\'' +
                '}';
    }
}
