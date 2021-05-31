/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.ProtocolException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proiect.*;

/**
 *
 * @author alladeenPC
 */
public class Tests {
    
    SampleController obj;
    
    public Tests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        obj = new SampleController();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void verifyModerator() throws ClassNotFoundException{
        assertEquals(obj.getMod(), "zebi");
    }
    
    @Test
    public void verifyClients() throws ClassNotFoundException{
        assertTrue(obj.checkClients() == true);
    }
    
    @Test
    public void verifyApi() throws ProtocolException, IOException{
        assertTrue(obj.checkApi("Romania") == true);
    }
}
