package com.example.DateHandring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.DateHandring.service.DateHandringService;

@EnableWebSecurity //セキュリティ設定用クラスにつける
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//データソース
	@Autowired
	private DataSource dataSource;

	@Autowired
	DateHandringService dateHandringService;

	//パスワードエンコーダーのBean定義
	//ログイン時にSpringがパスワードを復号してくれる
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void configure(WebSecurity web) throws Exception{
	//静的リソースを除外
	//静的リソースへのアクセスには、セキュリティを適用しない
		web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**", "/shutdown");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	//静的リソースを除外
	//静的リソースへのアクセスには、セキュリティを適用しない
		 auth.jdbcAuthentication()
	   	 .dataSource(dataSource)
         .passwordEncoder(passwordEncoder());
		 }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//直リンクの禁止
	//ログイン不要ページの設定
		http.authorizeRequests()
		.antMatchers("/loginFrom").permitAll()//ログインフォーム
        .antMatchers("/user/**").permitAll()
        .antMatchers("/new").permitAll()//test用(ユーザ登録)
        .antMatchers("/index").permitAll()//test用(ユーザ登録後の遷移画面）
        .antMatchers("/user/create").permitAll()//test用機能
        .anyRequest().authenticated();
http.formLogin()
        .loginProcessingUrl("/login")
        .loginPage("/loginFrom")
        .failureUrl("/login?error")
        .successForwardUrl("/success")
        .usernameParameter("email")
        .passwordParameter("password");
http.logout()
        .logoutUrl("/logout**")
        .logoutSuccessUrl("/login");
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//ユーザーデータの取得（DB）
//		//ログイン処理時のユーザー情報を、DBから取得する
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.usersByUsernameQuery(USER_SQL)
//		.authoritiesByUsernameQuery(ROLE_SQL)
//		.passwordEncoder(passwordEncoder());
//	}
}
