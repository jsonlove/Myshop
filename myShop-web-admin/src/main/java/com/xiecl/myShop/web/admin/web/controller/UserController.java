package com.xiecl.myShop.web.admin.web.controller;

import com.xiecl.myShop.commons.constans.ConstansUtil;
import com.xiecl.myShop.commons.dto.BaseResult;
import com.xiecl.myShop.commons.dto.UserPage;
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

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private TbUserService userService;

    @RequestMapping("/list")
    public String queryList(HttpServletRequest request, Model model){
        return "user/userlist";
    }

    /**进入添加用户或编辑用户界面数据准备
     * @param request
     * @param mode
     * @return
     */
    @RequestMapping(value = "/userfrom",method = RequestMethod.GET)
    public String userFrom(HttpServletRequest request, Model mode){
        String userid=request.getParameter("id");
        if(userid!=null){
            TbUser user=new TbUser();
            user.setId(userid);
            user=userService.selectUserByid(user);
            mode.addAttribute("tbuser",user);
        }
        return "user/userfrom";
    }

    /**添加用户
     * @param tbUser
     * @param model
     * @param redirectAttributes
     * @return
     */
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
            return "user/userfrom";
        }

    }

    /**批量删除用户
     * @param ids
     * @return
     */
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


    /**删除单个用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public BaseResult deleteUser(@RequestParam(name = "id") String id){
        BaseResult result=new BaseResult();

        if(id==null){
            result.setStatus(ConstansUtil.RESULT_CODE_ERROR);
            result.setMessage(ConstansUtil.RESULT_MESSAGE_REMOVE_ERROR);
        }
        else {
            TbUser user=new TbUser();
            user.setId(id);
            userService.deleteUser(user);
            result.setStatus(ConstansUtil.RESULT_CODE_SUCCESS);
            result.setMessage(ConstansUtil.RESULT_MESSAGE_DELETE_SUCCESS);
        }
        return result;
    }


//    /**页面分页加载
//     * @param request
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value="/gotopage")
//    public UserPage gotoPage(HttpServletRequest request){
//        String strdraw=request.getParameter("draw");
//        String strstart=request.getParameter("start");
//        String strlength=request.getParameter("length");
//        int draw = StringUtils.isBlank(strdraw)?0: Integer.parseInt(strdraw);
//        int start = StringUtils.isBlank(strstart)?0: Integer.parseInt(strstart);
//        int length = StringUtils.isBlank(strlength)?0: Integer.parseInt(strlength);
//        UserPage page = userService.gotoPage(start, length);
//        HttpSession session=request.getSession();
//        session.setAttribute("test","1");
//        page.setDraw(draw);
//        page.setError("");
//        return   page;
//   }

    /**搜索分页加载
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/serachGotopage")
    public UserPage serachGotoPage(HttpServletRequest request){
        String strdraw=request.getParameter("draw");
        String strstart=request.getParameter("start");
        String strlength=request.getParameter("length");
        String serachValue=request.getParameter("serachValue");
        int draw = StringUtils.isBlank(strdraw)?0: Integer.parseInt(strdraw);
        int start = StringUtils.isBlank(strstart)?0: Integer.parseInt(strstart);
        int length = StringUtils.isBlank(strlength)?0: Integer.parseInt(strlength);
        UserPage page=new UserPage();
        if(StringUtils.isBlank(serachValue)) {
             page = userService.gotoPage(start, length);
        }else{
             page = userService.serachgopage(start,length,serachValue);
        }
        page.setDraw(draw);
        page.setError("");

        return  page;
    }
}
