package io.twu.yang.mapper;

import io.twu.yang.domain.Address;
import org.apache.ibatis.annotations.*;

public interface AddressMapper {

    @Insert("insert into address(street_name) values(#{streetName})")
    @Options(keyProperty = "address_id", useGeneratedKeys = true)
    Integer insert(Address address);

    @Select("SELECT address_id, street_name FROM address where address_Id=#{addressId}")
    @Results(value = {
            @Result(property = "addressId", column = "address_id"),
            @Result(property = "streetName", column = "street_name")
    })
    Address findAddressById(long addressId);

    @Select("SELECT address_id, street_name FROM address where address_Id=#{addressId}")
    @ConstructorArgs({
            @Arg(id = true, column = "address_id", javaType = long.class),
            @Arg(column = "street_name", javaType = String.class)
    })
    Address findAddressByIdUsingConstructor(long addressId);

    @Select("SELECT address_id, street_name FROM address where address_Id=#{addressId}")
    @ConstructorArgs({
            @Arg(column = "street_name", javaType = String.class)
    })
    @Results(value = {
            @Result(property = "addressId", column = "address_id"),
    })
    Address findAddressByIdUsingConstructorAndField(long addressId);
}
