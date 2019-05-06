import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
//        System.out.println(Main.class.getName());
//        logger.trace("Пишем абсолютно все");
//        logger.debug("Дебаг месседж");
//        logger.info("А то там не так в системе, Информационное сообщение ");
//        logger.warn("Предупреждение, система не должна себя так вести ");
//        logger.error("Ошибка ");

        UserDao userDao = new UserDao();
        userDao.addUser(new User("sasha", "123", "user"));
//        userDao.addUser2(new User("AAA", "111", "Admin"));
//        userDao.getUserByName("s");
//        userDao.getUserById(1L);
    }
}
