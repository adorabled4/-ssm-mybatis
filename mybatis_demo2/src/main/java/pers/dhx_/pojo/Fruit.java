package pers.dhx_.pojo;

/**
 * @author Dhx_
 * @className fruit
 * @description TODO
 * @date 2022/7/21 11:00
 */
public class Fruit {
    private Integer fcount;
    private Double price;
    private String fname;
    private Integer fid;
    private String remark;

    public Fruit(Double price, String fname, Integer fid, String remark) {
        this.price = price;
        this.fname = fname;
        this.fid = fid;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "fcount=" + fcount +
                ", price=" + price +
                ", fname='" + fname + '\'' +
                ", fid=" + fid +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
