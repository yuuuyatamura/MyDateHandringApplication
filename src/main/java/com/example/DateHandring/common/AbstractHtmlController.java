package com.example.DateHandring.common;

import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * 基底HTMLコントローラー
 */
@Slf4j
public abstract class AbstractHtmlController extends BaseController {


    public boolean authorityRequired() {
        return true;
    }

    /**
     * 入力チェックエラーがある場合はtrueを返します。
     *
     * @param model
     * @return
     */
    public boolean hasErrors(Model model) {
        val errors = model.asMap().get("errors");

        if (errors != null && errors instanceof BeanPropertyBindingResult) {
            val br = ((BeanPropertyBindingResult) errors);

            if (br.hasErrors()) {
                return true;
            }
        }

        return false;
    }

    /**
     * リダイレクト先に入力エラーを渡します。
     *
     * @param attributes
     * @param result
     */
    public void setFlashAttributeErrors(RedirectAttributes attributes, BindingResult result) {
        attributes.addFlashAttribute("errors", result);
    }
}