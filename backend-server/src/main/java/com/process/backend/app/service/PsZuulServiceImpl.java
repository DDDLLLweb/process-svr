package com.process.backend.app.service;

import com.process.backend.app.mapper.PsZuulMapper;
import com.process.common.domain.PsZuulRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Danfeng
 * @since 2018/12/12
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PsZuulServiceImpl implements PsZuulService {
    private final PsZuulMapper zuulMapper;
    private final RedisTemplate<String, List<PsZuulRouter>> redisTemplate;
    private static final String CACHE_ROUTE_KEY = "CACHE_ROUTES";

    @PostConstruct
    public void initZuulRoutes() {
        redisTemplate.opsForValue().set(CACHE_ROUTE_KEY, zuulMapper.routes());
    }

    @Override
    public List<PsZuulRouter> routes() {
        return zuulMapper.routes();
    }

    @Override
    public void refresh() {
        redisTemplate.delete(CACHE_ROUTE_KEY);
        initZuulRoutes();
    }

}
