package club.banyuan.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("db")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //csrf，跨越攻击防护
        http.csrf ().disable ()
                //设置静态资源允许所有访问
                .authorizeRequests ()
                //以下路径需要认证，其它路径通过
                .antMatchers ("/admin/**").authenticated ()
                .anyRequest ().permitAll ()
                .and ()
                .formLogin ().loginPage ("/login")
                .defaultSuccessUrl ("/admin")
                .and ()
                .logout ()
                .invalidateHttpSession (true)
                .clearAuthentication (true)
                .logoutUrl ("/logout")
                .logoutSuccessUrl ("/").permitAll ();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // need userDetailService
        provider.setUserDetailsService(userDetailsService);
        // encoder
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

}
