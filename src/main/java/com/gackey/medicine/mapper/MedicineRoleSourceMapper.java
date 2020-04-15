package com.gackey.medicine.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gackey.medicine.entity.MedicineRoleSource;

@Mapper
public interface MedicineRoleSourceMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineRoleSource record);

    int insertSelective(MedicineRoleSource record);

    MedicineRoleSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicineRoleSource record);

    int updateByPrimaryKey(MedicineRoleSource record);
}