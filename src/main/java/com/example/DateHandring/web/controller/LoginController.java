package com.example.DateHandring.web.controller;

import static com.example.DateHandring.common.WebConst.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.DateHandring.common.AbstractHtmlController;
import com.example.DateHandring.web.form.LoginForm;

@Controller
public class LoginController extends AbstractHtmlController {

    public String getFunctionName() {
        return "A_LOGIN";
    }

    @ModelAttribute
    LoginForm loginForm(){return new LoginForm();}

    /**
     * ログイン画面表示
     * @return getメソッドの時はログイン画面を表示する
     */
    @GetMapping(LOGINFORM_URL)
    public String loginFrom(){
        return "login/login";
    }

    /**
     * 入力チェック
     *
     * @param form
     * @param br
     * @return
     */
    @PostMapping(LOGINFORM_URL)
    public String index(@Validated @ModelAttribute LoginForm form, BindingResult br) {
        // 入力チェックエラーがある場合は、元の画面にもどる
        if (br.hasErrors()) {
            return "login/login";
        }
        //20190309入力チェックが通った場合は、SecurityConfigで設定した認証処理にフォワードする
        //20190309Postメソッドでなければいけないのでforwardを使う必要がある
        return "forward:" + LOGIN_PROCESSING_URL;
    }

    /**
     * ログイン成功
     */
    @PostMapping("/success")
    public String loginsuccess(@ModelAttribute LoginForm loginForm, Model model,RedirectAttributes redirectAttributes){
        model.addAttribute("msg","loginSuccess");
        return "/login/success";
    }


}