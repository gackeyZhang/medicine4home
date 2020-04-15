package com.gackey.medicine.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gackey.medicine.entity.MedicineRoleSourceRelation;

@Mapper
public interface MedicineRoleSourceRelationMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MedicineRoleSourceRelation record);

    int insertSelective(MedicineRoleSourceRelation record);

    MedicineRoleSourceRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MedicineRoleSourceRelation record);

    int updateByPrimaryKey(MedicineRoleSourceRelation record);
}