package pers.dhx_.mapper;

import pers.dhx_.pojo.Fruit;

import java.util.List;

/**
 * @author Dhx_
 * @className FruitMapper
 * @description TODO
 * @date 2022/7/21 11:00
 */
public interface FruitMapper {

    public  int insertFruit();
    public List<Fruit> getAllFruit();
    public Fruit getFruitById(Integer fid);
    public Fruit deleteFruit(Integer fid);

    public Fruit getFruitByFname(String fname);

    public int updateFruit(Fruit fruit);

    public int addFruit(Fruit fruit);

}
