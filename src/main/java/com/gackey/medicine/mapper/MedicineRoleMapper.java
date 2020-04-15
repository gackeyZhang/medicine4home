package com.gackey.medicine.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gackey.medicine.entity.MedicineRole;

@Mapper
public interface MedicineRoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineRole record);

    int insertSelective(MedicineRole record);

    MedicineRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicineRole record);

    int updateByPrimaryKey(MedicineRole record);
}