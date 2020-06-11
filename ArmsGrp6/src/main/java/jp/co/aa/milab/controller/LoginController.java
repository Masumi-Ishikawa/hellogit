package jp.co.aa.milab.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.aa.milab.service.UserService;

@Controller
public class LoginController {

		@Autowired
	    UserService userService;
	    @Autowired
	    HttpSession session;


	//ログイン処理
	@GetMapping("/login")
    public String userLogin(@ModelAttribute("message") String message,
                            Model model) {
        model.addAttribute(message);
        return "login";
    }

	 // ログインチェック
    @PostMapping("/login")
    public String userLogin(@RequestParam("id") String id,
                            @RequestParam("pass") String pass,
                            Model model,
                            HttpSession session) {
        String name = userService.searchUserName(id, pass);
        String system = userService.searchUserSystem(id, pass);
        if(name.length() > 0) {
            // 修正：idとnameの値をセッションに保持してログイン中の情報として使う
            session.setAttribute("userid", id);
            session.setAttribute("name", name);
            session.setAttribute("system",system );
            if(system.equals("1")) {
            	return "redirect:/system";
            }
            return "redirect:/home";
        }else {
            model.addAttribute("userid", id);
            model.addAttribute("pass", pass);
            model.addAttribute("error", "IDかPWが間違っています。");
            return "login";
        }
    }

 // ログアウト
    @GetMapping("/logout")
    public String userLogout() {
        session.removeAttribute("userid");
        session.removeAttribute("name");
        return "login";
    }

    // ホーム画面表示
    @GetMapping("/home")
    public String userHome(@ModelAttribute("message") String message,
                           Model model,
                           RedirectAttributes attr) {

        if(null ==  session.getAttribute("userid")) {
            attr.addFlashAttribute("message", "ログインしてください。");
            return "redirect:/login";
        }

        model.addAttribute(message);
        return "home";
    }

    @GetMapping("/system")
    public String system() {
    	return "system";
    }
}
