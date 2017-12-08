package com.jary.daily.grows.spring.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

/**
 * @author fanzhengjie
 * @version 1.0
 * @create 2017/12/8 下午8:34 Spring cache缓存
 */
public class TempTest {

    @Cacheable(value = "enniuCache", key = "#root.method + '-' + #userId + '-'+ #platform", condition = "#userId > 10000L")
    //使用一个缓存名叫enniuCache
    public UserInfo getUserInfo(Long userId, String platform) {
        //方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userId, platform);
    }

    @CacheEvict(value = "enniuCache", key = "'getUserInfo-' + #userId + '-' + #platform", condition = "#userId != 80000L")
    public void deleteCache(Long userId, String platform) {
        //清空 enniuCache,方法体是会执行的，也可空方法，仅作清除缓存使用。
    }

    @CacheEvict(value = "enniuCache", allEntries = true)// 清空 enniuCache 缓存
    public void deleteAll() {
    }

    @CachePut(value = "enniuCache", key = "'getUserInfo-' + #info.userId + '-' + #info.platform", condition = "#userId > 10000L")// 清空 enniuCache 缓存
    public UserInfo update(UserInfo info) {
        //更新数据库并将返回的新UserInfo放入缓存
        return updateDB(info);
    }


    @Caching(
        put = {
            @CachePut(value = "enniuCache", key = "'getUserInfo-' + #info.userId + '-' + '0'"),
            @CachePut(value = "enniuCache", key = "'getUserInfoByName-' + #info.name")
        },
        cacheable = {
            @Cacheable(value = "enniuCache", key = "'getUserInfo-' + #info.userId + '-' + '0'"),
            @Cacheable(value = "enniuCache", key = "'getUserInfoByName-' + #info.name")
        }
    )
    public UserInfo manual(UserInfo info) {
        //更新数据库并将返回的新UserInfo放入缓存
        return updateDB(info);
    }

    private UserInfo getFromDB(Long userId, String platform) {
        return new UserInfo();
    }

    private UserInfo updateDB(UserInfo userInfo) {
        //数据库操作
        return new UserInfo();
    }

}

class UserInfo {

    private Long userId;

    private String platform;

    private String name;
}
