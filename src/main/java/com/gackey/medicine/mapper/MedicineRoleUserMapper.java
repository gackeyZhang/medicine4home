package com.gackey.medicine.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gackey.medicine.entity.MedicineRoleUser;

@Mapper
public interface MedicineRoleUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineRoleUser record);

    int insertSelective(MedicineRoleUser record);

    MedicineRoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicineRoleUser record);

    int updateByPrimaryKey(MedicineRoleUser record);
}