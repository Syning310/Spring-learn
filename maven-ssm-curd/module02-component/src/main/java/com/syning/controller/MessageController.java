package com.syning.controller;


import com.syning.entity.Message;
import com.syning.entity.User;
import com.syning.service.MessageService;
import com.syning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;


    // 展示消息列表
    @GetMapping(value = "/message")
    public String getAllList(Model model) {

        List<Message> messageList = messageService.getMessageList();

        model.addAttribute("messageList", messageList);

        return "/pages/messagePage";
    }



    // 进入消息详细内容
    @GetMapping(value = "/message/{mid}")
    public String messageDetail(@PathVariable("mid") Integer mid,
                                Model model) {
        // 通过 mid 获取 Message 详细信息
        Message message = messageService.getMessageById(mid);

        // 通过得到的 message 对象的 pid 查找到它的作者返回
        User auth = userService.getUserById(message.getPid());

        // 将从数据库中查询的数据放入 request 作用域中
        model.addAttribute("message", message);
        model.addAttribute("auth", auth);


        return "pages/detail";
    }



    // 添加消息
    @PostMapping("/message/{id}")
    public String addMessage(@PathVariable("id") Integer id,
                             Message message) {

        // 给消息对象补充完整
        message.setPid(id);  // 作者 id
        message.setmDate(new Date());  // 日期
        message.setmStatus("未读");  // 状态

        int ret = messageService.addMessage(message);

        System.out.println(ret > 0 ? "添加成功" : "添加失败");

        return "redirect:/message";
    }


    // 回复消息
    @PutMapping("/message/{mid}")
    public String reply(@PathVariable("mid") Integer mid,
                        @RequestParam("reply") String reply) {
        // 根据传入的 mid，加入这条消息的回复
        messageService.putReply(new Message(mid, null, null, null, null, reply, null));

        return "redirect:/message";
    }

    // 删除消息
    @DeleteMapping("/message/{mid}")
    public String delMessage(@PathVariable("mid") Integer mid) {

        // 根据 mid 删除数据
        messageService.delMessage(mid);

        return "redirect:/message";
    }



}
