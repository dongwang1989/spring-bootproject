package cn.zzdz.domain;


import javax.validation.constraints.NotBlank;

public class uuu {

    private Integer userid;
    @NotBlank(message = "{not null}")
    private String username;
    


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
