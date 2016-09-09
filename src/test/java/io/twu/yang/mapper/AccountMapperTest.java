package io.twu.yang.mapper;

import io.twu.yang.domain.Account;
import io.twu.yang.domain.Address;
import io.twu.yang.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountMapperTest {

    private SqlSession sqlSession;
    private AccountMapper mapper;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(AccountMapper.class);
    }

    @Test
    public void shouldReturnAccountSuccessfully() {
        //when

        //given
        Account account = mapper.findAccountById(1);

        //then
        assertThat("yang", is(account.getAccountName()));
        assertThat(account.getAddress().getAddressId(), is(1l));
        assertThat(account.getAddress().getStreetName(), is("chengdu"));
    }

    @Test
    public void shouldSaveAccountSuccessfully() {
        //when
        Account account = new Account();
        account.setAccountName("wen");
//        account.setAddress(new Address(2, "chengdu"));

        //given
        mapper.saveAccount(account);

        //then
    }

    @Test
    public void shouldFindAccountByIdUsingConstructorSuccessfully() {
        //when

        //given
        Account account = mapper.findAccountByIdUsingConstructor(2l);
        //then
        assertThat("yang", is(account.getAccountName()));
        assertThat(account.getAddress().getAddressId(), is(1l));
        assertThat(account.getAddress().getStreetName(), is("chengdu"));

    }

    @After
    public void tearDown() throws Exception {
        sqlSession.rollback();
    }
}