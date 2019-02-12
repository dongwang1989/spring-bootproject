package cn.zzdz.hib;


import cn.zzdz.enums.UserStatus;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;
import java.util.Properties;

public class CustomType implements UserType, ParameterizedType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    @Override
    public Class returnedClass() {
        return UserStatus.class;
    }

    @Override
    public boolean equals(Object o, Object o1) throws HibernateException {
        return Objects.equals(o, o1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    Class<?> clazz;

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        Object obj=null;
        String s = (String) resultSet.getObject(strings[0]);
        Method m;
        try {
            m = clazz.getMethod("getName");
            for (int i = 0; i < this.clazz.getEnumConstants().length; i++) {
                String invoke22 = (String) m.invoke(this.clazz.getEnumConstants()[i]);
                if ((invoke22.equals(s))) {
                    obj=this.clazz.getEnumConstants()[i];
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public UserStatus getEnum(String name) {
        UserStatus c = null;
        for (int i = 0; i < UserStatus.values().length; i++) {
            if (UserStatus.values()[i].getName().equals(name)) {
                c = UserStatus.values()[i];
            }
        }
        return c;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (null == o) {
            preparedStatement.setNull(i, Types.VARCHAR);   //保存空值
        } else {
            String stringValue = String.valueOf(o);
            preparedStatement.setString(i, stringValue);
        }

    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        if (o == null) return null;
        UserStatus cl = (UserStatus) o;
        UserStatus ned = cl;
        return ned;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }

    @Override
    public void setParameterValues(Properties properties) {
        try {
            clazz = Class.forName(properties.get("class").toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
