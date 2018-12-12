package com.process.backend.app.service;

import com.process.backend.app.mapper.PsZuulMapper;
import com.process.common.domain.PsZuulRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


    @Override
    public List<PsZuulRouter> routes() {
        return zuulMapper.routes();
    }

}
