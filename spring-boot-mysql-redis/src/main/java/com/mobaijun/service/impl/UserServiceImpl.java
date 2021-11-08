package com.mobaijun.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mobaijun.domain.SystemUser;
import com.mobaijun.mapper.SystemUserMapper;
import com.mobaijun.service.SystemUserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/10/21 17:18
 * ClassName:UserServiceImpl
 * 类描述： 实现类
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {

    @Override
    public boolean saveBatch(Collection<SystemUser> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<SystemUser> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    public boolean update(Wrapper<SystemUser> updateWrapper) {
        return super.update(updateWrapper);
    }

    @Override
    public boolean updateBatchById(Collection<SystemUser> entityList) {
        return super.updateBatchById(entityList);
    }

    @Override
    public SystemUser getOne(Wrapper<SystemUser> queryWrapper) {
        return super.getOne(queryWrapper);
    }

    @Override
    public int count() {
        return super.count();
    }

    @Override
    public List<SystemUser> list() {
        return super.list();
    }

    @Override
    public IPage<SystemUser> page(IPage<SystemUser> page) {
        return super.page(page);
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return super.listMaps();
    }

    @Override
    public List<Object> listObjs() {
        return super.listObjs();
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return super.listObjs(mapper);
    }

    @Override
    public List<Object> listObjs(Wrapper<SystemUser> queryWrapper) {
        return super.listObjs(queryWrapper);
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<SystemUser> page) {
        return super.pageMaps(page);
    }

    @Override
    public QueryChainWrapper<SystemUser> query() {
        return super.query();
    }

    @Override
    public LambdaQueryChainWrapper<SystemUser> lambdaQuery() {
        return super.lambdaQuery();
    }

    @Override
    public UpdateChainWrapper<SystemUser> update() {
        return super.update();
    }

    @Override
    public LambdaUpdateChainWrapper<SystemUser> lambdaUpdate() {
        return super.lambdaUpdate();
    }

    @Override
    public boolean saveOrUpdate(SystemUser entity, Wrapper<SystemUser> updateWrapper) {
        return super.saveOrUpdate(entity, updateWrapper);
    }
}
