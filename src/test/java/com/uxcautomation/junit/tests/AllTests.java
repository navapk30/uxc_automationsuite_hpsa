/**
 * 
 */
package com.uxcautomation.junit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author tarundeepsharma
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CheckoutWithCCAfterLoginTest.class, UserLoginTest.class, UserRegistrationTest.class })
public class AllTests {

}
