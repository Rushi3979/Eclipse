package com.cjc;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;




public class NewTest {
  

@Test (priority = 2)
  public void A() 
  {
	  System.out.println("Test method");
  }
  @Test (enabled = false)
  public void C() 
  {
	  System.out.println("Test method");
  }
  @Test ( priority = 2)
  public void B() 
  {
	  System.out.println("Test method");
  }
  
  
  
  @BeforeMethod 
  public void beforeMethod() 
  {
	  System.out.println("before method");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("after method"); 
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("before class"); 
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("after test");

  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("after suite");
  }

}
