package com.order.jdbc.deletequery;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws ClassNotFoundException
    {
    	jdbcDelete jdbcDelete = new jdbcDelete();
    	jdbcDelete.deleteQuery();
        System.out.println( "Hello World!" );
    }
}
