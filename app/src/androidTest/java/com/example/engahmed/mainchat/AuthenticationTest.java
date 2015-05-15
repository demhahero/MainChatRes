package com.example.engahmed.mainchat;

import android.test.AndroidTestCase;

import com.exmaple.engahmed.models.UserModel;


/**
 * Created by EngAhmed on 03/05/2015.
 */
public class AuthenticationTest extends AndroidTestCase {

    Authentication auth = new Authentication();
    UserModel um = new UserModel();
    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();

        um.setUsername("Ahmed");
        um.setPassword("pass");
        auth.login(um);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test Login
     */
    public final void testLogin() {
        Authentication auth = new Authentication();
        boolean res = auth.login(um);
        assertEquals(true,res);
    }

    /**
     * Test Logout
     */
    public final void testLogout() {
        Authentication auth = new Authentication();
        boolean res = auth.logout();
        assertEquals(true,res);

        assertNull(auth.getUserInfo());
    }


    /**
     * Test getUserInfo
     */
    public final void testgetUserInfo() {
        Authentication auth = new Authentication();
        boolean res = auth.login(um);
        assertNotNull(auth.getUserInfo());
    }

    /**
     * Test Logout
     */
    public final void testgetFriends() {
        assertNotNull(auth.getFirendList());
    }

    public final void testRegisterNewUser(){
        Authentication auth = new Authentication();
        UserModel newUser = new UserModel();
        newUser.setUsername("Mohamed");
        newUser.setPassword("pass2");
        boolean res = auth.addNewUser(um);
        assertEquals(true, res);

        res = auth.login(um);
        assertEquals(true, res);
        assertEquals("Mohamed", auth.getUserInfo().getUsername());
    }
}
