package net.jw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;

@Service
public class UserServiceImpl {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSourc;


    public User registerNewUserAccount(User user) throws SQLException {
        user.setUserPwd(passwordEncoder.encode(user.getUserPwd()));

        Connection connection = dataSourc.getConnection();

        String sql = "insert into jcms_user(USER_LOGIN_ID, USER_NM, USER_PWD) values (?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt .setString(1, user.getUserLoginId());
        stmt .setString(2, user.getUserNm());
        stmt .setString(3, user.getUserPwd());

        int r = stmt .executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        int auto_id = rs.getInt(1);

        sql = "insert into jcms_user_role(USER_ID, ROLE_AUTH) values (?,?)";
        stmt = connection.prepareStatement(sql);

        stmt .setLong(1, auto_id);
        stmt .setString(2, "ROLE_SYSTEM");

        r = stmt .executeUpdate();

        return user;
    }
}
