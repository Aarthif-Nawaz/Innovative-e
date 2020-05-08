package Employee;

public class ModelTable1 {
    String id,name,dob,email,tel,res;

    public ModelTable1(String id, String name, String dob, String email, String tel, String res){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.tel = tel;
        this.res = res;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

}
