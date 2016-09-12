import io.twu.yang.domain.Address;
import io.twu.yang.util.MyBatisUtil;
import io.twu.yang.mapper.AddressMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
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
        assertNotNull(mapper.findAddressById(address.getAddressId()));
    }

    @Test
    public void shouldAllAddressSuccessfully() {
        //when

        //given
        Address address = mapper.findAddressById(2);

        //the
        assertThat(address.getAddressId(), is(2l));
    }

    @Test
    public void shouldReturnAddressSuccessfullyUsingConstructor() {
        //when

        //given
        Address address = mapper.findAddressByIdUsingConstructor(2);
        //then
        assertThat(address.getAddressId(), is(2l));
        assertThat(address.getStreetName(), is("pune"));
    }

    @Test
    public void shouldReturnAddressSuccessfullyUsingConstructorAndField() {
        //when

        //given
        Address address = mapper.findAddressByIdUsingConstructorAndField(2l);

        //then
        assertThat(address.getAddressId(), is(2l));
        assertThat(address.getStreetName(), is("pune"));
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.rollback();
    }
}