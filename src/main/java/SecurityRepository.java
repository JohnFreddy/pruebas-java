public interface SecurityRepository {

    boolean signIn(User user);

    UserInfo getUserById(int userId);
}
