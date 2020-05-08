package Contract;

public class ModelTable {
    String id,name,dob,email,tel,res,proj;

    public ModelTable(String id, String name, String dob, String email, String tel, String res, String proj){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.tel = tel;
        this.res = res;
        this.proj = proj;
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

    public String getProj() {
        return proj;
    }

    public void setProj(String proj) {
        this.proj = proj;
    }


}
