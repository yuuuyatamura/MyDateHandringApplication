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

@EnableWebSecurity //セキュリティ設定用クラスにつける
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//パスワードエンコーダーのBean定義
	//ログイン時にspringがパスワードを復号してくれる
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//データソース
	@Autowired
	private DataSource dataSource;

	//ユーザーIDとパスワードを取得するSQL文
	private static final String USER_SQL=
			"SELECT"
			+" user_id, password, true"
			+"FROM"
			+" user"
			+"WHERE"
			+" user_id = ?";

	//ユーザーのロールを取得するSQL文
	private static final String ROLE_SQL=
			"SELECT"
			+" user_id, role"
			+"FROM"
			+" user"
			+"WHERE"
			+" user_id = ?";

	@Override
	public void configure(WebSecurity web) throws Exception{

	//静的リソースを除外
	//静的リソースへのアクセスには、セキュリティを適用しない
		web.ignoring().antMatchers("/webjars/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//直リンクの禁止
	//ログイン不要ページの設定
		http.authorizeRequests().antMatchers("/webjars/**") //webjarsへアクセス許可
		.permitAll().antMatchers("/css/**") //cssへのアクセス許可
		.permitAll().antMatchers("/login") //ログインページへの直リンクのOK
		//.permitAll().antMatchers("/register") //日付登録画面は直リンクOK
		.permitAll().anyRequest().authenticated(); //それ以外は直リンク禁止

		http.formLogin().loginProcessingUrl("/login")
		.loginPage("/login") //ログインページの指定　@GetMapping("/login")の部分と一致させる
		.failureUrl("/login") //ログイン失敗時の遷移先
		.usernameParameter("userId") //ログインページのユーザーID
		.passwordParameter("password") //ログインページのパスワード
		.defaultSuccessUrl("/home",true); //ログイン成功時の遷移先

		//CSRF対策を無効に設定（一時的）
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//ユーザーデータの取得（DB）
		//ログイン処理時のユーザー情報を、DBから取得する
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(USER_SQL)
		.authoritiesByUsernameQuery(ROLE_SQL)
		.passwordEncoder(passwordEncoder());
	}
}
