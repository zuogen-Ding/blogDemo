package club.banyuan.blog.service;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Qualifier("db")
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userDao.selectUserByName (s);
        if(user!=null){
            return new UserDetailsImpl (user);
        }else throw new UsernameNotFoundException ("user not find");

    }
}
