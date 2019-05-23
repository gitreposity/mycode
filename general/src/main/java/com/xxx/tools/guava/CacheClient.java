package com.xxx.tools.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 缓存
 *
 * @author guodq
 * @create 2018-08-27 下午11:29
 */

public class CacheClient {

    private LoadingCache<Integer, Integer> caches = CacheBuilder.newBuilder()
            .maximumSize(2000)
            .expireAfterWrite(20, TimeUnit.SECONDS)
            .build(new CacheLoader<Integer, Integer>() {
                @Override
                public Integer load(Integer itemId){
                    Integer id = getById(itemId);

                    if(id == null){
                        id = 0;
                    }

                    //不会返回空
                    return id;
                }

                @Override
                public Map<Integer, Integer> loadAll(Iterable<? extends Integer> keys) throws Exception {
                    Map<Integer, Integer> result = Maps.newHashMap();

                    /**
                     * 加载过程
                     */
                    List<Integer> itemIds = Lists.newArrayList(keys);
                    List<Integer> list = queryByIds(itemIds);
                    if(list != null){
                        for(Integer id :list){
                            result.put(id , id);
                        }
                    }
                    return result;
                }
            });


    private Integer getById(Integer id){
        return id;
    }

    private List<Integer> queryByIds(List<Integer> ids){
        System.out.println("db");
        return ids;
    }

    void getByIds(List<Integer> ids){
        try {
            caches.getAll(ids).values();
        } catch (ExecutionException e) {
            System.out.println(e);
        }
    }

}


class Test{
    public static void main(String[] args) {
        CacheClient cacheClient = new CacheClient();
        while (true){
            List<Integer> ids = Lists.newArrayList(1,2,3);
            cacheClient.getByIds(Lists.newArrayList(ids));
        }

    }
}
