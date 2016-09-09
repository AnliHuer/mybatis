package io.twu.yang.mapper;

import io.twu.yang.domain.Account;
import io.twu.yang.domain.Address;
import org.apache.ibatis.annotations.*;

public interface AccountMapper {

    @Insert("INSERT INTO account(account_name, address_id) VALUES (#{accountName}, #{address.addressId})")
    int saveAccount(Account account);

    @Select("SELECT address_id, account_id, account_name FROM account")
    @Results({
            @Result(id = true, column = "address_id", property = "accountId"),
            @Result(column = "account_name", property = "accountName"),
            @Result(column = "address_id", property = "address", one = @One(select = "io.twu.yang.mapper.AddressMapper.findAddressById"))
    })
    Account findAccountById(long accountId);

    @Select("SELECT address_id, account_id, account_name FROM account")
    @ConstructorArgs({
            @Arg(column = "address_id", javaType = Address.class, select = "io.twu.yang.mapper.AddressMapper.findAddressById")
    })
    @Results({
            @Result(id = true, column = "address_id", property = "accountId"),
            @Result(column = "account_name", property = "accountName"),
    })
    Account findAccountByIdUsingConstructor(long accountId);

}
