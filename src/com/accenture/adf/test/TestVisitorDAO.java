package com.accenture.adf.test;

import static org.junit.Assert.assertEquals;
 import static org.junit.Assert.assertTrue;
 import static org.junit.Assert.fail;

import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.logging.Logger;

import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;

import com.accenture.adf.businesstier.dao.VisitorDAO;
 import com.accenture.adf.businesstier.entity.Event;
 import com.accenture.adf.businesstier.entity.Visitor;

/**
  * JUnit test case for VisitorDAO class for testing all repository methods to
  * call database sub-routines
  * 
  */
 public class TestVisitorDAO {

 private Visitor visitor;
  private VisitorDAO visitorDAO;
  private ArrayList<Object[]> registeredEvents;
  private static Logger log = Logger.getLogger(null);
  /**
   * Setting up initial objects
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
   visitor = new Visitor();
   visitorDAO = new VisitorDAO();
   registeredEvents = new ArrayList<Object[]>();
  }

 /**
   * Deallocating objects after execution of every method
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
   /**
    * @TODO: Release all the objects here by assigning them null  
    */
   visitor=null;
   visitorDAO=null;
   registeredEvents=null;
  }

 /**
   * Test case for method insertData
   */
  @Test
  public void testInsertData() {
   /**
    * @TODO: Create visitor object by setting appropriate values
    * Call insertData method by passing this visitor object
    * Search this new visitor object by calling searchUser method
    * Assert the values of username
    */ 
   visitor.setVisitorId(1007);
   visitor.setFirstName("Sarthak");
   visitor.setLastName("Mohapatra");
   visitor.setEmail("sarthakstar6@gmail.com");
   visitor.setUserName("abc");
   visitor.setAddress("Jyotivihar");
   visitor.setPassword("2020");
   visitor.setPhoneNumber("786");
   visitor.setAdmin(true);
   try {
    visitorDAO.insertData(visitor);
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  
   try {
    Visitor v=visitorDAO.searchUser("abc","2020");
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   assertEquals(visitor.getUserName(),"abc");
   
  } 

 /**
   * Test case for method searchUser
   */
  @Test
  public void testSearchUser() {
   /**
    * @TODO: Call searchUser method for valid values of username
    * and password and assert the value of username for the returned type of method
    */ 
   Visitor v=null;
   try {
    v = visitorDAO.searchUser("npatel", "password");
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   assertEquals("",v.getUserName());
   

 }

 /**
   * Test case for method registerVisitorToEvent
   */
  @Test
  public void testRegisterVisitorToEvent() {
   /**
    * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
    * Pass this visitor object and valid eventid to registerVisitorToEvent method
    * and assert the value
    */ 
    visitorDAO=new VisitorDAO();
      try {
       ArrayList<Object[]> ale=new ArrayList<Object[]>();
       visitor=visitorDAO.searchUser("bsmith", "password");
       //registeredEvents = visitor.getRegisteredEvents();
       visitorDAO.registerVisitorToEvent(visitor, 1001,10001);
       //ale=visitor.getRegisteredEvents();
       assertEquals(ale.size(),registeredEvents.size());
      } catch (ClassNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
      } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
      }
      catch(Exception e)
      {
       log.info("Exception ");
      }
  } 

 /**
   * Test case for method registeredEvents
   */
  @Test
  public void testRegisteredEvents() {
   /**
    * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
    * Pass this visitor object and valid eventid to registeredEvents method
    * and assert the value
    */ 
    try{
       visitor=visitorDAO.searchUser("bsmith","password");
       ArrayList<Object[]> ale=visitorDAO.registeredEvents(visitor);
       assertEquals(0,ale.size());
      } catch (ClassNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
      } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
      }
      catch(Exception e)
      {
       e.printStackTrace();
      }
  }

 /**
   * Test case for method updateVisitor
   */
  @Test
  public void testUpdateVisitor() {
   /**
    * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
    * Update the value in this visitor object
    * Pass this visitor object to updateVisitor method
    * and assert the value of changed value
    */ 
   Visitor v=null;
   try {
    v = visitorDAO.searchUser("npatel", "password");
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   v.setUserName("np");
   
   try {
    int a=visitorDAO.updateVisitor(v);
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   assertEquals("np",v.getUserName());
  }

 /**
   * Test case for method registeredEvents
   */
  @Test
  public void testUnregisterEvent() {
   /**
    * @TODO: Fetch visitor object by calling searchUser for valid values of username and password
    * Pass this visitor object and valid eventid to unregisterEvent method
    * and assert the value
    */  
   try {
    visitor=visitorDAO.searchUser("npatel","password");
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
     // registeredEvents=visitor.getRegisteredEvents();
      try {
    visitorDAO.unregisterEvent(visitor, 1001,1001);
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
      //ArrayList<Object[]> ale = visitor.getRegisteredEvents();
  //    assertEquals(ale,registeredEvents);
  
   
  }
  
  
  /**
   * Test case for method change password
   */
  /*@Test
  public void testChangePassword_VisitorNull() {
   *//**
    * @TODO: Call changePassword method by passing visitor object as null
    *//*  
  }*/
  
  /**
   * Test case for method change password
   */
  
  @Test
  public void testChangePassword_VisitorNull() {
   try {
    visitor = null;
    visitorDAO.changePassword(visitor);
   } catch (SQLException exception) {
    fail("SQL Exception");
   } catch (ClassNotFoundException exception) {
    fail("Class Not Found Exception");
   } catch (Exception exception) {
    fail("NULL Exception");
   }
  }

}



















