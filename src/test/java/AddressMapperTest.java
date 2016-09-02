import io.twu.yang.Address;
import io.twu.yang.mapper.AddressMapper;
import io.twu.yang.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddressMapperTest {

    private SqlSession sqlSession;
    private AddressMapper mapper;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(AddressMapper.class);

    }

    @Test
    public void shouldInsertIntoDataBaseSuccessfully() throws Exception {
        //given
        Address address = new Address();
        address.setStreetName("xian");

        //when
        Integer insert = mapper.insert(address);

        //then
        Address addressById = mapper.findAddressById(2);
    }

    @Test
    public void shouldInsertIntoDataBaseAndReturnIdSuccessfully() throws Exception {
        //given
        Address address = new Address();
        address.setStreetName("xian");
        HashMap<String, Object> stringAddress = new HashMap<>();
        stringAddress.put("address_id", 0);
        stringAddress.put("address", address);

        //when
        mapper.insertRecord(stringAddress);

        //then
        //should change this one.
        assertThat(stringAddress.get("address_id"), is(3));
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.rollback();
    }
}