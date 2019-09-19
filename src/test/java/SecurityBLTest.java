import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class SecurityBLTest {

    @Mock
    private SecurityRepository repository;
    private SecurityBL securityBL;

    @Before
    public void setUp() throws Exception {
        securityBL = new SecurityBL(repository);
    }

    @Test
    public void singInMethodShouldReturnFalseWhenEmailIsEmpty() {
        User user = new User("","password");
        boolean result = securityBL.singIn(user);
        Assert.assertFalse(result);
    }

    @Test
    public void singInMethodShouldReturnFalseWhenPasswordIsEmpty() {
        User user = new User("ajajja@gmail.com","");
        boolean result = securityBL.singIn(user);
        Assert.assertFalse(result);
    }


    @Test
    public void singInMethodShouldReturnTrueWhenParamsAreCorrect() {
        User user = new User("john@gmail.com","password");
        Mockito.when(repository.signIn(user)).thenReturn(true);
        boolean result = securityBL.singIn(user);
        Mockito.verify(repository).signIn(user);
        assertTrue(result);
    }

    @Test
    public void shouldBeReturnTrueIfUserIsOld() {
        int userId = 1;
        UserInfo userInfo = new UserInfo("Fredy", 20);
        Mockito.when(repository.getUserById(userId)).thenReturn(userInfo);

        UserResult result = securityBL.userIsOld(userId);
        Mockito.verify(repository).getUserById(userId);
        Assert.assertTrue(result.isOld());
    }

    @Test
    public void shouldBeReturnFalseIfUserIsNotOld() {
        int userId = 1;
        UserInfo userInfo = new UserInfo("Fredy", 17);
        Mockito.when(repository.getUserById(userId)).thenReturn(userInfo);

        UserResult result = securityBL.userIsOld(userId);
        Mockito.verify(repository).getUserById(userId);
        Assert.assertFalse(result.isOld());
    }

}