/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.c;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author USER
 */
@Controller
public class MyController {
    @RequestMapping("/pembayaran")
    public String inputanuser(HttpServletRequest data, Model buah){
        String inputname = data.getParameter("var_name");
        String inputjumlah = data.getParameter("var_jumlah");
        Double cTotal = Double.valueOf(inputjumlah);
        String inputharga = data.getParameter("var_harga");
        Double cHarga = Double.valueOf(inputharga);
        Double HargaTotal = cHarga * cTotal;
        String diskon = "";        
        Double getTotal = null;
        
         if (HargaTotal < 10000)
        {
            getTotal = HargaTotal - (0 * HargaTotal/100);
            diskon = "0%";
        }
        else if (HargaTotal >= 10000 && HargaTotal < 50000)
        {
            getTotal = HargaTotal - (5 * HargaTotal/100);
            diskon = "5%";
        }
        else 
        {
            getTotal = HargaTotal - (10 * HargaTotal/100);
            diskon = "10%";
        } 
        
        buah.addAttribute("name", inputname);
        buah.addAttribute("jumlah", inputjumlah);
        buah.addAttribute("harga", inputharga);    
        buah.addAttribute("diskon", diskon);
        buah.addAttribute("total", getTotal);
        
        return "home";
    }
}
    
    
    
        
    
     
