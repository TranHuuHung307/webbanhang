/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Administrator
 */
public class main {
    public static void main(String[] args) {
         LocalDateTime currentDateTime = LocalDateTime.now();
        
        // Định dạng ngày giờ
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        // In ra ngày giờ
        System.out.println("Ngày giờ hiện tại: " + formatter.format(currentDateTime));
    }
}
