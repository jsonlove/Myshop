package com.xiecl.myShop.web.admin.web.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xiecl.myShop.commons.constans.ConstansUtil;
import com.xiecl.myShop.commons.dto.BaseResult;
import com.xiecl.myShop.domain.TbUser;
import com.xiecl.myShop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private TbUserService userService;

    @RequestMapping("/list")
    public String queryList(HttpServletRequest request, Model model){
//        List<TbUser> list=userService.selectAll();
//        if(null!=list||list.size()>0){
//           model.addAttribute("users",list);
//        }
        return "userlist";
    }
    @RequestMapping(value = "/userfrom",method = RequestMethod.GET)
    public String userFrom(HttpServletRequest request, Model mode){
        String userid=request.getParameter("id");
        if(userid!=null){
            TbUser user=new TbUser();
            user.setId(userid);
            user=userService.selectUserByid(user);
            mode.addAttribute("tbuser",user);
        }
        return "userfrom";
    }

    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(TbUser tbUser, Model model, RedirectAttributes redirectAttributes){
        BaseResult result = userService.saveUser(tbUser);
        if(result.getStatus()==200){
            redirectAttributes.addFlashAttribute("result",result);
            return "redirect:/user/list";
        }
        else{
            System.out.println(result.getMessage());
            model.addAttribute("result",result);
            return "/userfrom";
        }

    }
    @RequestMapping(value = "/removeUser")
    @ResponseBody
    public BaseResult removeUser(@RequestParam(name = "ids[]") String[] ids){
        BaseResult result=new BaseResult();

        if(ids==null){
            result.setStatus(ConstansUtil.RESULT_CODE_ERROR);
            result.setMessage(ConstansUtil.RESULT_MESSAGE_REMOVE_ERROR);
        }
        else {
            for (String id :
                    ids) {
                TbUser user = new TbUser();
                user.setId(id);
                userService.deleteUser(user);
                result.setStatus(ConstansUtil.RESULT_CODE_SUCCESS);
                result.setMessage(String.format(ConstansUtil.RESULT_MESSAGE_REMOVE_SUCCESS, ids.length));
            }
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value="/gotopage")
    public Map<String,Object> gotoPage(HttpServletRequest request){
        String strdraw=request.getParameter("draw");
        String strstart=request.getParameter("start");
        String strlength=request.getParameter("length");
        int draw = StringUtils.isBlank(strdraw)?0: Integer.parseInt(strdraw);
        int start = StringUtils.isBlank(strstart)?0: Integer.parseInt(strstart);
        int length = StringUtils.isBlank(strlength)?0: Integer.parseInt(strlength);
        Map<String, Object> map = userService.gotoPage(start, length);
        map.put("draw",draw);
        map.put("error","");
        return map;
    }
}
