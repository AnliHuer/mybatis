package io.twu.yang.mapper;

import io.twu.yang.Address;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;

public interface AddressMapper {

    @Insert("insert into address(street_name) values(#{streetName})")
    @Options(keyProperty = "address_id", useGeneratedKeys = true)
    Integer insert(Address address);

    @Select("SELECT address_id, street_name FROM address where address_Id=#{addressId}")
    @Results(value = {
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "streetName", column = "street_name")
    })
    Address findAddressById(Integer addressId);

    @Insert("insert into address(street_name) values(#{address.streetName})")
    @Options(keyProperty = "address_id", useGeneratedKeys = true)
    Integer insertRecord(HashMap<String, Object> stringAddress);
}
