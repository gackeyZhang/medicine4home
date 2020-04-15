package com.gackey.medicine.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gackey.medicine.entity.MedicineRoleUserRelation;

@Mapper
public interface MedicineRoleUserRelationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineRoleUserRelation record);

    int insertSelective(MedicineRoleUserRelation record);

    MedicineRoleUserRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicineRoleUserRelation record);

    int updateByPrimaryKey(MedicineRoleUserRelation record);
}