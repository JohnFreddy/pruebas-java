public class SecurityBL {
    private SecurityRepository securityRepository;

    public SecurityBL(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;

    }

    public boolean singIn(User user) {

        if(user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }

        return securityRepository.signIn(user);
    }

    public UserResult userIsOld(int userId) {
        UserInfo userById = securityRepository.getUserById(userId);
        UserResult userResult = new UserResult();
        if(userById.getAge() >= 18) {
            userResult.setOld(true);
        }else {
            userResult.setOld(false);
        }
        return userResult;
    }
}
