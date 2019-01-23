package com.zhuzb.dao;

import com.zhuzb.entity.ServiceEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by root on 2018/11/23.
 */
public interface UserRepostory extends JpaRepository<ServiceEntity,Integer> {

    /**
     * 根据用户名称查询用户列表
     * @param serviceName
     * @return
     */
    List<ServiceEntity> findByServiceName(String serviceName);

    @Query(value = "select s from ServiceEntity s where s.serviceName = ?1")
    List<ServiceEntity> findByServiceName123(String serviceName, Sort... sort);

    @Query(value = "SELECT s.*,t.tea_name teaName FROM service_entity s" +
            " left JOIN tea_info t ON t.id = s.tea_id" +
            " WHERE s.service_name =?1", nativeQuery = true)
    List<Map<String,Object>> findByServiceName456(String serviceName);

/*    @Query(value = "select s from ServiceEntity s where s.serviceName = :serviceName")
    List<ServiceEntity> findByServiceName111(@Param("serviceName") String serviceName, Sort... sort);*/
}
