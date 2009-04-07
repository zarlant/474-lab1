/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

/**
 *
 * @author Zacharias
 */
public class DataFilter {
    private String[] input;

    public String[] filter(String s){
           input = s.split(" ");
           return input;
        }
}
