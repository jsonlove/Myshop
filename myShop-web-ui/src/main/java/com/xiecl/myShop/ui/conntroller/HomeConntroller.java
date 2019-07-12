package com.xiecl.myShop.ui.conntroller;

import com.xiecl.myShop.commons.util.MapperUtils;
import com.xiecl.myShop.commons.util.MyHttpClients;
import com.xiecl.myShop.ui.api.APIConstans;
import com.xiecl.myShop.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeConntroller {
    @RequestMapping(value = {"","index"})
    public String index(Model model){
        String result = MyHttpClients.doGet(APIConstans.API_CONTENTS_PPT);
        System.out.println(result);
        try {
            List<TbContent> data = MapperUtils.json2listByTree(result, "data", TbContent.class);
            model.addAttribute("ppt",data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }
}
